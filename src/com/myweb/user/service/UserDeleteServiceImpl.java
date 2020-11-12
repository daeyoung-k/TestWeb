package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class UserDeleteServiceImpl implements UserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("user");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO result = dao.login(vo.getId(), pw);
		
		if(result == null) {
			return 0;			
		}else {
			int result2 = dao.delete(vo);
			if(result2 == 1) {//삭제
				session.invalidate(); //세션삭제
				return 1;
			}else {
				return 0;
			}
		}
	}

}
