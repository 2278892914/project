package com.ys.wx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ys.entity.Openid;
import com.ys.entity.User;

@WebServlet("/finduserinfo.do")
public class FindUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String code = req.getParameter("code");
			String res = req.getParameter("res");
			Gson gson = new Gson();
			User stu = gson.fromJson(res, User.class);
			String image = stu.getAvatarUrl(); // 用户头像
			String name = stu.getNickName(); // 用户昵称
			int gender = stu.getGender();
			String country = stu.getCountry();
			String city = stu.getCity();
			String getopenidurl = "https://api.weixin.qq.com/sns/jscode2session?" + "appid=wxe2da40b6a32970b8&"
					+ "secret=060eb53ff757a3e1740fc98590a946fa&js_code=" + code + "&grant_type=authorization_code";
			StringBuffer sb = new StringBuffer();
			InputStreamReader isr = null;
			BufferedReader br = null;

			// 发送请求，获取用户的openid
			URL url = new URL(getopenidurl);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setAllowUserInteraction(false);
			isr = new InputStreamReader(url.openStream());
			br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			// 解析json数据，获取openid
			Openid open = gson.fromJson(sb.toString(), Openid.class);
			String openid = open.getOpenid();

			// 判断此人是否存在 调用数据库

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://www.ordinarylife.top:3306/wx_talk", "root", "root");
			Statement sta = conn.createStatement();
			String sql = "select * from t_userinfo where openid =" + "'" + openid + "'";
			ResultSet rs = sta.executeQuery(sql);

			if (!rs.next()) { // 没有此人, 则进行插入数据库

				String insertsql = "insert into t_userinfo(openid,name,head_image,country,city,gender) values('"
						+ openid + "','" + name + "','" + image + "','" + country + "','" + city + "'," + gender + ")";
				/*
				 * System.out.println(insertsql); System.out.println(image.length());
				 */
				sta.execute(insertsql);
			} else {
			}

			resp.setContentType("text/html;charset=utf-8");

			PrintWriter pw = resp.getWriter();
			pw.write(sb.toString());

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
