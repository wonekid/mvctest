package mvctest.service;

import java.util.List;
import java.util.Map;

import mvctest.model.User;

public interface IUserService {
	public List<Map<String,User>> selectUser(User user) throws Exception;
}
