package mvctest.service;

import java.util.List;
import java.util.Map;

import mvctest.model.Grade;
import mvctest.model.User;

public interface IMvctestService {
	public List<Map<String,Grade>> selectGrade(List<Map<String, User>> user) throws Exception;
}
