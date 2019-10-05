package cn.edu.service.user_service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.dao.UserDao;
import cn.edu.domain.UserPower;

public class UserPowerService {

	public List<UserPower> findAllPower() throws SQLException {
		UserDao dao = new UserDao();
		return dao.findAllPower();
	}

	
}
