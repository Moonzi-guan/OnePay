package cn.edu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.domain.Message;
import cn.edu.domain.User;
import cn.edu.utils.DataSourceUtils;

public class MessageDao {

	public List<Message> findAllStudent() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from message_for_student";
		return runner.query(sql, new BeanListHandler<Message>(Message.class));
	}

	public void delteStudent(String message_sid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from message_for_student where message_sid = ?";
		runner.update(sql,message_sid);
	}

	public Message findStudentById(String message_sid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from message_for_student where message_sid = ?";
		return runner.query(sql, new BeanHandler<Message>(Message.class),message_sid);
	}

	public void showStudentMessage(String message_sid, String show) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update message_for_student set  `show`=? where message_sid=?";
		runner.update(sql,show,message_sid);
	}

	public void updateStudentMessage(String message_sid,String receive_message_topic,
			String receive_message_content, String receive_message_time) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update message_for_student set receive_message_topic=?,receive_message_content=?,receive_message_time=?"
				+ " where message_sid=?";
		runner.update(sql,receive_message_topic,receive_message_content,receive_message_time,message_sid);
		
		
	}
}
