package yst;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carlist extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
			try {
				//传递过来的数据都是字符串
				//页码
				int page = Integer.parseInt(req.getParameter("page"));
				//当前页显示最多的记录数据
				int pageSize = Integer.parseInt(req.getParameter("pageSize"));
				//连接数据库
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/rent","root","root");
				//执行数据库的sql语句
				PreparedStatement pre = conn.prepareStatement
						("select t1.*,t2.name bname,t3.name sname,t4.name "
								+"tname from tab_car_info t1,tab_brand t2,"
								+"tab_store t3,tab_type t4 where "
								+"t1.brand_id = t2.id and t1.store_id = t3.id and "
								+"t4.id = t1.car_type_id limit ?,?");
				//page-1成pagesize为所查询的页面的第一个对应信息的顺序
				pre.setInt(1, (page-1)*pageSize);
				//pagesize为固定的值
				pre.setInt(2, pageSize);
				ResultSet rs = pre.executeQuery();
				
				//将所查询的数据装如集合当中
				List<CarVO> list = new ArrayList<CarVO>();
				while(rs.next()){
					CarVO car = new CarVO();
					car.setBname(rs.getString("bname"));
					car.setTname(rs.getString("tname"));
					car.setSname(rs.getString("sname"));
					car.setId(rs.getInt("id"));
					car.setHk_sign(rs.getString("hk_sign"));
					car.setLand_sign(rs.getString("land_sign"));
					list.add(car);
				}
				//将集合放入req当中
				req.setAttribute("listCar", list);
				
				//统计表中的 总条数
				PreparedStatement pre1 = conn.prepareStatement("select count(*) total from tab_car_info");
				ResultSet rs1 = pre1.executeQuery();
				int totalSize = 0;
				while(rs1.next()){
					totalSize = rs1.getInt("total");
					
				}
				int totalPage = 0;
				if(totalSize%pageSize==0){
					totalPage = totalSize/pageSize;
				}else{
					totalPage = totalSize/pageSize + 1;
					
				}
				req.setAttribute("totalPage", totalPage);
				
			    //跳转页面
				req.getRequestDispatcher("car_list.jsp").forward(req, resp);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
}
			
	
			