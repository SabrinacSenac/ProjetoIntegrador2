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
public class ProdutoDao {
    Produto objAlterar;
    
    public static boolean salvar(Produto pObj){
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3307/padoca";
            conexao = DriverManager.getConnection(url, "root", "123456789");
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
                conexao.prepareStatement("INSERT INTO Produto (nome,data_fabricacao,categoria,qtd,peso,preco) "
                                        + " VALUES(?,?,?,?,?,?)");
            comandoSQL.setString(1, pObj.getNome());
            comandoSQL.setDate(2, (Date) pObj.getDatafabricacao());
            comandoSQL.setString(3, pObj.getCategoria());
            comandoSQL.setInt(4, pObj.getQuantidade());
            comandoSQL.setFloat(5, pObj.getPeso());
            comandoSQL.setDouble(6, pObj.getPreco());
         
                    
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
    }//Fim do método salvar
    
    public static ArrayList<Produto> listar(){
        ArrayList<Produto> listaRetorno = new ArrayList<Produto>();
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3307/padoca";
            conexao = DriverManager.getConnection(url, "root", "123456789");
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
                conexao.prepareStatement("SELECT * FROM Produto");
            
            //Passo 4 - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                 
                    //Passo os dados do resultset para o objeto
                    Produto obj = new Produto();
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setDatafabricacao(rs.getDate("data_fabricacao"));
                    obj.setCategoria(rs.getString("categoria"));
                    obj.setQuantidade(rs.getInt("quantidade"));
                    obj.setPeso(rs.getFloat("peso"));
                    obj.setPreco(rs.getDouble("preco"));
                    
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
    
    public static boolean alterar(Produto pObj){
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3307/padoca";
            conexao = DriverManager.getConnection(url, "root", "123456789");
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
                conexao.prepareStatement("UPDATE Cliente SET nome=?, data_fabricacao=?, categoria=?, quantidade=?, peso=?, preco=? WHERE id=? ");
            
            comandoSQL.setString(1, pObj.getNome());
            comandoSQL.setDate(2, (Date) pObj.getDatafabricacao());
            comandoSQL.setString(3, pObj.getCategoria());
            comandoSQL.setInt(4, pObj.getQuantidade());
            comandoSQL.setFloat(5, pObj.getPeso());
            comandoSQL.setDouble(6, pObj.getPreco());
            
            
                    
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
