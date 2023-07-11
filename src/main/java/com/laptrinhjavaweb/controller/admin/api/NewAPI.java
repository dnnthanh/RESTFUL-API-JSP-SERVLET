package com.laptrinhjavaweb.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.pagingandsorting.PagingAndSorting;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.util.FormUtil;
import com.laptrinhjavaweb.util.HttpUtil;
import com.laptrinhjavaweb.util.SessionUtil;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/api/admin/articles/*"})
public class NewAPI extends HttpServlet {

    private static final long serialVersionUID = -915988021506484384L;

    @Inject
    private INewService newService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PagingAndSorting ps = FormUtil.toModel(PagingAndSorting.class, request);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapData = new HashMap<>();
        if(ps == null){
            Long id = Long.parseLong(request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")));
            mapData = this.newService.findById(id);
        }else{
            mapData = this.newService.findAll(ps);
        }

        mapper.writeValue(response.getOutputStream(), mapData);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        this.common(request, response);
        ObjectMapper mapper = new ObjectMapper();
        NewModel newModel = HttpUtil.of(request.getReader()).toModel(NewModel.class);
        UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        newModel.setCreatedBy(model.getUsername());
        newModel = this.newService.save(newModel);
        mapper.writeValue(response.getOutputStream(), newModel);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        this.common(request, response);
        ObjectMapper mapper = new ObjectMapper();
        NewModel updateNew = HttpUtil.of(request.getReader()).toModel(NewModel.class);
        UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        updateNew.setModifiedBy(model.getUsername());
        updateNew = this.newService.update(updateNew);
        mapper.writeValue(response.getOutputStream(), updateNew);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

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
