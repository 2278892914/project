package com.ys.wx;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/commentvideo.do")
public class CommentVideo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("video_id");
		String openId = req.getParameter("openId");
		String comment = req.getParameter("comment");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://www.ordinarylife.top:3306/wx_talk", "root", "root");
			Statement sta = conn.createStatement();
			Date d = new Date();
			String date = new SimpleDateFormat("yyyy-MM-dd").format(d);
			String sql = "insert into t_video_comment(video_id,openid,comment,creat_time) values(" + id + ",'" + openId
					+ "','" + comment + "','" + date + "')";
			sta.execute(sql);

			sta.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
