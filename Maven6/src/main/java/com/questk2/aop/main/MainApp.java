package com.questk2.aop.main;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.questk2.aop.config.AppConfig;
import com.questk2.aop.service.MyService;

public class MainApp {
    public static void main(String[] args) {
    	 ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
         
         MyService myService = context.getBean(MyService.class);
         
         // Call methods
         myService.performTask("Test Task");
         int sum = myService.calculateSum(5, 10);
         System.out.println("Sum: " + sum);

         // Exception handling
         try {
             myService.throwException();
         } catch (Exception e) {
             System.out.println("Caught exception in main.");
         }
     }
}
