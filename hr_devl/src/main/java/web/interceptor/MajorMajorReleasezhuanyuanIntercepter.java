package web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import web.controller.ybc.dto.Massage;
import web.controller.ybc.dto.UserLogin;

public class MajorMajorReleasezhuanyuanIntercepter extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//先拿到session中的登陆用户
		UserLogin userlogin=	(UserLogin)request.getSession().getAttribute("userlogin");
			if(("专员".equals(userlogin.getUser_role()))||"招聘经理".equals(userlogin.getUser_role())){
				return true;
			}else{
				request.setAttribute("msg", new Massage("您当前登陆用户权限不足！","index.jsp"));
				request.getRequestDispatcher("/ybc_EngageMajorRelease/massage.jsp").forward(request, response);
				return false;
			}
		
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}
