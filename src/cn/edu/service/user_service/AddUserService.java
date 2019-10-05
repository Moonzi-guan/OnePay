package cn.edu.service.user_service;

import java.sql.SQLException;

import cn.edu.dao.UserDao;
import cn.edu.domain.User;

public class AddUserService {

	public void addUser(User user) throws SQLException {
		UserDao dao = new UserDao();
		dao.addUser(user);
	}

}
