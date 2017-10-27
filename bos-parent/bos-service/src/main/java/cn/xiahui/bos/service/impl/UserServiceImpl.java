package cn.xiahui.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiahui.bos.dao.IUserDao;
import cn.xiahui.bos.domain.User;
import cn.xiahui.bos.service.IUserService;
import cn.xiahui.bos.utils.MD5Utils;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;


	public User login(User user) {
		
		//使用MD5加密密码
		String password = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(),password);
	}


	@Override
	public void editPassword(String id, String password) {
		//使用md5加密密码
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword",password,id);
	}


}
