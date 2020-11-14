package com.myweb.bbs.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.bbs.model.BbsDAO;
import com.myweb.user.model.UserVO;

public class RegistServiceImpl implements BbsService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserVO vo = (UserVO)session.getAttribute("user");
		
		String writer = vo.getName();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BbsDAO dao = BbsDAO.getInstance();
		dao.regist(writer, title, content);		
		
	}

}
