package blog.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import blog.service.ReviewService;

@Controller("reviewAction")
@Scope("prototype")
public class ReviewAction extends ActionTrans{
	
	@Resource(name="reviewService")
	private ReviewService rs;
	
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
	
	public String loadReview() {
		try {
			httpInit();
	        PrintWriter pw = response.getWriter();
	        String articleID = request.getParameter("id");
	        String result = rs.loadReview(articleID);
	        pw.write(result);
	        pw.flush();
	        pw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String publishReview() {
		try {
			httpInit();
	        PrintWriter pw = response.getWriter();
	        if(authorityCheck()==0) {
	        	pw.write("req");
	        	pw.flush();
	        	pw.close();
	        	return null;
	        }
	        String articleID = request.getParameter("id");
	        String time = request.getParameter("time");
	        String content = request.getParameter("value");
	        String userName =request.getSession().getAttribute("userName").toString();
	        String result = rs.publishReview(articleID, userName, content, time);
	        pw.write(result);
	        pw.flush();
	        pw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
