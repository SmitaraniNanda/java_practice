package com.questk2.sbeans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
        System.out.println("Student Bean: Constructor Called");
    }

    @PostConstruct
    public void init() {
        System.out.println("Student Bean: @PostConstruct (Initialization) Called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Student Bean: @PreDestroy (Cleanup) Called");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
