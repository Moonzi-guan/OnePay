package cn.edu.web.servlet.message_servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.domain.Message;
import cn.edu.service.message_service.StudentService;

public class FindStudentByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String message_sid = request.getParameter("message_sid");
		Message student = null;
		StudentService  service = new StudentService();
		 try {
			 student = service.findStudentById(message_sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		 request.setAttribute("student", student);
		 request.getRequestDispatcher("/message_info.jsp").forward(request,response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}