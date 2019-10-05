package cn.edu.web.servlet.news_servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.service.news_service.NewsService;

public class DeleteNewsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1过去页面中传递过来的参数
		String news_id = request.getParameter("news_id");
		//2调用方法删除指定id的数据
		NewsService service = new NewsService();
		try {
			service.deleteById(news_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//3重定向到指定页面
		response.sendRedirect(request.getContextPath()+"/findAllNews");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}