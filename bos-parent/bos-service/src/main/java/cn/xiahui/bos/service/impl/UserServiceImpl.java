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
	 * �û���¼
	 */
	public User login(User user) {
		
		//ʹ��MD5��������
		String password = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(),password);
	}


	/**
	 * �����û�id�޸�����
	 */
	public void editPassword(String id, String password) {
		//ʹ��md5��������
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword",password,id);
	}


	/**
	 * ���һ���û���ͬʱ������ɫ
	 */
	public void save(User user, String[] roleIds) {
		String password = user.getPassword();
		password = MD5Utils.md5(password);
		user.setPassword(password);
		userDao.save(user);
		if(roleIds != null && roleIds.length > 0){
			for(String roleId : roleIds){
				//�ֶ������йܶ���
				Role role = new Role(roleId);
				//�û����������ɫ����
				user.getRoles().add(role);
			}
		}
	}


	/**
	 * ��ҳ��ѯ 
	 */
	public void pageQuery(PageBean pageBean) {
		userDao.pageQuery(pageBean);
	}


}
