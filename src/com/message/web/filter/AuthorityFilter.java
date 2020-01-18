package com.message.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "authorityFilter",urlPatterns="/*")
public class AuthorityFilter implements Filter {

	public AuthorityFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest requ = (HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse)response;
		//�����ַ���
		requ.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = requ.getSession();
		String path = requ.getServletPath();
		//��̬�ļ�ֱ�ӷ���
		if(path.endsWith(".css")||path.endsWith(".js")) {
			chain.doFilter(request, response);
			return;
		}
		//���session��userΪnull��������ļȲ��ǵ�½ҳ��Ҳ���Ǵ����½ҳ�棬����ת����½ҳ��
		if (session.getAttribute("user") == null 
				&& !path.endsWith("login") && !path.endsWith("login.jsp")
				&& !path.endsWith("Register") && !path.endsWith("register.jsp")) {
			request.setAttribute("message", "����û�е�½��");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			//����
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
