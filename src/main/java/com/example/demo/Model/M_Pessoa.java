package com.example.demo.Model;


import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDate;

import org.springframework.format.number.money.MonetaryAmountFormatter;

@Entity
@Table(name = "pessoa")
public class M_Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Long cpf;
    private LocalDate datanasc;
    private Long telefone;
    private String senha;
    private double dinheiro = 0;

    public double getDinheiro(){
        return dinheiro;
    }

    public void setDinheiro(double dinheiro){
        this.dinheiro = dinheiro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData_nasc() {
        return datanasc;
    }

    public void setData_nasc(LocalDate datanasc) {
        this.datanasc = datanasc;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
