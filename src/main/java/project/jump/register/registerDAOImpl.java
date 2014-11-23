package project.jump.register;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import project.jump.dto.Jump;


public class registerDAOImpl implements registerDAO{
	private String resource = "mybatisConf.xml";
	
	@Override
	public void registertUser(Jump jump) {
		// TODO Auto-generated method stub
		Reader reader;
		try {
		   reader = Resources.getResourceAsReader(resource);
		   SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		   SqlSession session = sqlMapper.openSession();
		   
		   try {
			session.insert("jumpMapper.registerUser",jump);
		   } finally {
			   session.commit();
			   session.close();
		   }
		   
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
	}

}
