package cn.edu.web.servlet.user_servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import cn.edu.domain.UserPower;
import cn.edu.service.user_service.UserPowerService;


public class UserPowerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得权限类别数据
		UserPowerService service = new UserPowerService();
		List<UserPower> powerList = null;
		try {
			powerList = service.findAllPower();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("powerList", powerList);

		request.getRequestDispatcher("/main_info.jsp").forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}