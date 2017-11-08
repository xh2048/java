package cn.xiahui.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiahui.bos.dao.IUserDao;
import cn.xiahui.bos.domain.Role;
import cn.xiahui.bos.domain.User;
import cn.xiahui.bos.service.IUserService;
import cn.xiahui.bos.utils.MD5Utils;
import cn.xiahui.bos.utils.PageBean;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	/***
	 * 用户登录
	 */
	public User login(User user) {
		
		//使用MD5加密密码
		String password = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(),password);
	}


	/**
	 * 根据用户id修改密码
	 */
	public void editPassword(String id, String password) {
		//使用md5加密密码
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword",password,id);
	}


	/**
	 * 添加一个用户，同时关联角色
	 */
	public void save(User user, String[] roleIds) {
		String password = user.getPassword();
		password = MD5Utils.md5(password);
		user.setPassword(password);
		userDao.save(user);
		if(roleIds != null && roleIds.length > 0){
			for(String roleId : roleIds){
				//手动构造托管对象
				Role role = new Role(roleId);
				//用户对象关联角色对象
				user.getRoles().add(role);
			}
		}
	}


	/**
	 * 分页查询 
	 */
	public void pageQuery(PageBean pageBean) {
		userDao.pageQuery(pageBean);
	}


}
