package com.laptrinhjavaweb.auth;

import java.io.IOException;
import java.util.Map;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserService;

import com.laptrinhjavaweb.util.FormUtil;
import com.laptrinhjavaweb.util.SessionUtil;

@WebServlet(urlPatterns = { "/login", "/logout" })
public class AuthController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ResourceBundle bundle = ResourceBundle.getBundle("message");

	@Inject
	private IUserService userService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("is_from_login");
		// logout
		if(action == null) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/home-page");
		}else if (action != null && action.equals("true")) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if(message != null && alert != null){
				request.setAttribute("message", this.bundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/login.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("is_from_login");
		if (action != null && action.equals("true")) {
			UserModel model = FormUtil.toModel(UserModel.class, request);
			Map<String, Object> mapData = this.userService.findByUsernameAndPasswordAndStatus(model.getUsername(),
					model.getPassword(), 1);
			if (mapData == null) {
				response.sendRedirect(request.getContextPath() + "/login?is_from_login=true&message=username_password_invalid&alert=danger");
			} else {
				model = (UserModel) mapData.get("model");
				RoleModel roleModel = (RoleModel) mapData.get("role");
				SessionUtil.getInstance().putValue(request, "USERMODEL", model);
				SessionUtil.getInstance().putValue(request, "ROLE", roleModel.getName());
				if (roleModel.getCode().equals("USER")) {
					response.sendRedirect(request.getContextPath() + "/home-page");
				} else if(roleModel.getCode().equals("ADMIN")) {
					response.sendRedirect(request.getContextPath() + "/admin/dashboards");
				}

			}
		}
	}
}
