package com.message.web.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.message.pojo.Message;
import com.message.service.MessageService;
import com.message.service.MessageServiceImpl;

@WebServlet("/messageDetail")
public class MessageDetail extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String temp = request.getParameter("id");

        if (temp == null || "".equals(temp)) {
            request.setAttribute("message", "发生了一些错误");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        int id = Integer.valueOf(temp);

        HttpSession session = request.getSession();
        MessageService ms = new MessageServiceImpl();
        Message message = ms.getMessage(id);
        if (message.getIfAccept() == 1) {
            ms.updateMessageIfAccept(id);
        }

        session.setAttribute("shortms", message);
        response.sendRedirect("messageDetail.jsp");
    }

}
