package mvctest.service.impl;

import org.springframework.stereotype.Service;

import mvctest.model.User;
import mvctest.service.IMvctestService;
@Service("mvctestService")
public class MvctestServiceImpl implements IMvctestService {

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
