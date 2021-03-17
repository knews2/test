package com.POJO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.FrontCommand;
import com.model.MemberDAO;
import com.model.MemberDTO;

public class loginService implements FrontCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
