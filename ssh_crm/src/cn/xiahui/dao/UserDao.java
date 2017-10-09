package cn.xiahui.dao;

import cn.xiahui.domain.User;

public interface UserDao {
	User getByUserCode(String usercode);

	void save(User u);
}
