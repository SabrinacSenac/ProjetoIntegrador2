/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.sp.senac.e169.adopi.dao;

import br.sp.senac.e169.adopi.classes.VendaProduto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class VendaProdutoDao {
    public static void salvar(VendaProduto obj) {
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/padoca?serverTimezone=UTC";
            conexao = DriverManager.getConnection(url, "root", "123456789");
            
            PreparedStatement comandoSQL = 
                    conexao.prepareStatement("Insert Into vendas_produto (venda_id,produto_id,qtd) "
                                            + " Values (?,?,?)");
            
            comandoSQL.setInt(1, obj.getVendaId());
            comandoSQL.setInt(2, obj.getProdutoId());
            comandoSQL.setInt(3, obj.getQtd());
            
            comandoSQL.executeUpdate();
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
