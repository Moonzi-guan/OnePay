package cn.edu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import cn.edu.domain.Student;
import cn.edu.utils.DataSourceUtils;

public class StudentDao {

	public List<Student> findAllStudentInformation() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from student_information";
		return runner.query(sql, new BeanListHandler<Student>(Student.class));
	}

	public void deleteStudentInformation(String student_sid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from student_information where student_sid=?";
		runner.update(sql, student_sid);
	}

	public Student findStudentInformationById(String student_sid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from student_information where student_sid=?";
		return runner.query(sql, new BeanHandler<Student>(Student.class),student_sid);
	}

	public List<Object> findStudentByWord(String word) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from student_information where student_name like ?";
		List<Object> query = runner.query(sql, new ColumnListHandler("student_name"), "%"+word+"%");
		return query;
	}

	public List<Student> findStudentInformationByName(String student_name) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from student_information where student_name like ?";
		List<Student> list = runner.query(sql, new BeanListHandler<Student>(Student.class),"%"+student_name+"%");
		return list;
	}

	public void addStudentInformation(Student studentList) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into student_information values(?,?,?,?,?,?,?,?,?)";
		runner.update(sql,studentList.getId(),studentList.getStudent_sid(),studentList.getStudent_name(),studentList.getStudent_sex(),studentList.getStudent_major(),studentList.getStudent_class(),studentList.getStudent_addr(),studentList.getStudent_money(),studentList.getStudent_status());
	}

}
