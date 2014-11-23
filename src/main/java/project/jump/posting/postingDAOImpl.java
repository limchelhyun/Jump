package project.jump.posting;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import project.jump.dto.JumpBoard;
import project.jump.dto.JumpCheck;

public class postingDAOImpl implements postingDAO{
	private String resource = "mybatisConf.xml"; // 마티바티스 bean주소
	@Override
	public void jumpBoardInsert(JumpBoard jumpboard) {
		// TODO Auto-generated method stub
		Reader reader;
			try {
				  reader = Resources.getResourceAsReader(resource);
				  SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				  SqlSession session = sqlMapper.openSession();				   
				  try {
					session.insert("jumpMapper.jumpBoardInsert",jumpboard);
				   } finally {
					   session.commit(); // 무조건 commit해주어야 한다
					   session.close(); // 관리를 위해 session을 닫아 주어야 한다.
				   }
				   
			} catch (IOException e) {
				   // TODO Auto-generated catch block
				   e.printStackTrace();
			}
		
			
			 //jumpCheck 값추가 부모키가 먼저 입력되어야 자식이 참조할 수 있다.
			JumpCheck jc = new JumpCheck();
			jc.setBoardNum(jumpBoardNumGet(jumpboard.getJumpId()));
			jc.setJumpId(jumpboard.getJumpId());
			jumpCheckInsert(jc);
			//
	}
	
	public int jumpBoardNumGet(String jumpId){
	
		Reader reader;
		ArrayList<JumpBoard> arr;
		int num = 0;
		try {
			  reader = Resources.getResourceAsReader(resource);
			  SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			  SqlSession session = sqlMapper.openSession();				   
			  try {
				arr = (ArrayList)session.selectList("jumpMapper.boardNumDesc", jumpId);
				JumpBoard j = arr.get(0);
				num = j.getBoardNum();
			
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
	
	
	public void jumpCheckInsert(JumpCheck jumpCheck) {
		// TODO Auto-generated method stub
		Reader reader;
		try {
			  reader = Resources.getResourceAsReader(resource);
			  SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			  SqlSession session = sqlMapper.openSession();				   
			  try {
				session.insert("jumpMapper.jumpCheckInsert",jumpCheck);
			   } finally {
				   session.commit(); // 무조건 commit해주어야 한다
				   session.close(); // 관리를 위해 session을 닫아 주어야 한다.
			   }
			   
		} catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		}	
	}
}
