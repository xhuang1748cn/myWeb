package cn.srn.interceptors;

import cn.srn.define.SessionConst;
import cn.srn.repositories.entity.entities.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BgLoginInterceptor extends AbstractLoginInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(true);
		Object obj = session.getAttribute(SessionConst.SESSION_ADMIN);
		if(obj == null || !(obj instanceof Admin)){
			if (isAjaxRequest(request)) {
				ajaxRequestReturn(response, "bgNoLogin");
			} else {
				request.getRequestDispatcher("/admin/bglogin").forward(request, response);
			}
			return false;
		}
		return true;
	}

}