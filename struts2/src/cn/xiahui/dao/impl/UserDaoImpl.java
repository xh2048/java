package cn.xiahui.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.xiahui.dao.UserDao;
import cn.xiahui.domain.User;
import cn.xiahui.utils.HibernateUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User getByUserCode(String user_code) {
		//HQL查询
		//获得session
		Session session = HibernateUtils.getCurrentSession();
		//书写hql
		String hql = "from User where user_code = ?";
		//创建查询对象
		Query query = session.createQuery(hql);
		//设置参数
		query.setParameter(0, user_code);
		//执行查询
		User u = (User) query.uniqueResult();
		return u;
	}

}
