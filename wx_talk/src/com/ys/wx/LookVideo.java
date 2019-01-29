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
import com.ys.entity.Openid;
import com.ys.entity.Video;

@WebServlet("/lookvideo.do")
public class LookVideo extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("video_id");
			String openid = req.getParameter("openId");
			//System.out.println(id);
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://www.ordinarylife.top:3306/wx_talk", "root", "root");

			//Statement sta = conn.createStatement();
			String sql1 = "update t_userinfo  set  look_num = (look_num+1) where openid = '"+openid+"'";
		    //sta.execute(sql);
			Statement sta = conn.createStatement();
            String sql = "select * from t_video where id ="+id;
            //System.out.println(sql);
            sta.executeUpdate(sql1);
			ResultSet rs = sta.executeQuery(sql);
			Video video = new Video();
			while (rs.next()) {
				video.setVideo_url(rs.getString("video_url"));
				video.setId(rs.getInt("id"));
			}
			
            //System.out.println(video);
			String s = JSON.toJSONString(video);
            
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
