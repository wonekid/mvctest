package mvctest.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mvctest.model.User;
import mvctest.service.IUserService;

public class UserDao {
	 private  String resource = "config/mybatis-config.xml";  
	  
	    /** 
	     *  
	     * @param userdao 
	     * @throws Exception 
	     */  
	    public List<User> select() throws Exception{  
	        Reader reader = Resources.getResourceAsReader(resource);  
	        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);  
	        SqlSession session = ssf.openSession();  
	        reader.close();  
//	        IUserService userservice = session.getMapper(IUserService.class);
	        List<User> list = session.selectList("mvctest.dao.UserMapper.selectUser");  
	        System.err.println("我只是想知道UserDao执行了没有"+list);
	        session.commit();  
	        session.close();
	     
			return list;  
	    }  
	      
	    public void getUserList() throws Exception{
	    	 Reader reader = Resources.getResourceAsReader(resource);  
		     SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader); 
	        SqlSession session = ssf.openSession();
	        try {
	            IUserService userOperation=session.getMapper(IUserService.class);          
	            List<User> users = userOperation.selectUser();
	            for(User user:users){
	                System.err.println("我只是想知道UserDao执行了没有2"+user);
	            }
	            
	        } finally {
	            session.close();
	        }
	    }
	    
}
