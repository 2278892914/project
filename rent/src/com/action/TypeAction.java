package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.service.Typeservice;

import VO.TypeVO;

public class TypeAction extends HttpServlet{

	
	protected void findType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
		//型号
		String id = req.getParameter("id");
		
		Typeservice ts = new Typeservice();
		
		List<TypeVO> listType = ts.type(id);
		//将指定对象转换成对应的json格式变量
		String msg = JSON.toJSONString(listType);
		//设置返回形式以及字符编码
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		//发送数据/响应数据，由于req和resp中间有一个连接，然后通过特殊的流将数据写入到resp当中
		pw.write(msg);
		//System.out.println(msg);
	}
}
