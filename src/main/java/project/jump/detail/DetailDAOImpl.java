package project.jump.detail;

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

public class DetailDAOImpl implements DetailDAO{
	private String resource = "mybatisConf.xml";	
	@Override
	public JumpBoard jumpDetail(int boardNum) {
		// TODO Auto-generated method stub
		Reader reader;
		JumpBoard j=null;
			try {
				 reader = Resources.getResourceAsReader(resource);
				 SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				 SqlSession session = sqlMapper.openSession();
				   
				 try {
					 j=session.selectOne("jumpMapper.jumpboardselect", boardNum);
				
					 /*session.select("jumpMapper.jumpboardselect", boardNum);*/
					/*session.insert("jumpMapper.registerUser",jump);*/
				 } finally {
					   session.commit();
					   session.close();
					   j.setBoardBest(detailBestIdCheck(boardNum, j.getJumpId()));
				 }
				   
			} catch (IOException e) {
				   // TODO Auto-generated catch block
				   e.printStackTrace();
			}
		return j;
	}
	
	

	@Override
	public int detailBestIdCheck(int boardNum, String jumpId) {
		Reader reader;
		JumpCheck jumpCheck = null;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardNum", boardNum);
		map.put("jumpId", jumpId);
		
		try {
			 reader = Resources.getResourceAsReader(resource);
			 SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			 SqlSession session = sqlMapper.openSession();
			   
			 try {
				 ArrayList<JumpCheck> arr=(ArrayList)session.selectList("jumpMapper.detailBestIdCheck", map);			 
				 jumpCheck=arr.get(0);
				 System.out.println(jumpCheck.getCheckBest()+" jumpCheck.getCheckBest()");

			 } finally {
				   session.commit();
				   session.close();
			 }
			   
		} catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		}
		return jumpCheck.getCheckBest();
	}

}
