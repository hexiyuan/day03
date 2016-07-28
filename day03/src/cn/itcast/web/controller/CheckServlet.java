package cn.itcast.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.web.formbean.RegisterForm;
//采用ajax来异步检测注册页面输入用户名是否已经存在于数据库。
public class CheckServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userDaoImpl = new UserDaoImpl();
//		Map<String, String> errors = new HashMap<String, String>();
//		RegisterForm registerForm = new RegisterForm();
		String username = request.getParameter("username");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (userDaoImpl.find(username)) {
//			errors.put("username", "用户名已经存在！请使用其它用户名注册。");
//			registerForm.setErrors(errors);
			out.println("[" + username + "]用户名已经被使用...");
		} else {
//			errors.put("username", "用户名可以使用！");
//			registerForm.setErrors(errors);
			out.println("[" + username + "]用户名可以使用...");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
