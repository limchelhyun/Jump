package project.jump.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.jump.detail.DetailDAOImpl;
import project.jump.detailbest.DetailBestDAO;
import project.jump.detailbest.DetailBestDAOImpl;
import project.jump.dto.JumpBoard;

@Controller
public class DetailController {
	@RequestMapping(value="/detail")
	public ModelAndView detail(HttpServletRequest request){
		DetailDAOImpl dao = new DetailDAOImpl();
		JumpBoard jumpboard = dao.jumpDetail(Integer.parseInt((String)request.getParameter("boardNum")));
		//ModelAndView------
		ModelAndView m = new ModelAndView();
		m.setViewName("detail");
		m.addObject("jumpBoard", jumpboard);
		return m;
	}
	
	@RequestMapping(value="/detailBest")
	public ModelAndView detailBest(HttpServletRequest request){
		//한글 깨짐 리퀘스트로 해결 ****************************************
		try{request.setCharacterEncoding("UTF-8"); }catch(Exception e){e.printStackTrace();}
		//한글 깨짐 리퀘스트 종료  *****************************************
		
		
		
		String jumpId =  (String)request.getParameter("jumpId");
		String boardNum = (String)request.getParameter("boardNum");
		DetailBestDAOImpl dao = new DetailBestDAOImpl();
		JumpBoard j=dao.detailBest(Integer.parseInt(boardNum), jumpId);
		//ModelAndView
		ModelAndView m = new ModelAndView();		
		m.setViewName("detail");
		m.addObject("jumpBoard", j);
		return m;
	}
}
