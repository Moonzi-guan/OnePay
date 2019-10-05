package cn.edu.web.servlet.user_servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.domain.User;
import cn.edu.service.user_service.UserUpdateService;


public class UserUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1、获取数据
		Map<String, String[]> properties = request.getParameterMap();
		//2、封装数据
		User user = new User();
		try {
			BeanUtils.populate(user, properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		//此位置User已经封装完毕----将表单的数据封装完毕
		//手动设置表单中没有数据
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());
		user.setDate(date);
		//3、传递数据给service层
		UserUpdateService service = new UserUpdateService();
		try {
			service.userUpdate(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//跳转到列表页面
		response.sendRedirect(request.getContextPath()+"/findalluser");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}