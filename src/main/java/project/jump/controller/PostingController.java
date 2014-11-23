package project.jump.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.jump.dto.JumpBoard;
import project.jump.posting.postingDAOImpl;
import project.jump.register.registerDAO;
import project.jump.register.registerDAOImpl;

@Controller
public class PostingController {
	
	@RequestMapping(value="/posting",method=RequestMethod.GET)
	public String postingGET(){
		return "/posting";
	}
	
	@RequestMapping(value="/posting",method=RequestMethod.POST)
	public String postingPOST(HttpServletRequest request) throws UnsupportedEncodingException{
		
		//한글 깨짐 리퀘스트로 해결 ****************************************
		request.setCharacterEncoding("UTF-8"); // 한글 깨짐해결
		//한글 깨짐 리퀘스트 종료  *****************************************
		JumpBoard jumpboard = new JumpBoard();
		jumpboard.setJumpId((String)request.getParameter("jumpId")); // session 처리로 바꿔주어야 할 부분
		/*String name = new String(request.getParameter("area").getBytes("8859_1"),"EUC-KR");*/
		/*String name=this.uni2ksc((String)request.getParameter("area"));*/
		/*System.out.println(name+"name test");*/
		jumpboard.setBoardArea((String)request.getParameter("area"));
		jumpboard.setBoardTitle((String)request.getParameter("title"));
		jumpboard.setBoardContent((String)request.getParameter("content"));
		
		/*jump.setJumpId((String)request.getParameter("userid"));
		jump.setJumpPwd((String)request.getParameter("password"));
		jump.setJumpName((String)request.getParameter("username"));*/
		postingDAOImpl d = new postingDAOImpl();
		d.jumpBoardInsert(jumpboard);
		return "redirect:/list";
	}
	
	protected String uni2ksc (String Unicodestr) throws UnsupportedEncodingException {
		return new String (Unicodestr.getBytes("8859_1"),"KSC5601");
	}
}
