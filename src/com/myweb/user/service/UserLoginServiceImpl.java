package com.myweb.user.service;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class UserLoginServiceImpl implements UserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.login(id, pw);
		
		if(user != null) {
			
			String str =user.getPhone();
			String result = str.substring(str.length()-11, str.length()-8);
			String result1 = str.substring(str.length()-8, str.length()-4);
			String result2 = str.substring(str.length()-4, str.length());
			
			String[] resArr = {result, result1, result2};
			
			System.out.println(Arrays.toString(resArr));
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("phone1", resArr);
			return 1;
		}else {
			
			return 0;
		}		
	}

}
