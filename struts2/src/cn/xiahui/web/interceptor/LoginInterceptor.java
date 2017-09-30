package cn.xiahui.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

	private static final long serialVersionUID = 1L;
	//指定不拦截登录方法，其他方法都拦截
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获得session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//获得登录标识
		Object object = session.get("user");
		//判断登录标识是否存在
		if(object == null){
			//不存在=》没登录=》重定向到登录页面
			return "toLogin";
		}else{
			//存在=》已经登录=》放行
			return invocation.invoke();
		}
	}

}
