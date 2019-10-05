package cn.edu.service.user_service;

import java.sql.SQLException;

import cn.edu.dao.UserDao;
import cn.edu.domain.User;

public class UserUpdateService {
	//更新用户信息
	public void userUpdate(User user) throws SQLException {
		UserDao dao = new UserDao();
		dao.userUpdate(user);
	}

}
