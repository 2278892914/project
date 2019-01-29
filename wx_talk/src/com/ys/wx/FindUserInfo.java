package com.ys.wx;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ys.entity.User;
import com.ys.entity.Video;

@WebServlet("/finduserinfoin.do")
public class FindUserInfo extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String openid = req.getParameter("openId");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://www.ordinarylife.top:3306/wx_talk", "root", "root");

			Statement sta = conn.createStatement();
            String sql = "select * from t_userinfo where openid ='"+openid+"'";
			ResultSet rs = sta.executeQuery(sql);
			User user = new User();
			while (rs.next()) {
				user.setAvatarUrl(rs.getString("head_image"));
				user.setNickName(rs.getString("name"));
				user.setCity(rs.getString("city"));
				user.setComment_num(rs.getInt("comment_num"));
				user.setSend_num(rs.getInt("send_num"));
				user.setLook_num(rs.getInt("look_num"));
			}
			
            //System.out.println(video);
			String s = JSON.toJSONString(user);
            
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
}
