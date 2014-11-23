package project.jump.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter{
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler){
		
		try{
			System.out.println("ins");
			if(request.getSession().getAttribute("jumpId")==null){
				response.sendRedirect("/login");
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
}
