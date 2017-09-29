package cn.xiahui.dao;

import cn.xiahui.domain.User;

public interface UserDao {
	//根据登录名返回user
	User getByUserCode(String user_code);
}
