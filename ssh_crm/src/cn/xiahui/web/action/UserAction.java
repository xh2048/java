package cn.xiahui.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.xiahui.domain.User;
import cn.xiahui.service.UserService;

public class UserAction  extends ActionSupport implements ModelDriven<User>{
	
	private UserService userService;
	private User user = new User();

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
		User u = userService.getUserByCodePassword(user);
		ActionContext.getContext().getSession().put("user", u);
		return "toHome";
	}

	@Override
	public User getModel() {
		
		return user;
	}

	
}
