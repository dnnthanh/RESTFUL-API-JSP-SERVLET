package com.laptrinhjavaweb.filter;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.util.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        if(url.contains("admin")){
            String role = (String) SessionUtil.getInstance().getValue(request, "ROLE");
            UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
            if(model != null){
                if(role.equals(SystemConstant.USER)){
                    response.sendRedirect(request.getContextPath() + "/login?is_from_login=true&message=not_permission&alert=danger");
                }else if(role.equals(SystemConstant.ADMIN)){
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }else{
                response.sendRedirect(request.getContextPath() + "/login?is_from_login=true&message=not_login&alert=danger");
            }
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
