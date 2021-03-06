package mvctest.dao;

import java.io.Reader;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mvctest.model.User;

public class UserDao {
	 private  String resource = "config/mybatis-config.xml";  
	  
	    /** 
	     *  
	     * @param userdao 
	     * @throws Exception 
	     */  
	    public List<Map<String,User>> select(User user) throws Exception{  
	        Reader reader = Resources.getResourceAsReader(resource);  
	        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);  
	        SqlSession session = ssf.openSession();  
	        reader.close();  
//	        IUserService userservice = session.getMapper(IUserService.class);
	        List<Map<String,User>> list = session.selectList("mvctest.dao.UserMapper.selectUser",user.getUsername());  
	        System.err.println("=======这个是userService中的userId"+list.get(0).get("userId"));
	        System.err.println("我只是想知道UserDao执行了没有"+list);
	        session.commit();  
	        session.close();
	     
			return list;  
	    }  
	      /*
	    public void getUserList() throws Exception{
	    	 Reader reader = Resources.getResourceAsReader(resource);  
		     SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader); 
	        SqlSession session = ssf.openSession();
	        try {
	            IUserService userOperation=session.getMapper(IUserService.class);          
	            List<Map<String,User>> users = userOperation.selectUser();
	            for(Map<String, User> user:users){
	                System.err.println("我只是想知道UserDao执行了没有2"+user);
	            }
	            
	        } finally {
	            session.close();
	        }
	    }
	    */
}
