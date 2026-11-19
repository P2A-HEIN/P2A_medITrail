
package jp.co.medITrail.controller.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ServletRequestPathUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("hosId") == null) {
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}

		String role = (String) session.getAttribute("role");

		String path = ServletRequestPathUtils.getCachedPathValue(request);

		if (path.startsWith("/admin/") && "admin".equals(role)) {
			return true;
		}

		if (path.startsWith("/employee/") && "employee".equals(role)) {
			return true;
		}

		response.sendError(HttpServletResponse.SC_FORBIDDEN);
		return false;


	}
}
