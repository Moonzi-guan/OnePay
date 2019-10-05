package cn.edu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.domain.News;
import cn.edu.domain.NewsCategory;
import cn.edu.utils.DataSourceUtils;

public class NewsDao {

	public List<News> finAllNews() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql =  "select * from news";
		return runner.query(sql, new BeanListHandler<News>(News.class));
	}

	public void deleteById(String news_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql =  "delete from news where news_id = ? ";
		runner.update(sql,news_id);
	}

	public void addNews(News news) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql =  "insert into news (news_id,news_classify,news_topic,news_content,release_time) values(?,?,?,?,?)";
		runner.update(sql,news.getNews_id(),news.getNews_classify(),news.getNews_topic(),news.getNews_content(),news.getRelease_time());
	}

	public List<NewsCategory> findAllClassify() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql =  "select * from news_classify";
		return runner.query(sql, new BeanListHandler<NewsCategory>(NewsCategory.class));
	}

	public News findNewsById(String news_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql =  "select * from news where news_id = ?";
		return runner.query(sql, new BeanHandler<News>(News.class),news_id);
	}

}
