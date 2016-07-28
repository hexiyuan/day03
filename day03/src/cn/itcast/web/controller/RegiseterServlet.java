package cn.itcast.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.impl.BusinessServiceImpl;
import cn.itcast.utils.WebUtils;
import cn.itcast.web.formbean.RegisterForm;
//处理注册请求
public class RegiseterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//解决表单中的中文乱码问题：
		request.setCharacterEncoding("utf-8");

		//1.对提交的表单的字段进行合法性校验。把表单数据封装到formbean中。
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b = form.validate();

		//2.如果校验失败，则跳回表单页面，回显校验失败信息。
		if(!b){
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/reginster.jsp").forward(request, response);
			return;
		}
		//3.如果校验成功，则调用servlet处理注册请求。
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.generateID());
		BusinessServiceImpl service = new BusinessServiceImpl();

		try {
			service.register(user);
			//6.如果service处理成功，跳转到网站的全局消息显示页面。为用户显示注册成功的页面消息。
			request.setAttribute("message", "恭喜你，注册成功！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (UserExistException e) {
			//4.如果service处理不成功，并且不成功的原因是注册的用户已经存在。则跳回到注册页面，显示注册的用户已存在。
			form.getErrors().put("username", "对不起，注册用户名已存在！");
			request.setAttribute("form", form);
			//request.setAttribute("message", "注册用户已存在！");
			request.getRequestDispatcher("/WEB-INF/jsp/reginster.jsp").forward(request, response);
			return;
		}catch(Exception e){
			//5.如果service处理不成功，并且不成功的原因是其它问题，则跳转到网站的全局消息显示页面。为用户显示友好错误消息。
			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知异常！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}


