package cn.edu.web.servlet.news_servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.domain.News;
import cn.edu.service.news_service.NewsService;

public class AddNewsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取页面参数将其封装到map集合中
		Map<String, String[]> properties = request.getParameterMap();
		News news = new News();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = format.format(new Date());
		news.setRelease_time(date);
		news.setNews_id(UUID.randomUUID().toString());
		try {
			BeanUtils.populate(news, properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//将参数传递到插入方法
		NewsService service = new NewsService();
		try {
			service.addNews(news);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//跳转到findAllNews页面中显示
		response.sendRedirect(request.getContextPath()+"/findAllNews");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}