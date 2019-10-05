package cn.edu.web.servlet.student_servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.domain.Student;
import cn.edu.service.student_service.StudentInfoService;

public class FindStudentInformationByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String student_sid = request.getParameter("student_sid");
		StudentInfoService service = new StudentInfoService();
		Student student = null;
		try {
			student=service.findStudentInformationById(student_sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("student",student);
		request.getRequestDispatcher("/student_info.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}