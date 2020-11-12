package com.myweb.bbs.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BbsService {
	
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
