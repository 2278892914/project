package com.ys.wx;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendtzcomment.do")
public class SendTzComment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ques_id = req.getParameter("ques_id");
		String openid = req.getParameter("openId");
		String content = req.getParameter("content");

		Date d = new Date();
		String date = new SimpleDateFormat("yyyy-MM-dd").format(d);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://www.ordinarylife.top:3306/wx_talk", "root", "root");
			// 评论帖子次数
			Statement sta = conn.createStatement();
			String sql = "update t_userinfo  set  comment_num = (comment_num+1) where openid = '" + openid + "'";
			sta.execute(sql);

			PreparedStatement ps = conn
					.prepareStatement("insert into t_comment(ques_id,openid,content,create_time) values(?,?,?,?)");
			ps.setString(1, ques_id);
			ps.setString(2, openid);
			ps.setString(3, content);
			ps.setString(4, date);

			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
