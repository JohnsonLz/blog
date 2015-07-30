package blog.filter;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{  
	  
    /** 
     *  
     */  
    private static final long serialVersionUID = -4409507846064552966L;

	@Override
	protected String doIntercept(ActionInvocation invoker) throws Exception {
        Object loginUserName = ActionContext.getContext().getSession().get("userName");  
        if(null == loginUserName){  
            return Action.LOGIN;  // 这里返回用户登录页面视图  
        }  
        return invoker.invoke();  
	}  
  
 
 
  
}  
