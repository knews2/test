package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FrontCommand {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	// 추상메소드 : 구현하지 않는다.
	// execute 를 상속받는 경우에는 무조건 위와 같은 메소드를 생성해야한다.  
}
