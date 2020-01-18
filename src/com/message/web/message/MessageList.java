package com.message.web.message;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.message.pojo.Page;
import com.message.pojo.User;
import com.message.service.MessageService;
import com.message.service.MessageServiceImpl;


@WebServlet("/messageList")
public class MessageList extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String temp=request.getParameter("index");
		if(temp==null||"".equals(temp)) {
			temp="1";
		}
		
		HttpSession session=request.getSession();
		MessageService ms=new MessageServiceImpl();
		
		User user=(User) session.getAttribute("user");
		int index=Integer.valueOf(temp);
		Page page=ms.getPage(index, 6,user.getId());

		session.setAttribute("page", page);
		response.sendRedirect("messageList.jsp");
	}

}
