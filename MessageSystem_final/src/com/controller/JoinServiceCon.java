package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberDTO;

@WebServlet("/JoinServiceCon")
public class JoinServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");

		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(email, pw, tel, addr);
		int cnt = dao.join(dto);

		if (cnt > 0) {
			System.out.print("ok");
			HttpSession session = request.getSession();
			session.setAttribute("id", email);
			response.sendRedirect("join_success.jsp");
		} else {
			System.out.print("error");
			response.sendRedirect("main.jsp");
		}
	}

}
