package mvctest.model;

public class User {
	private String userName;
	private String userpass;
   public User(){
	   
   }
   public User(String username,String userpass){
	   this.userName = username;
	   this.userpass = userpass;
	   
   }
   
   public void setuserpass(String userpass) {
	this.userpass = userpass;
   }
   public String getuserpass() {
	return userpass;
   }
   public void setUserName(String userName) {
	this.userName = userName;
   }
   public String getUserName() {
	return userName;
   }
   //默认实现toString()方法
   public String toString(){
	   return "[username="+userName+","+"userpass="+userpass+"]";
   }
}
