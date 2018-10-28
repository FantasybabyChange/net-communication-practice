package com.fantasybaby.client;

import com.fantasybaby.client.swing.Swingclient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动函数
 * @author admin
 *
 */
public class ClientMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Swingclient swing = applicationContext.getBean(Swingclient.class);
		swing.setVisible(true);
	}

}
