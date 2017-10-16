package cn.xiahui.web.interceptor;

import java.util.Map;

import javax.script.Invocable;

import org.aopalliance.intercept.Invocation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.xiahui.domain.User;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获得session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//获得登录标识
		User user = (User) session.get("user");
		//判断标识是否存在
		if(user != null){
			//存在=>放行
			return invocation.invoke();
		}else{
			//不存在=>重定向到登录页面
			return "toLogin";
		}
	}
	
}
