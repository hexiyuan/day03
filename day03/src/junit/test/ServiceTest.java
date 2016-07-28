package junit.test;

import java.util.Date;

import org.junit.Test;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.impl.BusinessServiceImpl;

public class ServiceTest {
	@Test
	public void tesRegister(){
		User user = new User();
		user.setUsername("bbb");
		user.setPassword("bbb");
		user.setBirthday(new Date());
		user.setEmail("bb@sina.com");
		user.setId("12421412");
		user.setNickname("lizi");
		BusinessServiceImpl service = new BusinessServiceImpl();
		try {
			service.register(user);
			System.out.println("用户注册成功！。。。");
		} catch (UserExistException e) {
			System.out.println("用户已存在！。。。");
		}
	}
	@Test
	public void testLogin(){
		BusinessServiceImpl service = new BusinessServiceImpl();
		User user = service.login("bbb", "bbb");
		//找到则打印用户 找不到则打印null。
		System.out.println(user);
	}
}
