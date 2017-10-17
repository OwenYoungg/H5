package com.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.entity.Role;
import com.springmvc.entity.User;

/**
 * common拦截
 * 
 * @author guooyang
 *
 */
public class CommonInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getSession().getAttribute("user") == null) {
			String xrw = request.getHeader("X-Requested-With");
			boolean isAjax = true;
			if (xrw == null || "".equals(xrw.trim())) {
				isAjax = false;
			}
			if (!isAjax) {
				// response.sendRedirect(request.getContextPath()+"/user/sessionTimeout.do");
				// return false;
			}
			// JSONObject json = new JSONObject();
			// json.put("success", false);
			// json.put("message", "会话超时,请重新登陆");
			// ResponseUtils.renderJson(response, json.toJSONString());
			// return false;
			User user = new User();
			user.setName("admin");
			user.setPassword("shenjignbinga");
			request.getSession().setAttribute("user", user);
			return true;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
