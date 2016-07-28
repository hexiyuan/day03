package junit.test;

import java.util.Date;

import org.junit.Test;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;

public class UserDaoTest {

	@Test
	public void testAdd(){
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("bbb@sina.com");
		user.setId("23432423");
		user.setNickname("栗子");
		user.setPassword("123");
		user.setUsername("bbb");
		
		UserDao dao = new UserDaoImpl();
		dao.add(user);
	}
	@Test
	public void testFind(){
		UserDao dao = new UserDaoImpl();
		dao.find("aaa","123");
	}

	@Test
	public void testFindUser(){
		UserDao dao = new UserDaoImpl();
		System.out.println(dao.find("aaa"));
	}
}
