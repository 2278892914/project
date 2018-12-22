package yst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test {

	public static void main(String[] args) {
		
		try {
			
			//创建一个请求的url地址
			URL url = new URL("http://localhost:8080/rent/mm.do");
			URLConnection con = url.openConnection();
			InputStream is = con.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			
			BufferedReader bf = new BufferedReader(isr);
			String s = null;
			while((s=bf.readLine())!=null){
				System.out.println(s);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
