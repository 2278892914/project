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
import com.ys.entity.VideoType;

@WebServlet("/findvideocomment.do")
public class FindVideoComment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("video_id");
		//String openid = req.getParameter("openId");
		//System.out.println(id);
		//System.out.println(openid);
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://www.ordinarylife.top:3306/wx_talk", "root", "root");

			Statement sta = conn.createStatement();

			ResultSet rs = sta.executeQuery("select u.head_image,u.name,c.comment,c.creat_time from t_video_comment c,t_userinfo u where u.openid in(select openid from t_video_comment where video_id = "+id+") and  c.video_id = "+id);

			List<VideoComment> list = new ArrayList<VideoComment>();

			while (rs.next()) {
				VideoComment comt = new VideoComment();
				comt.setImage(rs.getString("head_image"));
				comt.setName(rs.getString("name"));
				comt.setDate(rs.getString("creat_time"));
				comt.setComment(rs.getString("comment"));
				list.add(comt);

			}
			// json
			//System.out.println(list);

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
