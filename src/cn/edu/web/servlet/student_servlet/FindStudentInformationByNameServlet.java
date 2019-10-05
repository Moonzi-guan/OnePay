package cn.edu.web.servlet.student_servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.domain.Student;
import cn.edu.service.message_service.StudentService;
import cn.edu.service.student_service.StudentInfoService;

public class FindStudentInformationByNameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String student_name = request.getParameter("student_name");
		System.out.println(student_name);
		List<Student> studentList = null;
		StudentInfoService service  = new StudentInfoService();
		
		try {
			studentList = service.findStudentInformationByName(student_name);
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