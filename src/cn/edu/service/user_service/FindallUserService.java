package cn.edu.service.user_service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.dao.UserDao;
import cn.edu.domain.User;

public class FindallUserService {
	
	//查询所有用户
	public List<User> findAllUser() throws SQLException {
		UserDao dao = new UserDao();
		return dao.findAllUser();
	}

}
