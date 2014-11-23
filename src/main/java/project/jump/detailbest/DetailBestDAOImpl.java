package project.jump.detailbest;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import project.jump.dto.JumpBoard;
import project.jump.dto.JumpCheck;

public class DetailBestDAOImpl implements DetailBestDAO {
	
	private String resource = "mybatisConf.xml";
	
	@Override
	public JumpBoard detailBest(int boardNum, String jumpId) {
		// TODO Auto-generated method stub
		Reader reader;
		JumpBoard j=null;
			try {
				reader = Resources.getResourceAsReader(resource);
				SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sqlMapper.openSession();
						   
					try {
						//원래 보드의 데이터를 가지고 온다.
						j=session.selectOne("jumpMapper.jumpboardselect", boardNum);
					} finally {
						session.commit();
						session.close();
						//num을 셋팅
						j.setBoardBest(detailBestGetNum(boardNum, jumpId));
					}			   
				} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
		return j;
	}

	@Override
	public int detailBestGetNum(int boardNum, String jumpId) {
		Reader reader;
		JumpCheck j;
		int numCheck=0; // 체크가 되었는지 안되었는지 체크
		//다중 파라미터
		HashMap<String, Object> map = new HashMap<String, Object>(); 
		map.put("boardNum", boardNum); 
		map.put("jumpId", jumpId); 

			try {
				reader = Resources.getResourceAsReader(resource);
				SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sqlMapper.openSession();
						   
					try {
						//원래 보드의 데이터를 가지고 온다.
						ArrayList<JumpCheck> arr=(ArrayList)session.selectList("jumpMapper.detailBestIdCheck", map);			 
						j=arr.get(0);

						switch(j.getCheckBest()){
							case 0 :
								numCheck=1;
								break;
							case 1:
								numCheck=0;
								break;
						}
					} finally {
						session.commit();
						session.close();
						
						//Check 값을 업데이트
						JumpCheck jumpCheck = new JumpCheck();
						jumpCheck.setBoardNum(boardNum);
						jumpCheck.setJumpId(jumpId);
						jumpCheck.setCheckBest(numCheck);
						CheckUpdate(jumpCheck);
					}			   
				} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
		return numCheck;
	}
	
	private void CheckUpdate(JumpCheck jumpCheck) {
		// TODO Auto-generated method stub
		Reader reader;
		try {
			  reader = Resources.getResourceAsReader(resource);
			  SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			  SqlSession session = sqlMapper.openSession();				   
			  try {
				session.update("jumpMapper.checkUpdate",jumpCheck);
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
