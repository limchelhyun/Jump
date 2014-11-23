package project.jump.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.jump.dto.JumpBoard;
import project.jump.list.listDAOImpl;
import project.jump.search.SearchDAOImpl;

@Controller
public class ListController {

	@RequestMapping(value="/list")
	public ModelAndView getList(){
		listDAOImpl dao = new listDAOImpl();
		ArrayList<JumpBoard> arr=dao.findAll();
		ModelAndView m = new ModelAndView();
		m.setViewName("list");
		m.addObject("JumpBoard", arr);
		return m;
	}
	
	@RequestMapping(value="/listsearch",method=RequestMethod.POST)
	public ModelAndView getListSearch(HttpServletRequest request) throws UnsupportedEncodingException{
		ModelAndView m = new ModelAndView();
		m.setViewName("list");
		
		//한글 깨짐 리퀘스트로 해결 ****************************************
		request.setCharacterEncoding("UTF-8"); // 한글 깨짐해결
		//한글 깨짐 리퀘스트 종료  *****************************************
		
		// 검색창 dao
		SearchDAOImpl dao = new SearchDAOImpl();
		ArrayList<JumpBoard> arr = dao.findSearch((String)request.getParameter("search"));
		// 검색창 dao 종료
		m.addObject("JumpBoard", arr);		
		return m;
	}
}
