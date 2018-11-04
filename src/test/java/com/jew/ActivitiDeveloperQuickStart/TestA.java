package com.jew.ActivitiDeveloperQuickStart;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class TestA {

	@Test
	public void say(){
		String wsd="{\"CODE\":\"200\",\"MESSAGE\":\"查询成功\",\"result\":{\"resultObj\":{\"applicationDetialInfo\":[],\"badInfo\":{},\"loanRejectionDetailInfo\":[],\"mobileCheckResult\":\"一致\",\"overdueInfo\":[],\"userCheckResult\":\"一致\"},\"scoreMsg\":{\"appCheckNormalResult\":\"正常\",\"badCheckNormalResult\":\"正常\",\"loanCheckNormalResult\":\"正常\",\"mobileCheckNormalResult\":\"正常\",\"overdueCheckNormalResult\":\"正常\",\"userCheckNormalResult\":\"正常\"},\"totalPoints\":24}}";
		String zx91="{\"socre\":\"773\",\"suggest\":\"\"}";
		String td="{\"addressDetect\":{\"idCardAddress\":\"四川省南充市顺庆区\",\"mobileAddress\":\"四川省成都市\"},\"applicationId\":\"171204105316443563C15F3F43C2777C\",\"applyTime\":1512355996000,\"finalDecision\":\"Accept\",\"finalScore\":5,\"reportId\":\"ER20171204105316B60A79B4\",\"reportTime\":1512355996000,\"riskItems\":[{\"group\":\"风险信息扫描\",\"itemDetail\":{\"fraudType\":\"异常借款\",\"namelistHitDetails\":[{\"description\":\"身份证命中中风险关注名单\",\"fraudType\":\"异常借款\",\"hitTypeDisplayname\":\"借款人身份证\",\"type\":\"grey_list\"}]},\"itemId\":7784143,\"itemName\":\"身份证命中中风险关注名单\",\"riskLevel\":\"low\"}],\"success\":true}";
		Object objWsd=JSON.parse(wsd);
		Object objZx91=JSON.parse(zx91);
		Object objTd=JSON.parse(td);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("NAME", "杨建国");
		map.put("ID_NUMBER", "510212196804280452");
		map.put("CELL_PHONE_NUMBER", "13699463371");
		map.put("RS_TD_PERSONAL", objTd);
		map.put("RS_WSD_PERSONAL", objWsd);
		map.put("RS_91_CREDIT", objZx91);
	    
	    Map<String,Object> text = new HashMap<String,Object>();
	    text.put("account", "superadmin");
	    text.put("data", map);
	    String json = JSON.toJSONString(map);
	    System.out.println(json);
	}
	
	@Test
	public void testList(){
		List<String> list=new LinkedList<String>();
		list.add("1=");
		list.add("2=");
		list.add("3=");
		list.add("4=");
		System.out.println(list.get(2));
	}
}
