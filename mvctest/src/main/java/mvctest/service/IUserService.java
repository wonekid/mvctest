package mvctest.service;

import java.util.List;

import mvctest.model.User;

public interface IUserService {
	public List<User> selectUser() throws Exception;
}
