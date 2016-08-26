package mvctest.service.impl;

import java.util.List;
import java.util.Map;


import mvctest.dao.GradeDao;
import mvctest.model.Grade;
import mvctest.model.User;
import mvctest.service.IMvctestService;
//@Service("mvctestService")
public class MvctestServiceImpl implements IMvctestService {
	public GradeDao gradeDao;
	public List<Map<String, Grade>> list;
	
	
	public GradeDao getGradeDao() {
		return gradeDao;
	}


	public void setGradeDao(GradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}


	//此处如果没有添加GradeDao的setter/getter方法会报空指针异常
	public List<Map<String, Grade>> selectGrade(List<Map<String, User>> grade) throws Exception {
		System.err.println("程序从这开始中断"+grade);
		list = gradeDao.select(grade);
		// TODO Auto-generated method stub
		return list;
	}



}
