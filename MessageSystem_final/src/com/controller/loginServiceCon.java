package com.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberDTO;

@WebServlet("/loginServiceCon")
public class loginServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(email, pw);

		MemberDTO loginDTO = dao.login(dto);

		if (loginDTO != null) {
			System.out.print("ok");
			HttpSession session = request.getSession();
			session.setAttribute("info", loginDTO);
		} else {
			System.out.print("error");
		}

		response.sendRedirect("main.jsp");

	}

}
