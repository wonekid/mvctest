package mvctest.model;

public class User {
	private String username;
	private String userpass;
   public User(){
	   
   }
   public User(String username,String userpass){
	   this.username = username;
	   this.userpass = userpass;
	   
   }
   
   public void setUserpass(String userpass) {
	this.userpass = userpass;
   }
   public String getUserpass() {
	return userpass;
   }
   public void setUsername(String username) {
	this.username = username;
   }
   public String getUsername() {
	return username;
   }
   //默认实现toString()方法
  
   public String toString(){
	   return username+","+userpass;
   }
}
