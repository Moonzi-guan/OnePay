package cn.edu.web.servlet.message_servlet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.domain.Message;
import cn.edu.service.message_service.StudentService;

public class ReplyStudentMessageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//查询学生的反馈信息并且展示在message_reply.jsp页面
		String message_sid =request.getParameter("message_sid");
		StudentService service =  new StudentService();	
		Message student = null;
		try {
			 student = service.findStudentById(message_sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("student", student);
		request.getRequestDispatcher("/message_reply.jsp").forward(request, response);
		
	}
}