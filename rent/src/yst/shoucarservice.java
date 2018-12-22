package yst;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class shoucarservice extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//加载驱动程序，连接数据库，执行sql语句
			Class.forName("com.mysql.jdbc.Driver");
			Connection comn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/rent","root","root");
			Statement sta = comn.createStatement();
			
			ResultSet rs = sta.executeQuery("SELECT * FROM tab_brand");
			
			//查询车辆品牌信息
			//创建一个集合，类型为BrandVO
			List<BrandVO> listbrand = new ArrayList<BrandVO>();
			//list集合中存放的是BrandVO中的实例，多个BrandVO
			while(rs.next()){
				BrandVO brand = new BrandVO();
				//其中rs的get方法指的是从数据库中所查询的数据
				brand.setId(rs.getInt("id"));
				brand.setName(rs.getString("name"));
				listbrand.add(brand);
			}
			//将所查询到的数据的集合封装为对象，保存在req当中
			req.setAttribute("listbrand", listbrand);
			
			
			//查询门店信息
			Statement sta2 = comn.createStatement();
			ResultSet rs2 = sta.executeQuery("SELECT * FROM tab_store");
			List<StoreVO> liststore = new ArrayList<StoreVO>();
			while(rs2.next()){
				StoreVO store = new StoreVO();
				store.setId(rs2.getInt("id"));
				store.setName(rs2.getString("name"));
				liststore.add(store);
			}
			req.setAttribute("liststore", liststore);
			
			
			//将所查询的门店以及品牌信息装入集合当中，跳转至增加车辆页面，
			req.getRequestDispatcher("add_car.jsp").forward(req, resp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
