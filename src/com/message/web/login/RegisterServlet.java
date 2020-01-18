package com.message.web.login;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.message.pojo.User;
import com.message.service.UserService;
import com.message.service.UserServiceImpl;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String mail=request.getParameter("iphone");
		
		if(username==null||"".equals(username)) {
			request.setAttribute("error","用户名不能为空！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		if(password==null||"".equals(password)) {
			request.setAttribute("error","密码不能为空！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		if(mail==null||"".equals(mail)) {
			request.setAttribute("error","邮箱不能为空！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		
		UserService us=new UserServiceImpl();
		User user=new User();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setCreateTime(new Date());
		user.setMailAccount(mail);
		
		int result=us.register(user);
		if(result==-1) {
			request.setAttribute("error","该用户已存在！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		if(result==1) {
			response.sendRedirect("login.jsp");
			return;
		}
		if(result==0) {
			request.setAttribute("error","注册发生了未知错误");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
	}

}
