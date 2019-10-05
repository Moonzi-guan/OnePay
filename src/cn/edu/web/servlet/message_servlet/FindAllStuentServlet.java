package cn.edu.web.servlet.message_servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.domain.Message;
import cn.edu.service.message_service.StudentService;

public class FindAllStuentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentService service = new StudentService();

		List<Message> message_fromstudentList = null;
		try {
			message_fromstudentList = service.findAllStudent();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("message_fromstudentList", message_fromstudentList);

		request.getRequestDispatcher("/main_message.jsp").forward(
				request,response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}