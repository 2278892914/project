package com.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Area;
import com.entity.User;
import com.entity.Word;
import com.mapper.WxDaoMapper;
import com.service.WxService;

@Service
public class WxServiceImpl implements WxService {

	@Autowired
	private WxDaoMapper dao;

	@Override
	public List<Area> selectlist() {

		return dao.selectlist();
	}

	@Override
	public void updatawordstate(Map<String, Object> map) {
		dao.updatawordstate(map);
	}

	@Override
	public List<Word> selectword(String id, int statwith, int plane) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("statwith", statwith);
		map.put("plane", plane);
		return dao.selectword(map);
	}

	@Override
	public Word reciteword(Map<String, Object> map) {
		return dao.reciteword(map);
	}

	@Override
	public Word getword(Map<Object, Object> map) {

		return dao.getword(map);
	}

	@Override
	public User getinfo() {

		return dao.getinfo();
	}

	@Override
	public void updateinfo(User user) {
		dao.updateinfo(user);
	}

	@Override
	public User getrecord(String id, String openid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("b_id", id);
		map.put("id", openid);
		return dao.getrecord(map);
	}

	@Override
	public int getflag(String t_id, String openid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("t_id", t_id);
		map.put("openid", openid);
		return dao.getflag(map);
	}

	@Override
	public void updateflag(int flag, String t_id, String openid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);
		map.put("t_id", t_id);
		map.put("openid", openid);
		dao.updateflag(map);
	}

	public void updatestartwitdid(String id, String openid, int plane) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("t_id", id);
		map.put("openid", "123");
		map.put("plane", plane);
		System.out.println("map集合222222222" + map);
		dao.tartwitdid(map);
	}

	public void mupdateflag(String id, String openid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("t_id", id);
		map.put("openid", openid);
		dao.mupdateflag(map);
	}

	public int yiwords() {
		return dao.yiwords();
	}

	public int weiwords() {

		return dao.weiwords();
	}

	@Override
	public List<Word> selectyiwords() {
		
		return dao.selectyiwords();
	}
	
	@Override
	public List<Word> selectweiwords() {
		
		return dao.selectweiwords();
	}


}
