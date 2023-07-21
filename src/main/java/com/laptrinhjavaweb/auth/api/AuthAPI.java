package com.laptrinhjavaweb.auth.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.util.FormUtil;

@WebServlet("/api/auth/login")
public class AuthAPI extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
    private IUserService userService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        UserModel model = FormUtil.toModel(UserModel.class, request);
        Map<String, Object> mapData = this.userService.findByUsernameAndPasswordAndStatus(model.getUsername(),
                model.getPassword(), 1);
        Map<String, Object> mapResult = new HashMap<>();
        if (mapData == null) {
            mapResult.put("error", "Unauthorized access");
        } else {
            String token = this.genarateToken();
            mapResult.put("access_token", token);
            mapResult.put("token_type", "bearer");
        }
        mapper.writeValue(response.getOutputStream(), mapResult);
    }

    private String genarateToken() {
        String token = UUID.randomUUID().toString();
        return token;
    }
}
