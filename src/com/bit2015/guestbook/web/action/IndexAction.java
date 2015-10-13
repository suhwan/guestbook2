package com.bit2015.guestbook.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.guestbook.dao.GuestBookDao;
import com.bit2015.guestbook.vo.GuestBookVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GuestBookDao dao = new GuestBookDao();
		List<GuestBookVo> list = dao.getList();
		request.setAttribute("list", list);
		WebUtil.forwarding(request, response, "/views/index.jsp");
	}

}
