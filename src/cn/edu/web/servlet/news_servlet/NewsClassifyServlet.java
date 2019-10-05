package cn.edu.web.servlet.news_servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.domain.News;
import cn.edu.domain.NewsCategory;
import cn.edu.service.news_service.NewsService;

public class NewsClassifyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NewsService service = new NewsService();
		List<NewsCategory> classifyList = null;
		try {
			classifyList = service.findAllClassify();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(classifyList);
		request.setAttribute("classifyList", classifyList);
		request.getRequestDispatcher("/news_add.jsp").forward(request, response);		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}