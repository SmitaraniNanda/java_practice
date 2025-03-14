package com.questk2.controller;

import com.questk2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String listStudents(Model model) {
        model.addAttribute("message", "Spring MVC program");
        return "index"; 
    }
    @GetMapping("/123")
	public String display123(Model model) {
		throw new IllegalArgumentException("error");
	}
}
