package project.jump.list;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import project.jump.dto.JumpBoard;
import project.jump.dto.JumpCheck;

public class listDAOImpl implements listDAO{
	private String resource = "mybatisConf.xml";
	
	
	@Override
	public ArrayList<JumpBoard> findAll() {
		Reader reader; // 리더
		ArrayList<JumpBoard> dt = null; // 리턴할 데이터를 저장
		
		try {
		   reader = Resources.getResourceAsReader(resource);
		   SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		   SqlSession session = sqlMapper.openSession();
		   
		   		try {
		   			dt  = (ArrayList)session.selectList("jumpMapper.selectJumpBoard");
		   			for(JumpBoard dto : dt){
			   			//이미지 태그만 추출*********************************************************************************
			   			Pattern pattern  =  Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
			   			// 추출할 내용.
			   			String content = dto.getBoardContent();
			   			// 내용 중에서 이미지 태그를 찾아라!
			   			Matcher match = pattern.matcher(content);
			   			String imgTag = null;
			   			if(match.find()){ // 이미지 태그를 찾았다면,,
			   				imgTag = match.group(0); // 글 내용 중에 첫번째 이미지 태그를 뽑아옴.
			   			}
			   			dto.setBoardContent(imgTag);
			   			//이미지 태그만 추출 끝*********************************************************************************
		   			
			   			//checksum
			   			dto.setBoardBest(checkSum(dto.getBoardNum()));	
		   			}
		   		} finally {
		   				session.commit();
		   				session.close();
		   				return dt;
		   		} 
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		return dt;
	}
	private int checkSum(int boardNum){		
			Reader reader;
			ArrayList<JumpCheck> arr;
			int total=0;
			int num = 0;
			try {
				  reader = Resources.getResourceAsReader(resource);
				  SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				  SqlSession session = sqlMapper.openSession();				   
				  try {
					arr = (ArrayList)session.selectList("jumpMapper.checkSum", boardNum);
					for(JumpCheck j : arr){
						num+=j.getCheckBest();
					}
				  } finally {
					   session.commit(); // 무조건 commit해주어야 한다
					   session.close(); // 관리를 위해 session을 닫아 주어야 한다.
				   }
				   
			} catch (IOException e) {
				   // TODO Auto-generated catch block
				   e.printStackTrace();
			}		
		return num;
	}
}
