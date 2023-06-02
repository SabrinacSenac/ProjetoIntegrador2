/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.sp.senac.e169.adopi.classes;

/**
 *
 * @author Gustavo
 */
public class VendaProduto {
    public int id;
    public int vendaId;
    public int produtoId;
    public int qtd;    

    public VendaProduto() {
    }

    public VendaProduto(int vendaId, int produtoId, int qtd) {
        this.vendaId = vendaId;
        this.produtoId = produtoId;
        this.qtd = qtd;
    } 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendaId() {
        return vendaId;
    }

    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }
    
    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
