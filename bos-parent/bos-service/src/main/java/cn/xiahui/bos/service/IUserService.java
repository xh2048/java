package cn.xiahui.bos.service;

import cn.xiahui.bos.domain.User;

public interface IUserService {
	public User login(User model);

	public void editPassword(String id, String password);

}
