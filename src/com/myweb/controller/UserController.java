package com.myweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.bbs.service.BbsService;
import com.myweb.bbs.service.GetListServiceImpl;
import com.myweb.user.service.UserDeleteServiceImpl;
import com.myweb.user.service.UserJoinServiceImpl;
import com.myweb.user.service.UserLoginServiceImpl;
import com.myweb.user.service.UserService;
import com.myweb.user.service.UserUpdateServiceImpl;


@WebServlet("*.user1")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatchServlet(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatchServlet(request, response);
	}
	
	protected void dispatchServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		
		System.out.println(command);
		
		UserService service;
		BbsService service1;
		
		if(command.equals("/join.user1")) {//회원가입 화면
			
			request.getRequestDispatcher("/user/user_join.jsp").forward(request, response);
			
		}else if(command.equals("/login.user1")) {//로그인 화면
			
			request.getRequestDispatcher("/user/user_login.jsp").forward(request, response);
			
		}else if(command.equals("/joinFrom.user1")) {//회원가입 처리
			service = new UserJoinServiceImpl();
			int result = service.execute(request, response);
			
			if(result == 1) {
				request.setAttribute("msg", "이미 존재하는 회원입니다.");
				request.getRequestDispatcher("/user/user_join.jsp").forward(request, response);
			}else {
				response.sendRedirect("login.user1");
			}
			
			
		}else if(command.equals("/main.user1")) {//메인 화면
			service1 = new GetListServiceImpl();
			service1.execute(request, response);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);			
		}else if(command.equals("/loginFrom.user1")) {//로그인처리
			service = new UserLoginServiceImpl();
			int result = service.execute(request, response);
			
			if(result == 1) {//성공
				response.sendRedirect("mypage.user1");
			}else {
				request.setAttribute("msg", "아이디와 비밀번호를 확인하세요");
				request.getRequestDispatcher("/user/user_login.jsp").forward(request, response);
			}
			
		}else if(command.equals("/mypage.user1")) {//마이페이지
			request.getRequestDispatcher("/user/user_mypage.jsp").forward(request, response);
			
		}else if(command.equals("/logout.user1")) {//로그아웃
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("main.user1");
			
		}else if(command.equals("/mypageinfo.user1")) {//마이페이지정보 수정,삭제
			request.getRequestDispatcher("/user/user_mypageinfo.jsp").forward(request, response);
			
		}else if(command.equals("/update.user1")) {
			service = new UserUpdateServiceImpl();
			int result = service.execute(request, response);
			
			if(result == 1) {
				response.sendRedirect("mypage.user1");
			}else {
				request.setAttribute("msg", "정보 수정에 실패하였습니다. 다시시도 해주세요.");
				request.getRequestDispatcher("/user/user_mypageinfo.jsp").forward(request, response);
			}
			
		}else if(command.equals("/delete.user1")) {
			service = new UserDeleteServiceImpl();
			int result = service.execute(request, response);
			
			if(result == 1) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원탈퇴가 정상 처리되었습니다');");
	    		out.println("location.href='main.user1';");
				out.println("</script>");
			}else {
				request.setAttribute("msg", "비밀번호가 다릅니다. 다시시도 해주세요.");
				request.getRequestDispatcher("/user/user_mypage.jsp").forward(request, response);
			}
		}
		
		
		
		
	}
}
