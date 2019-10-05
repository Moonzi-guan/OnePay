package cn.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.edu.domain.User;
import cn.edu.domain.UserPower;
import cn.edu.utils.DataSourceUtils;
import cn.edu.vo.Condition;

public class UserDao {

		public Long checkUsername(String username) throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select count(*) from user where username=?";
			Long query = (Long) runner.query(sql, new ScalarHandler(), username);
			return query;
		}

		public User login(String username, String password) throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select * from user where username=? and password=?";
			return runner.query(sql, new BeanHandler<User>(User.class), username,password);
		}
		
		public List<User> findAllUser() throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select * from user";
			List<User> userList = runner.query(sql, new BeanListHandler<User>(User.class));
			return userList;
		}
		public void delUserByid(String id) throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "delete from user where id=?";
			runner.update(sql, id);
			
		}
		public List<UserPower> findAllPower() throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select * from userpower";
			List<UserPower> powerList = runner.query(sql, new BeanListHandler<UserPower>(UserPower.class));
			return powerList;
		}

		public void addUser(User user) throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "insert into user values(?,?,?,?,?,?)";
			runner.update(sql,user.getId(),user.getUsername(),user.getPassword(),user.getPower(),user.getLock(),user.getDate());
		}

		public User findUserByid(String id) throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select * from user where id=?";
			return runner.query(sql, new BeanHandler<User>(User.class), id);
		}

		public void userUpdate(User user) throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "update user set username=?,password=?,power=?, `lock`=?,date=? where id=?";
			runner.update(sql,user.getUsername(),user.getPassword(),user.getPower(),user.getLock(),user.getDate(),user.getId());
		}

		public List<User> findUserByCondition(Condition condition) throws SQLException {
		
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			//定义一个存储实际参数的容器
			List<String> list = new ArrayList<String>();
			String sql = "select * from user where 1=1";
			if(condition.getUsername()!=null&&!condition.getUsername().trim().equals("")){
				sql+=" and username like ? ";
				list.add("%"+condition.getUsername().trim()+"%");
			}
			List<User> userList = runner.query(sql, new BeanListHandler<User>(User.class) , list.toArray());
			
			return userList;
			
		}
		
		
		//获得全部的商品条数
		public int getTotalCount() throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select count(*) from user";
			Long query = (Long) runner.query(sql, new ScalarHandler());
			return query.intValue();
		}
		
		//获得分页的商品数据
		public List<User> findUserListForPageBean(int index, int currentCount) throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
				String sql = "select * from user limit ?,?";
				return runner.query(sql, new BeanListHandler<User>(User.class), index,currentCount);
		}
}
