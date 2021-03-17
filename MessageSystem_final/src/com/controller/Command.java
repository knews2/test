package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.POJO.DelAllService;
import com.POJO.DelOneService;
import com.POJO.JoinService;
import com.POJO.LogoutService;
import com.POJO.MessageService;
import com.POJO.UpdateService;
import com.POJO.loginService;
import com.model.MemberDAO;
import com.model.MemberDTO;
import com.model.MessageDAO;
import com.model.MessageDTO;

@WebServlet("*.do")
public class Command extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String URI = request.getRequestURI();
		String path = request.getContextPath();
		String resultURI = URI.substring(path.length() + 1);

		System.out.println(resultURI);

		FrontCommand command = null;

		if (resultURI.equals("DelAllServiceCon.do")) {  // 이게 전 코드인데 헐..ㅋㅋㅋㅋㅋㅋ헐..ㅋㅋㅋ 감사합니다..
			command = new DelAllService();
		} else if (resultURI.equals("DelOneServiceCon.do")) {
			command = new DelOneService();
		} else if (resultURI.equals("JoinServiceCon.do")) {
			command = new JoinService();
		} else if (resultURI.equals("loginServiceCon.do")) {
			command = new loginService();
		} else if (resultURI.equals("LogoutServiceCon.do")) {
			command = new LogoutService();
		} else if (resultURI.equals("MessageServiceCon.do")) {
			command = new MessageService();
		} else if (resultURI.equals("UpdateServiceCon.do")) {
			command = new UpdateService();
		}
		command.execute(request, response);
	}
}
