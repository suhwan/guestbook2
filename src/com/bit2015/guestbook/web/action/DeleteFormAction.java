package com.bit2015.guestbook.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.guestbook.dao.GuestBookDao;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class DeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String no = request.getParameter("no");
		String password = request.getParameter("password");
		
		GuestBookDao dao = new GuestBookDao();
		dao.delete(no, password);
		
		WebUtil.redirect(response,"/guestbook2/gb?a=index");
	}

}
