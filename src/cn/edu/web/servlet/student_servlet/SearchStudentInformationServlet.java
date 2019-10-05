package cn.edu.web.servlet.student_servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.service.student_service.StudentInfoService;

import com.google.gson.Gson;

public class SearchStudentInformationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentInfoService service = new StudentInfoService();
		//1.获得页面中传递过来的参数word
		String word = request.getParameter("word");
		//2.查询该关键字的所有学生信息
		System.out.println(word);
		List<Object> studentList = null;
		try {
			studentList = service.findStudentByWord(word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//调用json方法进行数据传递
		Gson gson = new Gson();
		String json = gson.toJson(studentList);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}