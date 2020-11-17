package com.myweb.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.UserVO;

@WebFilter({"/update.bbs", "/delete.bbs", })
public class BbsFilter2 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		UserVO user = (UserVO)session.getAttribute("user");
		
		if(user == null) {
			res.sendRedirect("/TestWeb/login.user1");
			return;
		}		
		
		String name = user.getName();
		
		String writer = request.getParameter("writer");		
		
		if(writer == null || !name.equals(writer)) {			
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다.')");
			out.println("location.href='/TestWeb/main.bbs';");
			out.println("</script>");
			return;
		}
		chain.doFilter(request, response);
	
	}

}
