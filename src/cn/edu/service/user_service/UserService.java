package cn.edu.service.user_service;

import java.sql.SQLException;
import java.util.List;



import cn.edu.dao.UserDao;
import cn.edu.domain.User;
import cn.edu.vo.Condition;
import cn.edu.vo.PageBean;


public class UserService {

	//校验用户名是否存在
	public boolean checkUsername(String username) {
		UserDao dao = new UserDao();
		Long isExist = 0L;
		try {
			isExist = dao.checkUsername(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isExist>0?true:false;
	}

	//用户登录的方法
	public User login(String username, String password) throws SQLException {
		UserDao dao = new UserDao();
		return dao.login(username,password);
	}

	//分页操作
	public PageBean<User> findPageBean(int currentPage, int currentCount) throws SQLException {
		
		UserDao dao = new UserDao();
		
		//目的：就是想办法封装一个PageBean 并返回
		PageBean pageBean = new PageBean();
		
		//1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		
		//2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		
		//3、总条数private int totalCount;
		int totalCount = dao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		
		//4、总页数private int totalPage;
		/*
		 * 总条数		当前页显示的条数	总页数
		 * 10		4				3
		 * 11		4				3
		 * 12		4				3
		 * 13		4				4
		 * 
		 * 公式：总页数=Math.ceil(总条数/当前显示的条数)
		 * 
		 */
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		
		
		//5、每页显示的数据private List<T> productList = new ArrayList<T>();
		/*
		 * 页数与limit起始索引的关系
		 * 例如 每页显示4条
		 * 页数		其实索引		每页显示条数
		 * 1		0			4
		 * 2		4			4
		 * 3		8			4
		 * 4		12			4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage-1)*currentCount;
		
		List<User> userList = dao.findUserListForPageBean(index,currentCount);
		pageBean.setUserList(userList);
		
		return pageBean;
	}
}
