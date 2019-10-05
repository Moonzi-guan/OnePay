package cn.edu.service.user_service;

import java.sql.SQLException;

import cn.edu.dao.UserDao;
import cn.edu.domain.User;

public class ShowUserService {

	public User findUserByid(String id) throws SQLException {
		UserDao dao = new UserDao();
		return dao.findUserByid(id);
	}

}
