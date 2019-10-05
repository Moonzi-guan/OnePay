package cn.edu.web.servlet.user_servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.domain.User;
import cn.edu.service.user_service.UserSearchListService;
import cn.edu.vo.Condition;
import cn.edu.vo.PageBean;

public class UserSearchList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取页面的数据
		Map<String,String[]> properties = request.getParameterMap();
		
		//将散装的数据封装到VO实体当中
		Condition condition = new Condition();
		try {
			 BeanUtils.populate(condition, properties);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//将类传递到实体层
		UserSearchListService service = new UserSearchListService();
		List<User> userList = null;
		try {
			userList = service.findUserByCondition(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setUserList(userList);
		pageBean.setCurrentCount(8);
		pageBean.setTotalCount(userList.size());
		pageBean.setCurrentPage(1);
		pageBean.setTotalPage(userList.size()/8+1);
		request.setAttribute("pageBean", pageBean);
		
//		request.setAttribute("userList", userList);
		request.setAttribute("condition", condition);

		request.getRequestDispatcher("/main_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}