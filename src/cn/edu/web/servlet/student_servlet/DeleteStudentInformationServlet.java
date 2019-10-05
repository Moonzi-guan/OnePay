package cn.edu.web.servlet.student_servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.service.student_service.StudentInfoService;

public class DeleteStudentInformationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String student_sid = request.getParameter("student_sid");
		
		StudentInfoService service = new StudentInfoService();
		
		try {
			service.deleteStudentInformation(student_sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//重定向到findAllStudentInformation页面的
		response.sendRedirect(request.getContextPath()+"/findAllStudentInformation");
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}