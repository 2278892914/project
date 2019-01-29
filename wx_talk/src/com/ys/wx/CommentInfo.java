package com.ys.wx;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.NonReadableChannelException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ys.entity.Comment;

import javafx.stage.PopupWindow;

@WebServlet("/commentinfo.do")
public class CommentInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String id = req.getParameter("id");
			String openid = req.getParameter("openid");
			String sql = "select u.head_image,q.id,q.title," + "q.content,q.image,q.create_time "
					+ "from t_userinfo u,t_question q " + "where u.openid='" + openid + "' and q.id=" + id;

			Comment comment = new Comment();

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://www.ordinarylife.top:3306/wx_talk", "root", "root");
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				comment.setId(rs.getInt("id"));
				comment.setHead_image(rs.getString("head_image"));
				comment.setTitle(rs.getString("title"));
				comment.setDate(rs.getString("create_time"));
				comment.setComment(rs.getString("content"));
				comment.setImage(rs.getString("image"));
			}
			String ps = JSON.toJSONString(comment);

			resp.setContentType("text/html;charset=utf-8");

			PrintWriter pw = resp.getWriter();

			pw.write(ps);
			pw.close();
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
