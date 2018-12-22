package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		//获取用户请求的url
		String path = request.getRequestURI();
		String st = path.substring(path.lastIndexOf("/")+1);
		if(!st.equals("LoginAction_login.do")){
			//获取session 既就是用户名
			HttpSession session = request.getSession();
			Object object = session.getAttribute("userName");
			if(object==null){
				HttpServletResponse response = (HttpServletResponse)resp;
				response.sendRedirect("login.jsp");
			}
		}
		//将请求继续往下转交
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
