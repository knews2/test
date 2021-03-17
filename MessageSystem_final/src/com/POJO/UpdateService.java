package com.POJO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.FrontCommand;
import com.model.MemberDAO;
import com.model.MemberDTO;

public class UpdateService implements FrontCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");

		HttpSession session = request.getSession();
		MemberDTO loginDTO = (MemberDTO) session.getAttribute("info");
		String email = loginDTO.getEmail();

		MemberDTO info = new MemberDTO(email, pw, tel, addr);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.update(info);

		if (cnt > 0) {
			System.out.print("ok");
			session.setAttribute("info", info);
			response.sendRedirect("main.jsp");
		} else {
			System.out.print("error");
			response.sendRedirect("update.jsp");
		}

	}

}
