package mvctest.service.impl;

import java.util.List;

import mvctest.dao.UserDao;
import mvctest.model.User;
import mvctest.service.IUserService;

public class UserServiceImpl implements IUserService{
	private UserDao userDao = new UserDao();
	private List<User> list ;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public List<User> selectUser() throws Exception {
		list = userDao.select();
		System.err.println("userService.selectUser()======:"+list);
		return list;
	}
	
}
