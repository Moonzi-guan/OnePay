package cn.edu.web.servlet.news_servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.domain.News;
import cn.edu.service.news_service.NewsService;
import cn.edu.service.user_service.FindallUserService;

public class FindAllNewsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 传递请求到service层
		NewsService service = new NewsService();
		List<News> newsList = null;
		try {
			newsList = service.findAllNews();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 将userList放到request域
		request.setAttribute("newsList", newsList);
		request.getRequestDispatcher("/main_news.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}