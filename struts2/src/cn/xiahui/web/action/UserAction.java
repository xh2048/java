package cn.xiahui.web.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.xiahui.domain.User;
import cn.xiahui.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 1L;
	
	private User user = new User();

	
	
	public String login() throws Exception {
		
		//获得spring容器=>从Application域获得即可

		//获得servletContext对象
		ServletContext sc = ServletActionContext.getServletContext();
		//从sc中获得ac容器
		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		//从容器中获得CustomerService
		UserService us = (UserService) ac.getBean("userService");
		
		
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
