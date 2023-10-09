package com.example.demo.Service;

import com.example.demo.Model.M_Pessoa;
import com.example.demo.Model.M_Resposta;
import com.example.demo.Repository.R_Pessoa;
import com.example.demo.Repository.R_transacao;
import org.springframework.stereotype.Service;

@Service
public class S_Transacao {
    public static R_transacao r_transacao;
    public static M_Pessoa m_pessoa;
    public S_Transacao(R_transacao r_transacao) {
        this.r_transacao = r_transacao;
        this.m_pessoa = m_pessoa;
    }

    public static M_Resposta trasacao(Long valorTransacao, String cpf, String senha){
        boolean transacaoValida = true;
        String mensagemRetorno = "";
        S_NumberCleaner.cleanerNumber(String.valueOf(cpf));
        if(valorTransacao == null){
            transacaoValida = false;
            mensagemRetorno += "Você não pode fazer uma trnsação nula";
        }
        if(transacaoValida){
            M_Pessoa m_pessoa = S_Pessoa.getPessoaLogin(String.valueOf(cpf), senha);
            Long result = (long) (m_pessoa.getDinheiro() - valorTransacao);
            m_pessoa.setDinheiro(result);
            r_transacao.save(m_pessoa);
        }
        M_Resposta m_resposta = new M_Resposta(transacaoValida, mensagemRetorno);
        return m_resposta;
    }
}
