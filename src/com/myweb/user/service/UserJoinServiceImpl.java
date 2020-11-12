package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class UserJoinServiceImpl implements UserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("ph1") + request.getParameter("ph2") + request.getParameter("ph3");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String address1 = request.getParameter("address1");
		
		UserDAO dao = UserDAO.getInstance();
		
		int result = dao.checkId(id);
		
		if(result == 1) {
			return 1;
		}else {
			dao.join(new UserVO(id, pw, name, phone, email, address, address1, null));
			return 0;
		}
		
		
	}

}
