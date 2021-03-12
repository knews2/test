package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MessageDAO;

@WebServlet("/DelOneServiceCon")
public class DelOneServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
