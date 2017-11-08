package cn.xiahui.bos.service;

import cn.xiahui.bos.domain.User;
import cn.xiahui.bos.utils.PageBean;

public interface IUserService {
	public User login(User model);

	public void editPassword(String id, String password);

	public void save(User model, String[] roleIds);

	public void pageQuery(PageBean pageBean);

}
