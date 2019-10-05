package cn.edu.web.servlet.user_servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.domain.User;
import cn.edu.domain.UserPower;
import cn.edu.service.user_service.ShowUserService;
import cn.edu.service.user_service.UserPowerService;


public class ShowUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//获得要查询User的id
		String id = request.getParameter("id");
		//传递pid查询信息
		ShowUserService service = new ShowUserService();
		User user = null;
		try {
			user = service.findUserByid(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		UserPowerService service_1 = new UserPowerService();
		List<UserPower> powerList = null;
		try {
			powerList = service_1.findAllPower();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("powerList", powerList);
		request.setAttribute("user", user);

		request.getRequestDispatcher("main_edit.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}