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
import com.ys.entity.Comment;

@WebServlet("/findcomment.do")
public class FindComment extends HttpServlet {

	/**
	 * flag : 1 文字帖子 flag : 0图片帖子
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String findV = req.getParameter("findV");
			String flag = req.getParameter("flag");
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://www.ordinarylife.top:3306/wx_talk", "root", "root");

			Statement sta = conn.createStatement();

			List<Comment> list = new ArrayList<Comment>();

			ResultSet rs = null;

			if (flag.equals("like")) {
				String sql = "select q.id,u.head_image,q.title,q.create_time from t_question q,t_userinfo u where q.openid = u.openid and q.title like"
						+ "'%" + findV + "%'";
				rs = sta.executeQuery(sql);
			}
			if (flag.equals("all")) {
				rs = sta.executeQuery(
						"select q.id,u.head_image,q.title,q.create_time from t_question q,t_userinfo u where q.openid = u.openid");
			}

			while (rs.next()) {
				Comment comn = new Comment();
				comn.setId(rs.getInt("id"));
				comn.setTitle(rs.getString("title"));
				comn.setHead_image(rs.getString("head_image"));
				comn.setDate(rs.getString("create_time"));
				list.add(comn);

			}
			String s = JSON.toJSONString(list);

			resp.setContentType("text/html;charset=utf-8");

			PrintWriter pw = resp.getWriter();
			pw.write(s);

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
