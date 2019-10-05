package cn.edu.service.message_service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.dao.MessageDao;
import cn.edu.domain.Message;
import cn.edu.domain.Student;
import cn.edu.domain.User;

public class StudentService {
	//查询所有学生
	public List<Message> findAllStudent() throws SQLException {
		MessageDao dao = new MessageDao();
		return dao.findAllStudent();
	}
	//根据id删除指定学生
	public void deleteStudent(String message_sid) throws SQLException {
		MessageDao dao = new MessageDao();
		dao.delteStudent(message_sid);
	}
	//根据学生id获取列表中选中的学生反馈的所有信息
	public Message findStudentById(String message_sid) throws SQLException {
		MessageDao dao = new MessageDao();
		return dao.findStudentById(message_sid);
	}
	//修改学生反馈信息的显示状态
	public void showStudentMessage(String message_sid, String show) throws SQLException {
		MessageDao dao = new MessageDao();
		dao.showStudentMessage(message_sid,show);
	}
	//回复学生的反馈信息
	public void updateStudentMessage(String message_sid,String receive_message_topic,
		String receive_message_content,String receive_message_time) throws SQLException {
		MessageDao dao = new MessageDao();
		dao.updateStudentMessage(message_sid,receive_message_topic,receive_message_content,receive_message_time);
	}




}
