package com.myweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.bbs.service.BbsService;
import com.myweb.bbs.service.GetListServiceImpl;
import com.myweb.bbs.service.RegistServiceImpl;


@WebServlet({"*.bbs", "*.main"})
public class BbsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BbsController() {
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
		
		BbsService service;
		
		if(command.equals("/main.bbs")) {//게시판메인, 게시글 목록
			service = new GetListServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("/bbs/bbs.jsp").forward(request, response);
			
		}else if(command.equals("/writer.bbs")) {//글쓰기화면
			request.getRequestDispatcher("/bbs/bbs_write.jsp").forward(request, response);
		}else if(command.equals("/regist.bbs")) {
			service = new RegistServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("main.bbs");
			
		}else if(command.equals("/index.main")) {
			service = new GetListServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(command.equals("/main.user1")) {
			service = new GetListServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	
		
		
	}
}
