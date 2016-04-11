package com.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Common {
	public static List<HashMap<String, Object>> getMeunList()
	{
		List<HashMap<String, Object>> list_val = new ArrayList<HashMap<String, Object>>(); 
		
		HashMap<String, Object> map_1 = new HashMap<String, Object>();
		map_1.put("Value", "首页");
		map_1.put("Key", "index.jsp");
		HashMap<String, Object> map_2 = new HashMap<String, Object>();
		map_2.put("Value", "测试");
		map_2.put("Key", "test.jsp");
		list_val.add(map_1); 
		list_val.add(map_2); 
		return list_val;
	}
	
	public static String GetMeunStr()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(" <li> Iron Maiden - Brave New World 2000 <ul> <li>The Wicker Man<ul><li>dasdasd</li></ul></li> <li>Ghost Of The Navigator</li></ul><li>dasdas<li>");
		
		return sb.toString();
	}
	
}
