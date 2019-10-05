package cn.edu.service.student_service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.dao.StudentDao;
import cn.edu.domain.Student;

public class StudentInfoService {

	public List<Student> findAllStudentInformation() throws SQLException {
		StudentDao dao = new StudentDao();
		return dao.findAllStudentInformation();
	}

	public void deleteStudentInformation(String student_sid) throws SQLException {
		
		StudentDao dao = new StudentDao();
		dao.deleteStudentInformation(student_sid);
	}

	public Student findStudentInformationById(String student_sid) throws SQLException {
		StudentDao dao = new StudentDao();
		return dao.findStudentInformationById(student_sid);
	}

	public List<Object> findStudentByWord(String word) throws SQLException {
		StudentDao dao = new StudentDao();
		return dao.findStudentByWord(word);
		
	}

	public List<Student> findStudentInformationByName(String student_name) throws SQLException {
		StudentDao dao = new StudentDao();
		return dao.findStudentInformationByName(student_name);
		
	}

	public void addStudentInformation(Student studentList) throws SQLException {
		StudentDao dao = new StudentDao();
		dao.addStudentInformation(studentList);
	}

}
