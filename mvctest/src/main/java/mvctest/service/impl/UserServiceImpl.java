package mvctest.service.impl;

import java.util.List;
import java.util.Map;

import mvctest.dao.UserDao;
import mvctest.model.User;
import mvctest.service.IUserService;

public class UserServiceImpl implements IUserService{
	private UserDao userDao = new UserDao();
	private List<Map<String,User>> list ;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public List<Map<String,User>> selectUser() throws Exception {
		list = userDao.select();
		System.err.println("userService.selectUser()======:"+list);
		return list;
	}
	
}
