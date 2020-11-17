package com.myweb.bbs.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.bbs.model.BbsDAO;
import com.myweb.bbs.model.BbsVO;
import com.myweb.bbs.model.PageVO;
import com.myweb.user.model.UserVO;

public class GetUserListServiceImpl implements BbsService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		UserVO user =  (UserVO)request.getSession().getAttribute("user");
		String name = user.getName();
		
		BbsDAO dao = BbsDAO.getInstance();
		
		int pageNum = 1;
		int amount = 10; 
		
		if(request.getParameter("pageNum") != null && request.getParameter("amount") != null ) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		ArrayList<BbsVO> list = dao.getUserList(pageNum, amount,name);
		int total = dao.getTotal();
		PageVO pageVO = new PageVO(pageNum, amount, total);
		
		request.setAttribute("Mylist", list);
		
		request.setAttribute("pageVO", pageVO);		
	}

}
