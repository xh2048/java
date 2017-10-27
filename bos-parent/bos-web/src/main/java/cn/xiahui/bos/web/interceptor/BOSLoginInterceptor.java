package cn.xiahui.bos.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.xiahui.bos.domain.User;
import cn.xiahui.bos.utils.BOSUtils;

public class BOSLoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		ActionProxy proxy = invocation.getProxy();
		String actionName = proxy.getActionName();
		String namespace = proxy.getNamespace();
		String url = namespace + actionName;
		System.out.println(url);
		//��session�л�ȡ�û�����
		User user = BOSUtils.getLoginUser();
		if(user == null){
			//û�е�¼����ת����¼ҳ��
			return "login";
		}
		//����
		return invocation.invoke();
	}

}