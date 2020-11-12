package com.myweb.bbs.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.bbs.model.BbsDAO;
import com.myweb.bbs.model.BbsVO;

public class ContentServiceImpl implements BbsService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bno = request.getParameter("bno");
		
		BbsDAO dao = BbsDAO.getInstance();
		BbsVO vo = dao.getContent(bno);
		
		request.setAttribute("vo", vo);

	}

}
