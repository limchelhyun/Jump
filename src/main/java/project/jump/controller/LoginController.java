package project.jump.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.jump.login.LoginDAOImpl;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String pwdCheckFail(){
		return "login";
	}	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String pwdCheck(HttpServletRequest request,HttpServletResponse respose){
		
		//한글 깨짐 리퀘스트로 해결 ****************************************
		try{request.setCharacterEncoding("UTF-8"); }catch(Exception e){e.printStackTrace();}
		//한글 깨짐 리퀘스트 종료  *****************************************
		System.out.println( (String)request.getParameter("username"));
		System.out.println( (String)request.getParameter("password"));
		
		String checkReturn;
		String jumpId = (String)request.getParameter("username");
		String jumpPwd = (String)request.getParameter("password");
		LoginDAOImpl dao = new LoginDAOImpl();
		boolean check = dao.pwdCheck(jumpId, jumpPwd);
		
		if(check){
			checkReturn="sessionLogin";
		}else{
			checkReturn="loginFail";
		}
		
		return checkReturn;
	}
	
	@RequestMapping(value="/logout")
	public String logout(){
		return "logout";
	}
}
