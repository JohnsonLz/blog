package blog.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import blog.beans.User;
import blog.service.UserService;

@Controller("registerAction")
@Scope("prototype")
public class RegisterAction extends ActionTrans{
	
	@Resource(name="userService")
	private UserService ur;
	
	private User user ;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute() {
		try {
			HttpServletRequest request = null;
	    	request = ServletActionContext.getRequest();
	    	request.setCharacterEncoding("UTF-8");
	    	HttpServletResponse  response = ServletActionContext.getResponse();
	    	response.setContentType("application/json;charset=UTF-8");
	    	response.setCharacterEncoding("UTF-8");
	    	
			user.setUserName(encoding(user.getUserName()));
			user.setPassword(encoding(user.getPassword()));
			user.setEmail(encoding(user.getEmail()));
			ur.Register(user);
			request.getSession().setAttribute("userName", user.getUserName());
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
	      
	       
}
