package blog.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import blog.beans.User;
import blog.dao.UserDao;

@Service("userService")
public class UserService {

	@Resource(name="userDao")
	private UserDao dao;
	
	public void Register(User user) {
		
		User u = new User();
		BeanUtils.copyProperties(user, u);
		dao.saveObject(u);
	}
	
	public String check(String userName) {
		
		String HQLString = "from User u where u.userName = '"+userName+"'";
		List list = dao.query(HQLString);
		if(list.size()==0)
			return "true";
		return "false";
	}
	
	public String login(String userName, String password) {

		String HQLString ="from User u where u.userName = '"+userName+"'";
		List list = dao.query(HQLString);
		if(list.size()==0)
			return "id";
		else {
			User u=(User)list.get(0);
			if(u.getPassword().equals(password)){
				return "pass";
			}
			return "password";
		}
	}
}
