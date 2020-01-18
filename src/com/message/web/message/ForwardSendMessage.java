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
            //���messageId��Ϊ�գ�˵��Ϊת����������Ҫת�����ʼ�����
            int messageId=Integer.valueOf(temp);
            Message message=messageService.getMessage(messageId);
            req.setAttribute("mail", message);
        }

        //��ѯȫ���û�
        List<User> userList = userService.getUserList();

        //���ص�ǰ��ҳ��
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("sendMessage.jsp").forward(req, resp);

//        //ָ�����صĸ�ʽΪJSON��ʽ
//        resp.setContentType("application/json;charset=utf-8");
//        //setContentType��setCharacterEncoding��˳���ܵ������������޷�����������������
//        resp.setCharacterEncoding("UTF-8");
//
//        //���л�����
//        Gson gson = new Gson();
//        String result = gson.toJson(userList);
//        PrintWriter out = resp.getWriter();
//        out.write(result);
//        out.close();
    }
}
