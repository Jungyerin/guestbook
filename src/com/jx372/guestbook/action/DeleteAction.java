package com.jx372.guestbook.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jx372.emaillist.dao.EmailListDao;
import com.jx372.emaillist.vo.EmailListVo;
import com.jx372.web.action.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tempno=request.getParameter("no");
		Long no=Long.parseLong(tempno);
		String pwd = request.getParameter("pwd");

		System.out.println(no+" "+pwd);

		EmailListVo vo = new EmailListVo();
		vo.setNo(no);
		vo.setPwd(pwd);

		new EmailListDao().delete(no, pwd);

		//redirect 응답
		response.sendRedirect(request.getContextPath()+"/gb"); 

	}

}
