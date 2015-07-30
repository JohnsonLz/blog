package blog.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import blog.beans.Article;
import blog.beans.User;
import blog.dao.BaseDao;
import blog.dao.UserDao;

@Service("articleService")
public class ArticleService {
	
	@Resource(name="articleDao")
	private BaseDao dao;
	
	public void Save(Article article) {
		Article a = new Article();
		BeanUtils.copyProperties(article,a);
		dao.saveObject(a);
	}
	
	public void SaveArticle(String name, String title, String content, String time, int reviwerNumber, int zanNumber) {
    	@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao ud = (UserDao) ctx.getBean("userDao");
        Article article = new Article();
        
        User u =(User)ud.queryByItem("userName", " = '"+name+"'").get(0);        
        article.setUser(u);       
        article.setContent(content);
        article.setTitle(title);
        article.setTime(time);
        article.setReviewNumber(0);
        article.setZannNumber(0);
        Save(article);
	}
	
	public String loadArticle() {
		String HQLString = "from Article a order by a.articleID desc";
		List list = dao.query(HQLString, 10);
		String result = "";
		
		int number = list.size();
		for(int i=0;i<number;i++) {
			Article article = (Article)list.get(i);
			result += "<hr><hr>";
			result = result + "<h3 class='blog-post-title'>"+article.getTitle()+"</h3>";
            result = result + "<p class='blog-post-meta'>"+article.getTime()+" by "+article.getUser().getUserName()+"</p>";
            result = result + "<pre class='blog-post-text' id = '"+article.getArticleID()+"'>" + article.getContent().substring(0, 250) + "...... <a class='href-all' href='' onclick='showAll(this);return false'>查看全部</a></pre>";
            result = result + "<div>"+	"<span id='zan"+article.getArticleID()+"' class='glyphicon glyphicon-heart-empty' aria-hidden='true' onclick= 'zan(this)'></span>";
    		result = result + "<span class='zan-span' id='zanNumber"+article.getArticleID()+"'>"+article.getZanNumber()+"赞</span><span class='glyphicon glyphicon-align-left' aria-hidden='true'></span>";
    		result = result + "<a class='href-review' href='' onclick='showView(this);return false' id='sr"+article.getArticleID()+"'>"+article.getReviewNumber()+"条评论</a></div>";
			result = result +"<div id='review"+article.getArticleID()+"' class='review-container'></div> ";
		}
		return result;
	}
	
	public String getArticleById(int id,int type) {
		List list = dao.queryByItem("articleID"," = "+id);
		Article article = (Article)list.get(0);
		if(type==1) 
			return article.getContent()+"<a class='href-all' href='' onclick='hidePart(this);return false'>收起</a>";
		else
			return article.getContent().substring(0, 250)+"...... <a class='href-all' href='' onclick='showAll(this);return false'>查看全部</a></pre>";
	}
	
	public int getReviewNumber(String id) {
		List list = dao.queryByItem("articleID", " = "+id);
		Article article = (Article)list.get(0);
		return article.getReviewNumber();
	}
	
	public void changeZan(String id, int type) {
		String SQLString;
		if(type == 1) {
			SQLString = "update article set zanNumber = zanNumber+1 WHERE articleID = "+id; 
		}else {
			SQLString = "update article set zanNumber = IF(zanNumber<1, 0, zanNumber-1) WHERE articleID = "+id;
		}
		dao.exceBySQL(SQLString);
	}
	

}
