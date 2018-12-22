package yst;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginserver extends HttpServlet{

	@Override
	/*
	 * 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	//方法参数中的req中保存的是获取到的所有数据，这个功能是由服务器实现的，既就是把用户提交的数据给当前页面
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("提交进来了");
		String path = req.getRequestURI();
		System.out.println(path);
		//获取当前用户过来的登录信息
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		//检验用户登录是否准确
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection comn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/rent","root","root");
			//sql语句中用and是同时满足用户名和密码相等，进而返回结果
			//预处理
			PreparedStatement pre = comn.prepareStatement("SELECT * FROM tab_user WHERE login_name=? AND password=?");
			pre.setString(1, user);
			pre.setString(2, pass);
			//执行sql语句
			ResultSet rs = pre.executeQuery();
	
			if(rs.next()){
				
				//手动设置session
				HttpSession session = req.getSession();
				session.setAttribute("userName", rs.getString("user_name"));
				
				//登录成功，跳转下一个页面
				req.getRequestDispatcher("home.jsp").forward(req, resp);
			}else{
				System.out.println("登录失败");
				String msg = "输入的用户名或者密码错误";
				//登录失败，提示错误信息，并且继续跳转到当前页面
				//setAttribute，表示给dom添加属性，方法内有两个参数，一个是属性名，一个是属性的值
				req.setAttribute("error", msg);
				
				//使用转发，发送提示错误信息
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}











