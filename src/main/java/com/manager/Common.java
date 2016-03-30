package com.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Common {
	public static List<HashMap<String, Object>> getMeunList()
	{
		List<HashMap<String, Object>> list_val = new ArrayList<HashMap<String, Object>>(); 
		
		HashMap<String, Object> map_1 = new HashMap<String, Object>();
		map_1.put("Value", "我的报表|管理|管理我收藏的报表");
		map_1.put("Key", "/home/FavorReportManager");
		HashMap<String, Object> map_2 = new HashMap<String, Object>();
		map_2.put("Value", "自定义报表|市场统计|用户发贴数据核对");
		map_2.put("Key", "/CustomBaseReportManagement/CustomBaseReportManager?reportId=20081");
		list_val.add(map_1); 
		list_val.add(map_2); 
		return list_val;
	}
}
