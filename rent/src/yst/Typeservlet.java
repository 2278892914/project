package yst;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class Typeservlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//型号
			String id = req.getParameter("id");
			
			//加载数据库进行查询车辆型号
			Class.forName("com.mysql.jdbc.Driver");
			Connection comn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/rent","root","root");
			PreparedStatement pre = (PreparedStatement) comn.prepareStatement("SELECT * FROM tab_type WHERE b_id=?");
			
			pre.setString(1,id);
			
			ResultSet rs = pre.executeQuery();
			
			List<TypeVO> listType = new ArrayList<TypeVO>();
			
			//将车辆型号存入到集合当中
			while(rs.next()){
				TypeVO t = new TypeVO();
				t.setId(rs.getInt("id"));
				t.setName(rs.getString("name"));
				listType.add(t);
			}
			
			//将指定对象转换成对应的json格式变量
			String msg = JSON.toJSONString(listType);
			//设置返回形式以及字符编码
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			//发送数据/响应数据，由于req和resp中间有一个连接，然后通过特殊的流将数据写入到resp当中
			pw.write(msg);
			//System.out.println(msg);
		} catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
