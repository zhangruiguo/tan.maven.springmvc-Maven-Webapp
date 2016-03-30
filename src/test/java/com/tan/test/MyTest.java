package com.tan.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MyTest {

	public static void main(String[] args) {
		HashMap<String, Object> m = new HashMap<String, Object>();
		HashMap<String, Object> map_col = new HashMap<String, Object>();
		map_col.put("field", "Tables_in_stat_data");
		HashMap<String, Object> map_val = new HashMap<String, Object>();
		map_val.put("Tables_in_stat_data", "campaign_channel");
		List<HashMap<String, Object>> list_col = new ArrayList<HashMap<String, Object>>();
		List<HashMap<String, Object>> list_val = new ArrayList<HashMap<String, Object>>();
		list_col.add(map_col);
		list_val.add(map_val);
		m.put("columns", list_col);
		m.put("rows", list_val);
		
		//list_val=com.manager.Common.getMeunList();
		String s = com.alibaba.fastjson.JSON.toJSONString(m);
		System.out.println(s);
	}
}
