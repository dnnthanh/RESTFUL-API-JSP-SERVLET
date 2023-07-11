package com.laptrinhjavaweb.controller.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/articles"})
public class NewController extends HttpServlet {

    private static final long serialVersionUID = 3026486002489701343L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();
        if(url.contains("create")){
            this.create(request, response);
        }else if(url.contains("edit")){
            this.edit(request, response);
        }else{
            this.list(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // From CREATE.JSP. Then call API /api/articles
    private void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

    }

    private void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/new/edit.jsp");
        rd.forward(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/new/list.jsp");
        rd.forward(request, response);
    }
}
