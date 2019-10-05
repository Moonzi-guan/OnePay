package cn.edu.service.news_service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.dao.NewsDao;
import cn.edu.domain.News;
import cn.edu.domain.NewsCategory;

public class NewsService {

	public List<News> findAllNews() throws SQLException {
		NewsDao dao = new NewsDao();
		return dao.finAllNews();
 	}

	public void deleteById(String news_id) throws SQLException {
		NewsDao dao = new NewsDao();
		dao.deleteById(news_id);
	}

	public void addNews(News news) throws SQLException {
		NewsDao dao = new NewsDao();
		dao.addNews(news);
	}

	public List<NewsCategory> findAllClassify() throws SQLException {
		NewsDao dao = new NewsDao();
		return dao.findAllClassify();
	}

	public News findNewsById(String news_id) throws SQLException {
		NewsDao dao = new NewsDao();
		return dao.findNewsById(news_id);
	}

}
