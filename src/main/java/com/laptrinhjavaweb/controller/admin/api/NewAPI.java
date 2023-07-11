package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;

import com.laptrinhjavaweb.util.HttpUtil;

@WebServlet(urlPatterns = { "/api/admin/news" })
public class NewAPI extends HttpServlet {

	private static final long serialVersionUID = -915988021506484384L;

	@Inject
	private INewService newService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.common(request, response);
		ObjectMapper mapper = new ObjectMapper();	
		NewModel newModel = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		newModel = this.newService.save(newModel);
		mapper.writeValue(response.getOutputStream(), newModel);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.common(request, response);
		ObjectMapper mapper = new ObjectMapper();
		NewModel updateNew = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		updateNew = this.newService.update(updateNew);
		mapper.writeValue(response.getOutputStream(), updateNew);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.common(request, response);
		ObjectMapper mapper = new ObjectMapper();
		NewModel deleteNew = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		this.newService.delete(deleteNew.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}

	private void common(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");		
	}
}
