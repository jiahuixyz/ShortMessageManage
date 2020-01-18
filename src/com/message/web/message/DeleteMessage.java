package com.message.web.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.message.service.MessageService;
import com.message.service.MessageServiceImpl;


@WebServlet("/DeleteMessage")
public class DeleteMessage extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MessageService ms = new MessageServiceImpl();
        String[] temp = request.getParameterValues("id");
        HttpSession session = request.getSession();

        if (temp != null && !(temp.length == 0)) {
            int[] id = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                id[i] = Integer.valueOf(temp[i]);
            }
            if (ms.deleteMessageById(id)) {
                session.setAttribute("message", "删除成功！");
                response.sendRedirect("/messageList");
            } else {
                request.setAttribute("error", "发生了未知错误");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "发生了未知错误");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
