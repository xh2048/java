package cn.xiahui.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.xiahui.domain.User;
import cn.xiahui.service.UserService;
import cn.xiahui.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User>{


	private User user = new User();
	private UserService us = new UserServiceImpl();

	
	
	public String login() throws Exception {
		//调用service执行登陆操作
		User u = us.login(user);
		//将返回的User对象放入session域作为登录标识
		ActionContext.getContext().getSession().put("user", u);
		//重定向到项目的首页
		return "toHome";
	}



	@Override
	public User getModel() {
		
		return user;
	}
	
}
