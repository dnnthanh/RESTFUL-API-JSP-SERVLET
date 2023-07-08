package com.laptrinhjavaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.service.ICategoryService;

@WebServlet(urlPatterns = { "/trang-chu" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 2686801510274002166L;

	@Inject
	private ICategoryService categoryService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("categories", this.categoryService.findAll());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/home.jsp");
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
