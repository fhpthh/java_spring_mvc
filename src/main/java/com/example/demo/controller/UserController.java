package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;



@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/")
    public String getHomePage(Model model) {
        // List<User> users = this.userService.getAllUserByEmail("hue@gmail.com");
        // System.out.println("Users: " + users);
        model.addAttribute("test", "test");
        return "hello";
    }
    @RequestMapping("/admin/user")
    public String getUserTablePage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/table";
    }
    @RequestMapping("/admin/user/{id}") //GET
    public String getUserDetailPage(Model model, @PathVariable Long id) {
        System.out.println("User ID: " + id);
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/show";
    }
    @RequestMapping("/admin/user/create") //GET
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    
    @RequestMapping(value = "/admin/user/create", method=RequestMethod.POST) 
    public String createUserPage(Model model, @ModelAttribute("newUser") User pthh) {
        this.userService.handleSaveUser(pthh);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("newUser", user);
        return "admin/user/update";
    }
    @PostMapping(value = "/admin/user/update")
    public String UpdateUser(Model model, @ModelAttribute("newUser") User pthh) {
        User user = this.userService.getUserById(pthh.getId());
        if(user != null) {
            user.setFullName(pthh.getFullName());
            user.setPhone(pthh.getPhone());
            user.setAddress(pthh.getAddress());
            this.userService.handleSaveUser(user);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable Long id) {
        model.addAttribute("id", id);
        model.addAttribute("newUser", new User());
        return "admin/user/delete";
    }
    @PostMapping("/admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("newUser") User user) {
        this.userService.deleteUserById(user.getId());
        return "redirect:/admin/user";
    }
}

