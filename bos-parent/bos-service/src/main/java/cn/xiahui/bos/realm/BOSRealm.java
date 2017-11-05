package cn.xiahui.bos.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xiahui.bos.dao.IUserDao;
import cn.xiahui.bos.domain.User;

public class BOSRealm extends AuthorizingRealm {

	@Autowired
	private IUserDao userDao;

	//��֤����
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("�Զ����realm����֤����ִ���ˡ�������");
		UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
		//���ҳ��������û���
		String username = passwordToken.getUsername();
		User user = userDao.findUserByUsername(username);
		if(user == null){
			//ҳ��������û���������
			return null;
		}
		//����֤��Ϣ����
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
		//��ܸ���ȶ����ݿ��е������ҳ������������Ƿ�һ��
		return info;
	}

	//��Ȩ����
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		return null;
	}
}
