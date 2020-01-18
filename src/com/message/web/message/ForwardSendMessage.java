package com.message.web.message;

import com.google.gson.Gson;
import com.message.pojo.Message;
import com.message.pojo.User;
import com.message.service.MessageService;
import com.message.service.MessageServiceImpl;
import com.message.service.UserService;
import com.message.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/forwardSendMessage")
public class ForwardSendMessage extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    private MessageService messageService=new MessageServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String temp=req.getParameter("messageId");
        req.removeAttribute("mail");
        if(null!=temp){
            //如果messageId不为空，说明为转发请求，则需要转发的邮件内容
            int messageId=Integer.valueOf(temp);
            Message message=messageService.getMessage(messageId);
            req.setAttribute("mail", message);
        }

        //查询全部用户
        List<User> userList = userService.getUserList();

        //返回到前端页面
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("sendMessage.jsp").forward(req, resp);

//        //指定返回的格式为JSON格式
//        resp.setContentType("application/json;charset=utf-8");
//        //setContentType与setCharacterEncoding的顺序不能调换，否则还是无法解决中文乱码的问题
//        resp.setCharacterEncoding("UTF-8");
//
//        //序列化对象
//        Gson gson = new Gson();
//        String result = gson.toJson(userList);
//        PrintWriter out = resp.getWriter();
//        out.write(result);
//        out.close();
    }
}
