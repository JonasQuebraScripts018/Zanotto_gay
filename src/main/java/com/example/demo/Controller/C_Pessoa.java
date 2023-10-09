package com.example.demo.Controller;

import com.example.demo.Model.M_Pessoa;
import com.example.demo.Model.M_Resposta;
import com.example.demo.Service.S_Pessoa;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Pessoa {
    @GetMapping("/")
    public String getCadastro(){
        return "Logar/Usuario";
    }

    @PostMapping("/")
    @ResponseBody
    public boolean PostLogin(@RequestParam("cpf") String cpf,
                             @RequestParam("senha") String senha,
                             HttpSession session){
        session.setAttribute("usuario",S_Pessoa.getPessoaLogin(cpf, senha));
        if(session.getAttribute("usuario")== null){
            return false;
        }else{
            return true;
        }

    }

    @PostMapping("/Cadastrar")
    @ResponseBody
    public M_Resposta setCadastro(@RequestParam("nome") String nome,
                                  @RequestParam("cpf") String cpf,
                                  @RequestParam("email") String email,
                                  @RequestParam("telefone") String telefone,
                                  @RequestParam("datanasc") String datanasc,
                                  @RequestParam("senha") String senha
    ){
        return S_Pessoa.cadastrarPessoa(nome, cpf, email, telefone, datanasc, senha);
    }
    @ModelAttribute("usuario")
    public M_Pessoa getUsuario(HttpSession session) {
        return (M_Pessoa) session.getAttribute("usuario");
    }


}
