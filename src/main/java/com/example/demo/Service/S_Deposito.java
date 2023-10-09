package com.example.demo.Service;

import com.example.demo.Model.M_Pessoa;
import com.example.demo.Model.M_Resposta;
import com.example.demo.Repository.R_Pessoa;
import com.example.demo.Repository.R_deposito;
import org.springframework.stereotype.Service;


@Service
public class S_Deposito {
    private static R_deposito r_deposito;
    private static R_Pessoa r_pessoa;

    public S_Deposito(R_deposito r_deposito, R_Pessoa r_pessoa) {
        this.r_deposito = r_deposito;
        this.r_pessoa = r_pessoa;
    }

    public static M_Resposta deposito(Long valorDeposito, String cpf, String senha) {
        boolean depositoValido = true;
        String mensagemRetorno = "";
        S_NumberCleaner.cleanerNumber(String.valueOf(cpf));
        if (valorDeposito == null) {
            mensagemRetorno += "Deve ser informado um valor para o deposito";
            depositoValido = false;
        }
        if(!S_CpfValidator.validateCPF(String.valueOf(cpf))){
            mensagemRetorno += "CPF Invalido";
            depositoValido = false;
        }
        if (depositoValido) {
            M_Pessoa m_pessoa = S_Pessoa.getPessoaLogin(String.valueOf(cpf),senha);
            valorDeposito = (long) (valorDeposito + m_pessoa.getDinheiro());
            m_pessoa.setDinheiro(valorDeposito);
            r_pessoa.save(m_pessoa);
            mensagemRetorno += "Deu bom, agr vc tem dinheiro deixou de ser pobre!";
        }
        M_Resposta m_resposta = new M_Resposta(depositoValido,mensagemRetorno);
        return m_resposta;
    }
}
