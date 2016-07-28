package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.utils.ServiceUtils;
//对web层提供所有服务：登陆和注册
public class BusinessServiceImpl {
	//new出了一个具体实现，如果不需要修改则需要使用工厂模式或者Spring。
	private UserDao dao = new UserDaoImpl();
	 
	//1.提供注册服务
	public void register(User user) throws UserExistException{
		//先判断当前注册的用户是否存在
		boolean b = dao.find(user.getUsername());
		if(b){
			//发现注册用户已经存在，则给web层抛出一个编译时异常。
			throw new UserExistException();
		}else{
			//密码需要转变成md5码来保存
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			dao.add(user);
		}
	}
	
	//2.提供登陆服务
	public User login(String username,String password){
		password = ServiceUtils.md5(password);
		return dao.find(username, password);
	}

}
