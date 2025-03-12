package com.questk2.main;

import com.questk2.config.AppConfig;
import com.questk2.sbeans.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        StudentService studentService = context.getBean(StudentService.class);
        studentService.displayStudentDetails();

        // Closing context to trigger @PreDestroy
        context.close();
    }
}
