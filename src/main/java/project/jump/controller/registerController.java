package project.jump.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.jump.dto.Jump;
import project.jump.register.registerDAO;
import project.jump.register.registerDAOImpl;


@Controller
public class registerController {
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(){
		System.out.println("test register");
		return "register";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerUser(HttpServletRequest request) throws UnsupportedEncodingException{

		//한글 깨짐 리퀘스트로 해결 ****************************************
		request.setCharacterEncoding("UTF-8"); // 한글 깨짐해결
		//한글 깨짐 리퀘스트 종료  *****************************************
		
		Jump jump = new Jump();
		jump.setJumpId((String)request.getParameter("userid"));
		jump.setJumpPwd((String)request.getParameter("password"));
		jump.setJumpName((String)request.getParameter("username"));
		registerDAO dao = new registerDAOImpl();
		dao.registertUser(jump);
		return "redirect:/";
	}
}
