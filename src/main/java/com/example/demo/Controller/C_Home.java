package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class C_Home {
    @GetMapping("/home")
    public String getHome(HttpSession session, Model model){
        if(session.getAttribute("usuario") != null){
            model.addAttribute("usuario", session.getAttribute("usuario"));
            return "Home/home";
        }else{
            return "redirect:/";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("usuario", null);
        return "redirect:/";
    }
}
