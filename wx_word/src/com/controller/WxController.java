package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Area;
import com.entity.User;
import com.entity.Word;
import com.mysql.jdbc.StandardSocketFactory;
import com.serviceImpl.WxServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

@Controller
@Scope("prototype")
public class WxController {

	@Autowired
	private WxServiceImpl service;

	// 测试
	@RequestMapping("/test.action")
	public ModelAndView modelmap() {
		ModelAndView model = new ModelAndView();
		System.out.println("启动成功");
		List<Area> list = service.selectlist();
		System.out.println(list);
		return model;
	}

	/*
	 * 日志信息
	 */
	@ResponseBody
	@RequestMapping("/infor.action")
	public Map<Object, Object> infor() throws Exception {
		Map<Object, Object> map = new HashMap<Object, Object>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time = df.format(new Date());
		String dstr = "2019-06-08 00:00:00 ";
		java.util.Date date = df.parse(dstr);
		long s1 = date.getTime();// 将时间转为毫秒
		long s2 = System.currentTimeMillis();// 得到当前的毫秒
		int distance = (int) ((s1 - s2) / 1000 / 60 / 60 / 24);

		map.put("time", time);
		map.put("weather", "多云");
		map.put("distance", distance);

		return map;
	}

	/*
	 * 列表单词展示
	 */
	@Autowired
	HttpServletRequest request;

	@ResponseBody
	@RequestMapping("/selectword.action")
	public List<Word> selectword(String id, String openid) { // id为四张表的标识

		/**
		 * 查找单词需要的变量： b_id:表的id 区分四张表的不同 start:单词id起始 每次单词开始的起始id endwith:单词id终止
		 * start+endwith
		 * flag:单词标记位，既就是plane,如果flag从0每次加加达到flag则用户日志表中的id起始量，数值为+plane
		 * 未成功记忆的单词则则个人信息表中统一获取,获取原则是： 查找日志表中的id与单词表中的id以前状态为0的单词，然后统一记忆，不设单词记忆量
		 */
		/**
		 * 首先获取单词起始id,plane,信息
		 */
		User user = null;
		user = service.getrecord(id, openid);
		System.out.println(user);
		int plane = user.getPlane();
		// 表的标识 用户名 查找用户记录
		int flag = service.getflag(id, openid);
		System.out.println("flag:" + flag);
		System.out.println(flag + "  " + plane);
		if (flag < plane) {
			System.out.println("小于等于");
		}

		if (flag >= plane) {
			/**
			 * 如果相等，更改t_record中flag记录为0,以便下次继续记录， 更改单词表中的id的值,既就是更改t_info表中的id
			 */
			int statwith = 0;
			if (id.equals("u")) {
				statwith = user.getU_word();
			}
			if (id.equals("h")) {
				statwith = user.getH_word();
			}
			if (id.equals("m")) {
				statwith = user.getM_word();
			}
			if (id.equals("p")) {
				statwith = user.getP_word();
			}
			System.out.println("genggai ");
			// 更改表中的id起始值 需要的信息 openid，哪张表的id
			// System.out.println(id+" "+openid+" "+plane );

			service.updatestartwitdid(id, openid, (statwith + plane));
			// System.out.println("更改完毕");
			service.mupdateflag(id, openid);// 标记位
			user = service.getrecord(id, openid);
			System.out.println(user);
		}

		int statwith = 0;
		if (id.equals("u")) {
			statwith = user.getU_word();
		}
		if (id.equals("h")) {
			statwith = user.getH_word();
		}
		if (id.equals("m")) {
			statwith = user.getM_word();
		}
		if (id.equals("p")) {
			statwith = user.getP_word();
		}
		List<Word> list = new ArrayList<>();

		list = service.selectword(id, statwith, plane);
		// System.out.println(list);
		return list;
	}

	/*
	 * 背诵单词
	 */
	@ResponseBody
	@RequestMapping("/reciteword.action")
	public Word recite(String w_id, String t_id, String name, String openid) {
		int id = Integer.parseInt(w_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("w_id", id);
		map.put("name", name);
		map.put("t_id", t_id);
		// 时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time = df.format(new Date());
		map.put("recitetime", time);
		Word word = service.reciteword(map);
		// System.out.println(word);
		if (word != null) {
			// 更新数据库 state状态转换为1
			service.updatawordstate(map);
			// 将t_record中的flag加1
			int flag = service.getflag(t_id, openid);
			++flag;
			// 更新flag
			service.updateflag(flag, t_id, openid);

		}
		return word;
	}

	// 查询个人信息
	@ResponseBody
	@RequestMapping("/getinfo.action")
	public User getinfo() {
		User user = service.getinfo();
		return user;
	}

	// 更改个人信息
	@ResponseBody
	@RequestMapping("/updateinfo.action")
	public void updateinfo(User user) {
		service.updateinfo(user);
	}

	// 获取用户openid
	@ResponseBody
	@RequestMapping("/openid.action")
	public void openid(String res) {
		System.out.println(res);
	}

	// 查看历史记录
	@ResponseBody
	@RequestMapping("/historicrecord.action")
	public Map<Object, Object> historicrecord(String id, String openid) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		// 查找已背单词的数量   四个表查找状态为1的数量
		int yiwords = service.yiwords();
		System.out.println(yiwords);
		// 查询未背单词的数量 四个表中状态为0的数量
		int weiwords = service.weiwords();
		System.out.println(weiwords);
		map.put("yiwords", yiwords);
		map.put("weiwords", weiwords);
		return map;
	}

	// 查看已经背过的单词
	@ResponseBody
	@RequestMapping("/yiwords.action")
	public List<Word> yiwords() {
		List<Word> list = new ArrayList<Word>();
		list = service.selectyiwords();
		return list;
	}
	
	// 查看未背过的单词
		@ResponseBody
		@RequestMapping("/weiwords.action")
		public List<Word> weiwords() {
			List<Word> list = new ArrayList<Word>();
			list = service.selectweiwords();
			System.out.println(list);
			return list;
		}

	
	
	
}
