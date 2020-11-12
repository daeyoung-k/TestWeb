package com.myweb.bbs.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.bbs.model.BbsDAO;
import com.myweb.bbs.model.BbsVO;
import com.myweb.bbs.model.PageVO;

public class GetListServiceImpl implements BbsService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BbsDAO dao = BbsDAO.getInstance();
		
		int pageNum = 1;
		int amount = 10; 
		
		if(request.getParameter("pageNum") != null && request.getParameter("amount") != null ) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		ArrayList<BbsVO> list = dao.getList(pageNum, amount);
		int total = dao.getTotal();
		PageVO pageVO = new PageVO(pageNum, amount, total);
		
		request.setAttribute("list", list);
		
		request.setAttribute("pageVO", pageVO);
		
	}

}
