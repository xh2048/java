package cn.xiahui.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.xiahui.dao.UserDao;
import cn.xiahui.domain.User;
import cn.xiahui.service.UserService;
import cn.xiahui.utils.MD5Utils;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService{

	private UserDao ud;

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	@Override
	public User getUserByCodePassword(User u) {
		User existU = ud.getByUserCode(u.getUser_code());
		if(existU==null){
			throw new RuntimeException("用户名不存在！");
		}
		if(!existU.getUser_password().equals(MD5Utils.md5(u.getUser_password()))){
			throw new RuntimeException("密码错误！");
		}
		return existU;
	}

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User u) {
		//调用Dao根据注册的登录名获得用户对象
		User existU = ud.getByUserCode(u.getUser_code());
		if(existU!=null){
			//如果得到user对象，用户名已经存在，抛出异常
			throw new RuntimeException("用户名已经存在");
		}
		
		//使用MD5对密码进行加密
		u.setUser_password(MD5Utils.md5(u.getUser_password()));
		
		//调用Dao执行保存
		ud.save(u);
	}
	

}
