package cn.edu.web.servlet.user_servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.domain.User;
import cn.edu.service.user_service.AddUserService;


public class AddUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//1、获取数据
		Map<String, String[]> properties= request.getParameterMap();
		//2、封装数据
		User user = new User();
		try {
			BeanUtils.populate(user, properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//此位置user已经封装完毕----将表单的数据封装完毕
		//手动设置表单中没有数据
		//最后的登录时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = format.format(new Date());
		user.setDate(date);
		//设置id
		user.setId(UUID.randomUUID().toString());
		//3、传递数据给service层
		AddUserService service = new AddUserService();
		try {
			service.addUser(user);
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