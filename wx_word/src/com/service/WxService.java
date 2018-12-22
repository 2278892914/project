package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Area;
import com.entity.User;
import com.entity.Word;

public interface WxService {

	public List<Area> selectlist();

	public List<Word> selectword(String id, int statwith, int plane);

	public Word reciteword(Map<String, Object> map);

	public void updatawordstate(Map<String, Object> map);

	public Word getword(Map<Object, Object> map);

	public User getinfo();

	public void updateinfo(User user);

	public User getrecord(String id, String openid);

	public int getflag(String t_id, String openid);

	public void updateflag(int flag, String t_id, String openid);

	public void updatestartwitdid(String id, String openid, int ff);

	public void mupdateflag(String id, String openid);

	public int yiwords();

	public int weiwords();
	
	public List<Word> selectyiwords();
	
	public List<Word> selectweiwords();

}
