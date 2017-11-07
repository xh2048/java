package cn.xiahui.bos.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
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
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//Ϊ�û���Ȩ
		info.addStringPermission("staff-list");
		
		//TODO ������Ҫ�޸�Ϊ���ݵ�ǰ��¼�û���ѯ���ݿ⣬��ȡʵ�ʶ�Ӧ��Ȩ��
		User user1 = (User) SecurityUtils.getSubject().getPrincipal();
		User user2 = (User) principals.getPrimaryPrincipal();
		System.out.println(user1 == user2);
		return info;
	}
}
