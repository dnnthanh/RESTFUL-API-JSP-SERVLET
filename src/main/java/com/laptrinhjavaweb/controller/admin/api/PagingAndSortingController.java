package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.service.INewService;

import com.laptrinhjavaweb.pagingandsorting.PagingAndSorting;
import com.laptrinhjavaweb.util.FormUtil;

@WebServlet(urlPatterns = { "/api/articels" })
public class PagingAndSortingController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private INewService newService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PagingAndSorting ps = FormUtil.toModel(PagingAndSorting.class, request);		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> mapData = this.newService.findAll(ps);
		mapper.writeValue(response.getOutputStream(), mapData);
	}
}
