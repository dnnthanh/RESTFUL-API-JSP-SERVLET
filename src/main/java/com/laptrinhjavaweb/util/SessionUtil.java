package com.laptrinhjavaweb.util;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	
	private static SessionUtil util = null;
	
	public static SessionUtil getInstance() {
		if(util == null) {
			util = new SessionUtil();
		}
		return util;
	}
	
	public void putValue(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}
	
	public Object getValue(HttpServletRequest request, String key) {	
		return request.getSession().getAttribute(key);
	}
	
	public void removeValue(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}
}
