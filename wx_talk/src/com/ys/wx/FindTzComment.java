package com.ys.wx;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.ys.entity.VideoComment;

@WebServlet("/findtzcomment.do")
public class FindTzComment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			List<VideoComment> list = new ArrayList<VideoComment>();

			String id = req.getParameter("id");
			String sql = "select u.head_image,u.name,c.content,c.create_time from t_comment c,t_userinfo u where u.openid in(select openid from t_question where id = "
					+ id + ") and c.ques_id = " + id;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://www.ordinarylife.top:3306/wx_talk", "root", "root");
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				VideoComment comment = new VideoComment();
				comment.setImage(rs.getString("head_image"));
				comment.setName(rs.getString("name"));
				comment.setDate(rs.getString("create_time"));
				comment.setComment(rs.getString("content"));
				list.add(comment);
			}
			resp.setContentType("text/html;charset=utf-8");
			String s = JSON.toJSONString(list);
			PrintWriter pw = resp.getWriter();
			pw.write(s);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
