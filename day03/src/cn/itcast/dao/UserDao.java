package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {

	//根据业务需求来写（大部分是增删改查部分）
	void add(User user);

	User find(String username, String password);

	//查找注册的用户是否在数据库中存在
	boolean find(String username);

}