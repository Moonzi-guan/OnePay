package cn.edu.web.servlet.student_servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.domain.Student;
import cn.edu.service.student_service.StudentInfoService;

public class FindAllStudentInformationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		StudentInfoService service = new StudentInfoService();
		List<Student> studentList = null;
		try {
			studentList = service.findAllStudentInformation();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("studentList", studentList);
		
		request.getRequestDispatcher("/main_student.jsp").forward(request, response);
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}