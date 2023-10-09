package com.example.demo.Controller;

import com.example.demo.Model.M_Resposta;
import com.example.demo.Service.S_Deposito;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Deposito {
    @GetMapping("/deposito")
    public String getDeposito() {
        return "Deposito/deposito";
    }

    @PostMapping("/deposito")
    @ResponseBody
    public M_Resposta setDeposito(@RequestParam("valorDeposito") Long valorDeposito,
                                  @RequestParam("cpf") String cpf,
                                  @RequestParam("senha") String senha
    ) {
        return S_Deposito.deposito(valorDeposito,cpf, senha);
    }
}
