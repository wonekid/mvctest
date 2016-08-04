package mvctest.service.impl;

import org.springframework.stereotype.Service;

import mvctest.model.User;
import mvctest.service.MvctestService;
@Service("mvctestService")
public class MvctestServiceImpl implements MvctestService {

	public String getNewName(User user) {
		// TODO Auto-generated method stub
		System.err.println("===========Service");
		return "Hello Spring"+user.getUserName();
	}

	public String getNewName(String userName) {
		// TODO Auto-generated method stub
		return userName;
	}

}
