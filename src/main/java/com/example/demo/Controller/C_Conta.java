package com.example.demo.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Conta {
    @GetMapping("/conta")
    public String getconta(HttpSession session, Model model){
        if(session.getAttribute("usuario") != null){
            model.addAttribute("usuario", session.getAttribute("usuario"));
            return "Conta/conta";
        }else{
            return "redirect:/";
        }

    }
}
