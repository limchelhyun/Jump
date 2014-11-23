package project.jump.login;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import project.jump.dto.Jump;

public class LoginDAOImpl implements LoginDAO{
	private String resource = "mybatisConf.xml";
	
	@Override
	public boolean pwdCheck(String jumpId, String jumpPwd) {		
		// TODO Auto-generated method stub
				Reader reader;
				boolean check = false;
				Jump jump;
				try {
					reader = Resources.getResourceAsReader(resource);
					SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sqlMapper.openSession();
				   
					try {
						

						ArrayList<Jump> arr=(ArrayList)session.selectList("jumpMapper.pwdCheck",jumpId);
						jump=arr.get(0);
						System.out.println(jump.getJumpPwd());
						if(jumpPwd.equals(jump.getJumpPwd())){
							check=true;
						}
					} finally {
						session.commit();
						session.close();
					}	   
				 } catch (IOException e) {
				   // TODO Auto-generated catch block
					 e.printStackTrace();
				 }
		return check;
	}

}
