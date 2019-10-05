package cn.edu.web.servlet.user_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.domain.User;
import cn.edu.service.user_service.UserService;


public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    response.setHeader("Content-type","texthtml;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 用户登录
		// 获得输入的用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 将用户名和密码传递给service层
		UserService service = new UserService();
		User user = null;
		try {
			user = service.login(username, password);
			System.out.println(user);
			//判断用户是否登录成功 user是否是null
			if(user!=null){
				//登录成功
				//重定向到首页
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}else{
				PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>alert('您输入的用户名或密码错误，请与管理员联系!');"
								        +"window.location.href='login.jsp';</script>");
				//request.setAttribute("loginError", "用户名或密码错误");
				//request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}