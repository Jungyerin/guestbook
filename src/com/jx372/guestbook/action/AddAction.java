package com.jx372.guestbook.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jx372.emaillist.dao.EmailListDao;
import com.jx372.emaillist.vo.EmailListVo;
import com.jx372.web.action.Action;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String message = request.getParameter("message");
		
		System.out.println(name+" "+pwd+" "+message);

		EmailListVo vo = new EmailListVo();
		vo.setName(name);
		vo.setPwd(pwd);
		vo.setMessage(message);

		new EmailListDao().insert(vo);

		//redirect 응답
		response.sendRedirect(request.getContextPath()+"/gb"); 

	}

}
