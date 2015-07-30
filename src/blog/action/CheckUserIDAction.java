package blog.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import blog.service.UserService;

@Controller("checkUserIDAction")
@Scope("prototype")
public class CheckUserIDAction extends ActionTrans {  
	
	@Resource(name="userService")
	private UserService us;
  
    public String execute(){
    	try{
    	HttpServletRequest request = null;
    	request = ServletActionContext.getRequest();
    	request.setCharacterEncoding("UTF-8");
    	HttpServletResponse  response = ServletActionContext.getResponse();
    	response.setContentType("application/json;charset=UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	
        PrintWriter pw = response.getWriter();
        String userName = encoding(request.getParameter("userID"));
        String result = "{\"p\": \""+us.check(userName)+"\"}";
        pw.println(result);  
        pw.flush(); 
    	pw.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }  
} 
