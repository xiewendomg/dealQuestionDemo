package com.jew.ActivitiDeveloperQuickStart;

import com.xiewendomg.admin.java.RPC.HelloWorldService;
import com.xiewendomg.admin.java.RPC.RPCProxyClient;
import org.junit.Test;

public class TestA {

	@Test
	public void say(){
		Object o =  RPCProxyClient.getProxy(HelloWorldService.class);
//		helloWorldService.sayHello("rpc");
	}
}
