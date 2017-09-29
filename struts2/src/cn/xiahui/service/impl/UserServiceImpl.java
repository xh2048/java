package cn.xiahui.service.impl;

import cn.xiahui.dao.UserDao;
import cn.xiahui.dao.impl.UserDaoImpl;
import cn.xiahui.domain.User;
import cn.xiahui.service.UserService;
import cn.xiahui.utils.HibernateUtils;

public class UserServiceImpl implements UserService {

	private UserDao ud = new UserDaoImpl();

	@Override
	public User login(User user) {
		//打开事务
		HibernateUtils.getCurrentSession().beginTransaction();
		//调用Dao根据登录名查询User对象
		User existU = ud.getByUserCode(user.getUser_code());
		//提交事务
		HibernateUtils.getCurrentSession().getTransaction().commit();
		
		if(existU==null){
			//获得不到=>抛出异常提示用户名不存在
			throw new RuntimeException("用户名不存在！");
		}
		
		//比对密码是否一致
		if(!existU.getUser_password().equals(user.getUser_password())){
			//不一致-》抛出异常提示密码错误
			throw new RuntimeException("密码错误！");
		}
		
		//将数据库查询的User返回
		return existU;
	}

}
