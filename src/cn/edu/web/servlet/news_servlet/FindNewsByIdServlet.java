package cn.edu.web.servlet.news_servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.domain.News;
import cn.edu.service.news_service.NewsService;

public class FindNewsByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String news_id = request.getParameter("news_id");
		News news = null;
		NewsService service = new NewsService();
		
		try {
			news = service.findNewsById(news_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("news", news);
		request.getRequestDispatcher("/news_info.jsp").forward(request,response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}