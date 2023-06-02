/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.sp.senac.e169.adopi.dao;
import br.sp.senac.e169.adopi.classes.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class VendasDao {
    
    
    public static boolean salvar(Vendas pObj){
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/padoca";
            conexao = DriverManager.getConnection(url, "root", "123456789");
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
                conexao.prepareStatement("INSERT INTO vendas (data_venda,total,cliente_id) "
                                        + " VALUES(?,?,?)");
            comandoSQL.setDate(1, new java.sql.Date(pObj.getDataVenda().getTime()));
            comandoSQL.setDouble(2, pObj.getTotal());
            comandoSQL.setInt(3, pObj.getClienteId());
                    
            //Passo 4 - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return retorno;
    }//Fim do método salvar
    
    public static ArrayList<Vendas> listar(){
        ArrayList<Vendas> listaRetorno = new ArrayList<Vendas>();
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/padoca";
            conexao = DriverManager.getConnection(url, "root", "123456789");
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
                conexao.prepareStatement("SELECT * FROM Vendas");
            
            //Passo 4 - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                 
                    //Passo os dados do resultset para o objeto
                    Vendas obj = new Vendas();
                    obj.setDataVenda(rs.getDate("data_venda"));
                    obj.setTotal(rs.getDouble("total"));
                    obj.setClienteId(rs.getInt("cliente_id"));
                    
                    //Passo o objeto para a lista de retorno
                    listaRetorno.add(obj);
                    
                }
            
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro no SQL");
        }
        
        return listaRetorno;
        
    }//Fim do listar
    
    public static boolean alterar(Vendas pObj){
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/padoca";
            conexao = DriverManager.getConnection(url, "root", "123456789");
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
                conexao.prepareStatement("UPDATE Vendas SET data_venda=?, total=?, clienteId=? WHERE id=? ");
            
            comandoSQL.setDate(1, new java.sql.Date(pObj.getDataVenda().getTime()));
            comandoSQL.setDouble(2, pObj.getTotal());
            comandoSQL.setInt(3, pObj.getClienteId());
            
            
                    
            //Passo 4 - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro no SQL");
        }
        
        return retorno;
    }
}

