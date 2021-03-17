package com.POJO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.FrontCommand;
import com.model.MessageDAO;
import com.model.MessageDTO;

public class MessageService implements FrontCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
