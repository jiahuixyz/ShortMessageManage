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
		//设置字符集
		requ.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = requ.getSession();
		String path = requ.getServletPath();
		//静态文件直接放行
		if(path.endsWith(".css")||path.endsWith(".js")) {
			chain.doFilter(request, response);
			return;
		}
		//如果session内user为null，且请求的既不是登陆页面也不是处理登陆页面，将其转到登陆页面
		if (session.getAttribute("user") == null 
				&& !path.endsWith("login") && !path.endsWith("login.jsp")
				&& !path.endsWith("Register") && !path.endsWith("register.jsp")) {
			request.setAttribute("message", "您还没有登陆！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			//放行
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
