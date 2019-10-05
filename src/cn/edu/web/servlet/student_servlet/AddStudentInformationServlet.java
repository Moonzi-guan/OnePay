package cn.edu.web.servlet.student_servlet;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.domain.Student;
import cn.edu.service.student_service.StudentInfoService;

public class AddStudentInformationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentInfoService service  = new StudentInfoService();
		//获取页面中的参数
		Map<String, String[]> properties = request.getParameterMap();
		//将参数封装成集合调用插入的方法
		Student  studentList = new  Student();
		studentList.setId(UUID.randomUUID().toString());
		try {
			BeanUtils.populate(studentList, properties);
			service.addStudentInformation(studentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//进行页面的跳转
		request.setAttribute("studentList", studentList);
		response.sendRedirect(request.getContextPath()+"/findAllStudentInformation");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}