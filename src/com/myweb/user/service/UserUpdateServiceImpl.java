package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class UserUpdateServiceImpl implements UserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("ph1") + request.getParameter("ph2") + request.getParameter("ph3");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String address1 = request.getParameter("address1");
		
		HttpSession session = request.getSession();
		UserVO seId = (UserVO)session.getAttribute("user");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = new UserVO(seId.getId(), pw, name, phone, email, address, address1, null);
		
		int result = dao.update(vo);
		
		if(result == 1) { //성공
			session.setAttribute("user", vo);
		}			
		
		return result; //실패
		
	}

}
