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
import cn.edu.service.user_service.UserService;
import cn.edu.vo.Condition;
import cn.edu.vo.PageBean;


public class UserListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserService service = new UserService();
		//分页
		//模拟当前是第一页
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		//认为每页显示8条
		int currentCount = 8;
		PageBean<User> pageBean = null;
			try {
				pageBean = service.findPageBean(currentPage,currentCount);
			} catch (Exception e) {
				e.printStackTrace();
			}
		request.setAttribute("pageBean", pageBean);
		
		request.getRequestDispatcher("/main_list.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}