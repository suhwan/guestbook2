package com.bit2015.guestbook.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.guestbook.dao.GuestBookDao;
import com.bit2015.guestbook.vo.GuestBookVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String content = request.getParameter("content");
		
		GuestBookVo vo = new GuestBookVo();
		vo.setName(name);
		vo.setPassword(pass);
		vo.setMessage(content);
		
		GuestBookDao dao= new GuestBookDao();
		dao.insert(vo);
		WebUtil.redirect(response, "/guestbook2/gb?a=index");
	}

}
