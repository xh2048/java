package cn.xiahui.service;

import cn.xiahui.domain.User;

public interface UserService {
	User getUserByCodePassword(User u);
	void saveUser(User u);
}
