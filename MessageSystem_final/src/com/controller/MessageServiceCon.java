package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MessageDAO;
import com.model.MessageDTO;

@WebServlet("/MessageServiceCon")
public class MessageServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		String recieve = request.getParameter("recieve");
		String send = request.getParameter("send");
		String content = request.getParameter("content");

		MessageDAO dao = new MessageDAO();
		MessageDTO dto = new MessageDTO(recieve, send, content);
		int cnt = dao.insert(dto);
		
		
		if (cnt > 0) {
			System.out.print("ok");
			HttpSession session = request.getSession();
			session.setAttribute("message_info", dto);					
			response.sendRedirect("main.jsp");
		} else {
			System.out.print("error");
		}
	}

}
