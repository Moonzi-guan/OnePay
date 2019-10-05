package cn.edu.web.servlet.message_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.domain.Message;
import cn.edu.service.message_service.StudentService;

public class UpdateStudentMessageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		StudentService service = new StudentService();
		Map<String, String[]> properties = request.getParameterMap();
		Message student = new Message();
		try {
			BeanUtils.populate(student, properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//封装页面中没有的数据，回复时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = format.format(new Date());
		student.setReceive_message_time(date);
		
		//更新学生表的数据
		PrintWriter out = response.getWriter();
		if(student.getReceive_message_topic()!=""&&student.getReceive_message_content()!=""){
			try {
				service.updateStudentMessage(student.getMessage_sid(),student.getReceive_message_topic(),student.getReceive_message_content(),student.getReceive_message_time());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(student.getReceive_message_topic()!=""&&student.getReceive_message_content()==""){
			out.println("<SCRIPT LANGUAGE='JavaScript'>alert('请填写\"回复的内容\"！');</SCRIPT>");
		}else{
			out.println("<SCRIPT LANGUAGE='JavaScript'>alert('请填写\"回复的主题\"！');</SCRIPT>");
		}
		//查询学生表的信息
		 try {
			student = service.findStudentById(student.getMessage_sid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("student", student);
		request.getRequestDispatcher("/message_reply.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}