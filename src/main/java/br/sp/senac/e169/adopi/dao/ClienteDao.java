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
public class ClienteDao {
    Cliente objAlterar;
    
    public static boolean salvar(Cliente pObj){
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/padoca?serverTimezone=UTC";
            conexao = DriverManager.getConnection(url, "root", "123456789");
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
                conexao.prepareStatement("INSERT INTO Cliente (nome,cpf,telefone,data_nascimento,email,estado_civil,sexo,cep,rua,numero,bairro,cidade,uf) "
                                        + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            comandoSQL.setString(1, pObj.getNome());
            comandoSQL.setString(2, pObj.getCpf());
            comandoSQL.setString(3, pObj.getTelefone());
            comandoSQL.setDate(4, new java.sql.Date(pObj.getDataNascimento().getTime()));
            comandoSQL.setString(5, pObj.getEmail());
            comandoSQL.setString(6, pObj.getEstadoCivil());
            comandoSQL.setString(7, pObj.getSexo());
            comandoSQL.setString(8, pObj.getCep());
            comandoSQL.setString(9, pObj.getRua());
            comandoSQL.setInt(10, pObj.getNumero());
            comandoSQL.setString(11, pObj.getBairro());
            comandoSQL.setString(12, pObj.getCidade());
            comandoSQL.setString(13, pObj.getUf());
            
                    
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
    
    public static ArrayList<Cliente> listar(){
        ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/padoca";
            conexao = DriverManager.getConnection(url, "root", "123456789");
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
                conexao.prepareStatement("SELECT * FROM Cliente");
            
            //Passo 4 - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                 
                    //Passo os dados do resultset para o objeto
                    Cliente obj = new Cliente();
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setTelefone(rs.getString("telefone"));
                    obj.setDataNascimento(rs.getDate("data_nascimento"));
                    obj.setEmail(rs.getString("email"));
                    obj.setEstadoCivil(rs.getString("estado_civil"));
                    obj.setSexo(rs.getString("sexo"));
                    obj.setCep(rs.getString("cep"));
                    obj.setRua(rs.getString("rua"));
                    obj.setNumero(rs.getInt("numero"));
                    obj.setBairro(rs.getString("bairro"));
                    obj.setCidade(rs.getString("cidade"));
                    obj.setUf(rs.getString("uf"));
                    
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
    
    public static ArrayList<Cliente> listarPorCPF(String cpf) {
        ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
        
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/padoca";
            conexao = DriverManager.getConnection(url, "root", "123456789");
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
                conexao.prepareStatement("SELECT * FROM Cliente Where cpf=?");
            
            comandoSQL.setString(1, cpf);
            
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                 
                    //Passo os dados do resultset para o objeto
                    Cliente obj = new Cliente();
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setTelefone(rs.getString("telefone"));
                    obj.setDataNascimento(rs.getDate("data_nascimento"));
                    obj.setEmail(rs.getString("email"));
                    obj.setEstadoCivil(rs.getString("estado_civil"));
                    obj.setSexo(rs.getString("sexo"));
                    obj.setCep(rs.getString("cep"));
                    obj.setRua(rs.getString("rua"));
                    obj.setNumero(rs.getInt("numero"));
                    obj.setBairro(rs.getString("bairro"));
                    obj.setCidade(rs.getString("cidade"));
                    obj.setUf(rs.getString("uf"));
                    
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
    }
    
    public static boolean alterar(Cliente pObj){
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
                conexao.prepareStatement("UPDATE Cliente SET nome=?, cpf=?, telefone=?, data_nascimento=?, email=?, estado_civil=?, sexo=?, cep=?, rua=?, numero=?, bairro=?, cidade=?, uf=? WHERE id=? ");
            
            comandoSQL.setString(1, pObj.getNome());
            comandoSQL.setString(2, pObj.getCpf());
            comandoSQL.setString(3, pObj.getTelefone());
            comandoSQL.setDate(4, new java.sql.Date(pObj.getDataNascimento().getTime()));
            comandoSQL.setString(5, pObj.getEmail());
            comandoSQL.setString(6, pObj.getEstadoCivil());
            comandoSQL.setString(7, pObj.getSexo());
            comandoSQL.setString(8, pObj.getCep());
            comandoSQL.setString(9, pObj.getRua());
            comandoSQL.setInt(10, pObj.getNumero());
            comandoSQL.setString(11, pObj.getBairro());
            comandoSQL.setString(12, pObj.getCidade());
            comandoSQL.setString(13, pObj.getUf());
            
            
                    
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
