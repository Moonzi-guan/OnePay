package cn.edu.service.user_service;

import java.sql.SQLException;

import cn.edu.dao.UserDao;


public class DelUserService {

	public void delUserByid(String id) throws SQLException {
		UserDao dao = new UserDao();
		dao.delUserByid(id);
	}

}
