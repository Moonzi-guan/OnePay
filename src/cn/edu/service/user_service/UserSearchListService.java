package cn.edu.service.user_service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.dao.UserDao;
import cn.edu.domain.User;
import cn.edu.vo.Condition;



public class UserSearchListService {
	
	public List<User> findUserByCondition(Condition condition) throws SQLException {
		UserDao dao = new UserDao();
		return dao.findUserByCondition(condition);
	}

}
