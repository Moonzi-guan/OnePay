package cn.edu.web.servlet.user_servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.domain.User;
import cn.edu.service.user_service.FindallUserService;

public class FindallUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 传递请求到service层
		FindallUserService service = new FindallUserService();
		List<User> userList = null;
		try {
			userList = service.findAllUser();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 将userList放到request域
		request.setAttribute("userList", userList);

		request.getRequestDispatcher("/main_list.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}