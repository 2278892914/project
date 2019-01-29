package com.ys.wx;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * flag : 1 文字帖子 flag : 0 图片帖子
 */

@WebServlet("/sendcomment.do")
public class SendTz extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		String comment = req.getParameter("comment");
		String ims = req.getParameter("image");
		String openid = req.getParameter("openid");
		String image;
		if (ims.equals("")) {
			image = "";
		} else {
			image = ims.substring(2, (ims.length() - 2));
		}

		Date d = new Date();
		String date = new SimpleDateFormat("yyyy-MM-dd").format(d);

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://www.ordinarylife.top:3306/wx_talk", "root", "root");

			Statement sta = conn.createStatement();
			String sql = "update t_userinfo  set  send_num = (send_num+1) where openid = '" + openid + "'";
			sta.execute(sql);

			PreparedStatement ps = conn.prepareStatement(
					"insert into t_question(openid,title,create_time,content,image) values(?,?,?,?,?)");

			ps.setString(1, openid);
			ps.setString(2, title);
			ps.setString(3, date);
			ps.setString(4, comment);
			ps.setString(5, image);

			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
