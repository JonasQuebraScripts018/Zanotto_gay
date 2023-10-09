package com.example.demo.Service;

import com.example.demo.Model.M_Pessoa;
import com.example.demo.Model.M_Resposta;
import com.example.demo.Repository.R_Pessoa;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class S_Pessoa {

    private static R_Pessoa r_pessoa;

    public S_Pessoa(R_Pessoa r_pessoa) {
        this.r_pessoa = r_pessoa;
    }

    public static M_Pessoa getPessoaLogin(String usuario, String senha) {
        usuario = S_NumberCleaner.cleanerNumber(usuario);
        if (usuario.equals("")) {
            return r_pessoa.findByUsuarioESenha(null, senha);
        } else {
            return r_pessoa.findByUsuarioESenha(Long.valueOf(usuario), senha);
        }
    }

    public static M_Resposta cadastrarPessoa(String nome, String cpf, String email, String telefone, String datanasc, String senha) {
        boolean cadastrovalido = true;
        String mensagemRetorno = "";
        telefone = S_NumberCleaner.cleanerNumber(telefone);
        if (telefone.equals("")) {
            telefone = null;
        }
        if (!S_CpfValidator.validateCPF(cpf)) {
            mensagemRetorno += "CPF inválido.";
            cadastrovalido = false;
        }
        if (nome == null || nome.trim() == "") {
            mensagemRetorno += "Deve ser informado um nome.";
            cadastrovalido = false;
        }
        if ((email == null || email.trim() == "") && telefone == null) {
            mensagemRetorno += "E-mail e/ou telefone precisa ser informado.";
            cadastrovalido = false;
        }
        if (cadastrovalido) {
            M_Pessoa m_pessoa = new M_Pessoa();
            m_pessoa.setNome(nome);
            m_pessoa.setCpf(Long.valueOf(S_NumberCleaner.cleanerNumber(cpf)));
            if (telefone != null) {
                m_pessoa.setTelefone(Long.valueOf(telefone));
            } else {
                m_pessoa.setTelefone(null);
            }
            m_pessoa.setEmail(email);
            m_pessoa.setData_nasc(LocalDate.parse(datanasc));
            m_pessoa.setSenha(senha);
            try {
                r_pessoa.save(m_pessoa);
                mensagemRetorno += "Cadastro realizado com sucesso!";
            } catch (DataIntegrityViolationException e) {
                if (e.getMessage().contains("u_key")) {
                    mensagemRetorno += "O CPF fornecido ja existe.";

                } else {
                    mensagemRetorno += "Erro ao cadastrar.";
                }
                cadastrovalido = false;
            }
        }
        M_Resposta m_resposta = new M_Resposta(cadastrovalido, mensagemRetorno);
        return m_resposta;
    }
}
