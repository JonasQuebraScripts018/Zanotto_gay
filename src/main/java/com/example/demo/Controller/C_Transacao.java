package com.example.demo.Controller;

import com.example.demo.Model.M_Resposta;
import com.example.demo.Service.S_Transacao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Transacao {
    @GetMapping("/transacao")
    public String getTransacao(){
        return "transação/transacao";
    }

    @PostMapping("/transacao")
    @ResponseBody
    public M_Resposta setTransacao(@RequestParam("valorTransacao") Long valorTransacao,
                                   @RequestParam("cpf") String cpf,
                                   @RequestParam("senha") String senha){
        return S_Transacao.trasacao(valorTransacao, cpf, senha);
    }
}
