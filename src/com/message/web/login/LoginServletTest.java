package com.message.web.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.message.pojo.User;
import com.message.service.UserService;
import com.message.service.UserServiceImpl;

@WebServlet("/login")
public class LoginServletTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remeberMe = request.getParameter("remeberMe");

        if (username == null || "".equals(username)) {
            request.setAttribute("error", "用户名不能为空！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        if (password == null || "".equals(password)) {
            request.setAttribute("error", "密码不能为空！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        UserService us = new UserServiceImpl();
        if (us.login(username, password)) {
            User user = us.getUser(username);
            session.removeAttribute("user");
            session.removeAttribute("error");
            //设置sesssion
            session.setAttribute("user", user);
            //设置cookie
            if (null != remeberMe) {
                // 创建 Cookie
                Cookie usernameCookie = new Cookie("username", username);
                Cookie passwordCookie = new Cookie("password", password);
                // 为两个 Cookie 设置过期日期为 10天后
                usernameCookie.setMaxAge(60 * 60 * 24 * 10);
                passwordCookie.setMaxAge(60 * 60 * 24 * 10);
                // 在响应头中添加两个 Cookie
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }
            response.sendRedirect("/messageList");
        } else {
            request.setAttribute("error", "用户名和密码不匹配！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
