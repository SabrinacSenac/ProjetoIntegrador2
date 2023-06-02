/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.sp.senac.e169.adopi.classes;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author SABRINA
 */
public class Produto {
    public int id;
    public String nome;
    public Date datafabricacao;
    public String categoria;
    public int quantidade;
    public Float peso;
    public Double preco;

    public Produto() {
    }

    public Produto(String nome, Date datafabricacao, String categoria, int quantidade, Float peso, Double preco) {
        this.nome = nome;
        this.datafabricacao = datafabricacao;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.peso = peso;
        this.preco = preco;
    }

    public Produto(int id, String nome, Date datafabricacao, String categoria, int quantidade, Float peso, Double preco) {
        this.id = id;
        this.nome = nome;
        this.datafabricacao = datafabricacao;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.peso = peso;
        this.preco = preco;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatafabricacao() {
        return datafabricacao;
    }

    public void setDatafabricacao(Date datafabricacao) {
        this.datafabricacao = datafabricacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
