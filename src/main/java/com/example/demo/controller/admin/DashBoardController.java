package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardController {

    @GetMapping("/admin") 
    public String adminDashboard() {
        return "admin/dashboard/show"; // Return the view for the admin dashboard
    }
}
