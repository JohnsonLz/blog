package blog.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import blog.service.ArticleService;

@Controller("articleAction")
@Scope("prototype")
public class ArticleAction extends ActionTrans{
	
	@Resource(name="articleService")
	private ArticleService as;
	
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	
	private void httpInit() {
		try {
			request = ServletActionContext.getRequest();
			request.setCharacterEncoding("UTF-8"); 
			response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");	    	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int authorityCheck() {
		if(null == request.getSession().getAttribute("userName"))
				return 0;
		return 1;
	}
	
	public String loadArticle() {		
		try {
			httpInit();
	        PrintWriter pw = response.getWriter();
	        String innerHTML = as.loadArticle();
	        String result = encoding(innerHTML);
	        pw.println(result);
	        pw.flush();
	        pw.close();

		}catch(Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	
	public String publishArticle() {
		try{
			httpInit();
	        PrintWriter pw = response.getWriter();
	        if(authorityCheck()==0) {
	        	pw.write("req");
	        	pw.flush();
	        	pw.close();
	        	return null;
	        }
	    	String title=encoding(request.getParameter("title"));
	        String content = encoding(request.getParameter("content"));
	        String time = encoding(request.getParameter("time"));
	        String name = encoding(request.getSession().getAttribute("userName").toString());	    	
	    	as.SaveArticle(name,title,content,time,0,0);
			return "SUEECSS";
		}catch(Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	public String showAll() {
		try {
			httpInit();
	        PrintWriter pw = response.getWriter();
	        String arg = encoding(request.getParameter("id"));
	        int id = Integer.parseInt(arg);
	        String innerHTML = as.getArticleById(id,1);
	        String result = encoding(innerHTML);
	        pw.println(result);
	        pw.flush();
	        pw.close();

		}catch(Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	
	public String hidePart() {
		try {
			httpInit();
	        PrintWriter pw = response.getWriter();
	        String arg = encoding(request.getParameter("id"));
	        int id = Integer.parseInt(arg);
	        String innerHTML = as.getArticleById(id,0);
	        String result = encoding(innerHTML);
	        pw.println(result);
	        pw.flush();
	        pw.close();

		}catch(Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	
	public String hideReview() {
		try {
			httpInit();
	        PrintWriter pw = response.getWriter();
	        String id = encoding(request.getParameter("id"));
	        String result = Integer.toString(as.getReviewNumber(id));
	        pw.println(result);
	        pw.flush();
	        pw.close();

		}catch(Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	
	public String addZan() {
		try {
			httpInit();
	        PrintWriter pw = response.getWriter();
	        if(authorityCheck()==0) {
	        	pw.write("req");
	        	pw.flush();
	        	pw.close();
	        	return null;
	        }
	        String id = encoding(request.getParameter("id"));
	        as.changeZan(id, 1);

		}catch(Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	
	public String desZan() {		
		try {
			httpInit();
			PrintWriter pw = response.getWriter();
	        if(authorityCheck()==0) {
	        	pw.write("req");
	        	pw.flush();
	        	pw.close();
	        	return null;
	        }
			String id = encoding(request.getParameter("id"));
			as.changeZan(id, 0);

		}catch(Exception e) {
			e.printStackTrace();

		}
		return null;
	}
}
