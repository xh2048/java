package cn.xiahui.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.xiahui.dao.UserDao;
import cn.xiahui.domain.User;
import cn.xiahui.service.UserService;

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
		if(!existU.getUser_password().equals(u.getUser_password())){
			throw new RuntimeException("密码错误！");
		}
		return existU;
	}

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User u) {
		ud.save(u);
	}

}
