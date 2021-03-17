package com.POJO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.FrontCommand;
import com.model.MessageDAO;

public class DelOneService implements FrontCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = request.getParameter("num");
		MessageDAO dao = new MessageDAO();
		int cnt = dao.DeleteOne(num);

		if (cnt > 0) {
			System.out.print("ok");
		} else {
			System.out.print("error");
		}

		response.sendRedirect("main.jsp#two");

	}

}
