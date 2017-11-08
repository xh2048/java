package cn.xiahui.bos.realm;

import java.util.List;

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
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xiahui.bos.dao.IFunctionDao;
import cn.xiahui.bos.dao.IUserDao;
import cn.xiahui.bos.domain.Function;
import cn.xiahui.bos.domain.User;

public class BOSRealm extends AuthorizingRealm {

	@Autowired
	private IUserDao userDao;
	@Autowired
	private IFunctionDao functionDao;

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
		//��ȡ��ǰ��¼�û�����
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		//���ݵ�ǰ��¼�û���ѯ���ݿ⣬��ȡʵ�ʶ�Ӧ��Ȩ��
		List<Function> list = null;
		if(user.getUsername().equals("admin")){
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Function.class);
			//��������Ա�����û�����ѯ����Ȩ������
			list = functionDao.findByCriteria(detachedCriteria);
		}else {
			list = functionDao.findFunctionListByUserId(user.getId());
		}
		
		for(Function function : list){
			info.addStringPermission(function.getCode());
		}
		return info;
	}
}
