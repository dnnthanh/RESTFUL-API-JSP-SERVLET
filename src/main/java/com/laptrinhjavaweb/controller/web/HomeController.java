package com.laptrinhjavaweb.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/home-page"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 2686801510274002166L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/login.jsp");
			requestDispatcher.forward(request, response);
		} else if (action != null && action.equals("logout")) {

		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/home.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
