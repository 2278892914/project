package com.ys.wx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ys.entity.Video;
import com.ys.entity.VideoType;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 查看视频类型
 * 
 */



@WebServlet("/findvideo.do")
public class FindVideo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String id = req.getParameter("video_id");
			
			//System.out.println(id);
			//System.out.println(flag);
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://www.ordinarylife.top:3306/wx_talk", "root", "root");

			Statement sta = conn.createStatement();
            String sql = "select * from t_video where video_type = "+id;
			ResultSet rs = sta.executeQuery(sql);
			
			
			List<Video> list = new ArrayList<Video>();
			
			while (rs.next()) {
				Video vedio = new Video();
				vedio.setId(rs.getInt("id"));
				vedio.setVideo_url(rs.getString("video_url"));
				vedio.setVideo_name(rs.getString("video_name"));
				vedio.setVideo_introduce(rs.getString("video_introduce"));
				vedio.setImage(rs.getString("image"));
				list.add(vedio);
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
