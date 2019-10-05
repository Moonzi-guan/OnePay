package cn.edu.web.servlet.message_servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.domain.Message;
import cn.edu.domain.User;
import cn.edu.service.message_service.StudentService;

public class ShowStuentMessageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//该类主要是用于修改学生的反馈信息是否能够展示在前台页面
		String message_sid = request.getParameter("message_sid");
		String show = request.getParameter("show");
		StudentService service = new StudentService();
		Message student = null;
		 try {
			service.showStudentMessage(message_sid,show);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		 try {
			 student = service.findStudentById(message_sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("student", student);
		request.getRequestDispatcher("/message_info.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}