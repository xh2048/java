package cn.xiahui.bos.dao.impl;

import java.io.Serializable;
import java.util.List;

import cn.xiahui.bos.dao.IUserDao;
import cn.xiahui.bos.dao.base.impl.BaseDaoImpl;
import cn.xiahui.bos.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	/**
	 * �����û����������ѯ�û�
	 */
	public User findUserByUsernameAndPassword(String username, String password) {
		String hql = "FROM User u WHERE u.username = ? AND u.password = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username,password);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}