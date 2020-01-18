package com.message.web.message;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.message.pojo.Message;
import com.message.pojo.User;
import com.message.service.MessageService;
import com.message.service.MessageServiceImpl;
import com.message.service.UserService;
import com.message.service.UserServiceImpl;

@WebServlet("/saveMessage")
public class SaveMessage extends HttpServlet {

    private static MessageService ms = new MessageServiceImpl();

    private static UserService us = new UserServiceImpl();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tempAcceptId = request.getParameter("acceptId");
        String theme = request.getParameter("theme");
        String content = request.getParameter("content");

        if (tempAcceptId == null || "".equals(tempAcceptId)) {
            request.setAttribute("error", "收件人id为空！");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        int acceptId = Integer.valueOf(tempAcceptId);

        HttpSession session = request.getSession();
        User sendUser = (User) session.getAttribute("user");
        Message message = new Message();
        message.setSendId(sendUser.getId());
        message.setAcceptId(acceptId);
        message.setSendTime(new Date());
        message.setAcceptTime(new Date());
        message.setTheme(theme);
        message.setContent(content);
        message.setIfAccept(1);
        if (ms.insertMessage(message)) {
            session.setAttribute("message", "发送成功！");
            response.sendRedirect("/messageList");
        } else {
            request.setAttribute("error", "发生了未知错误");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
    }

}
