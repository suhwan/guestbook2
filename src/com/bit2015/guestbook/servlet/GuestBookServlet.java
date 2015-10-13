package com.bit2015.guestbook.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit2015.guestbook.web.action.GuestBookActionFactory;
import com.bit2015.web.action.Action;
import com.bit2015.web.action.ActionFactory;


@WebServlet("/gb")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String actionName = request.getParameter("a");
		ActionFactory actionFactory = new GuestBookActionFactory(); 
		Action action = actionFactory.getAction(actionName);
		action.execute(request, response);

	}


}
