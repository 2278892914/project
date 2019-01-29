package com.ys.wx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
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



@WebServlet("/findvideotype.do")
public class FindVideoType extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//System.out.println(req.getRequestURI());

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://www.ordinarylife.top:3306/wx_talk", "root", "root");

			Statement sta = conn.createStatement();

			ResultSet rs = sta.executeQuery("select * from t_video_type");

			List<VideoType> list = new ArrayList<VideoType>();
			
			while (rs.next()) {
				VideoType type = new VideoType();
				type.setId(rs.getInt("id"));
				type.setType(rs.getString("type"));
				list.add(type);
				
			}
			// json
           // System.out.println(list);
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
