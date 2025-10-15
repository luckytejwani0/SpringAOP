package com.seed.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.seed.config.MyConfig;
import com.seed.service.UserService;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UserService service = context.getBean(UserService.class);
        service.checkUser();
        System.out.println("---------------add---------------");
        int res = service.add(5,4);
        System.out.println("Result : " + res);
        //int res = service.add(5,4);
        System.out.println("---------------checkbalance---------------");
        try {
			service.checkBalance(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("In the main class : " + e);
		}
    }
}
