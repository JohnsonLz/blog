package blog.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import blog.beans.Article;
import blog.beans.Review;
import blog.beans.User;
import blog.dao.BaseDao;

@Service("reviewService")
public class ReviewService {

	@Resource(name="reviewDao")
	private BaseDao dao;
	
	public void save(Review review) {
		Review r = new Review();
		BeanUtils.copyProperties(review,r);
		dao.saveObject(r);
	}
	
	public void saveReview(String articleID, String name, String content, String time) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		BaseDao db = (BaseDao)ctx.getBean("userDao");
		User user = (User)db.queryByItem("userName", " = '"+name+"'").get(0);
		db = (BaseDao)ctx.getBean("articleDao");
		Article article = (Article)db.queryByItem("articleID", " = "+articleID).get(0);
		
		Review review = new Review();
		review.setArticle(article);
		review.setContent(content);
		review.setTime(time);
		if(article.getUser().getUserID()==user.getUserID()) 
			review.setUser(article.getUser());
		else
			review.setUser(user);
		save(review);
	}
	
	public String loadReview(String articleID) {
		String HQLString ="from Review r where r.article.articleID = "+articleID+" order by r.reviewID desc";
		List list = dao.query(HQLString);
		int number = list.size();
		String result = "<label for='rt"+articleID+"' class='sr-only'>title</label>";
		result =result+"<textarea type='text' id='rt"+articleID+"' class ='review-edit' placeholder='你的评论...' required='' autocomplete='off' resize='none'"; 
		result = result+" onpropertychange='editChange(this)' oninput='editChange(this)'></textarea>";
		result = result+"<button class='review-button' type='submit' id='rb"+articleID+"' onclick = 'publishReview(this);return false'>发表评论</button>";
		result = result+"<ul id='rl"+articleID+"'>";
		
		for(int i=0;i<number;i++) {
			Review r = (Review)list.get(i);
			result =result+"<li><p class='review-time'>"+r.getTime()+"   "+r.getUser().getUserName()+"</p>";
			result = result+"<p class='review-p'>"+r.getContent()+"</p></li>";
		}
		result = result +"</ul>";
		return result;
	}
	
	public String publishReview(String articleID, String name, String content, String time) {
		saveReview(articleID, name, content, time);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		BaseDao bd = (BaseDao)ctx.getBean("articleDao");
		String SQLString = "update article set reviewNumber = reviewNumber+1 WHERE articleID = "+articleID; 
		bd.exceBySQL(SQLString);
		String result ="<li><p class='review-time'>"+time+"   "+name+"</p>";
		result = result+"<p class='review-p'>"+content+"</p></li>";
		return result;
	}
}
