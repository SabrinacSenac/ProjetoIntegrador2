
import br.sp.senac.e169.adopi.classes.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gustavo
 */
public class VendaProdutoDAO {
    public static boolean salvar(VendaProduto pObj){
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
                conexao.prepareStatement("INSERT INTO Produto (data_venda,total,cliente_id) "
                                        + " VALUES(?,?,?)");
            
            comandoSQL.setDouble(1, pObj.getVendaId());
            comandoSQL.setInt(2, pObj.getProdutoId());
                    
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
    
    public static ArrayList<VendaProduto> listar(){
        ArrayList<VendaProduto> listaRetorno = new ArrayList<VendaProduto>();
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3307/padoca";
            conexao = DriverManager.getConnection(url, "root", "123456789");
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
                conexao.prepareStatement("SELECT * FROM Vendas");
            
            //Passo 4 - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                 
                    //Passo os dados do resultset para o objeto
                    VendaProduto obj = new VendaProduto();
                    obj.setId(rs.getInt("id"));
                    obj.setProdutoId(rs.getInt("produto_id"));
                    obj.setVendaId(rs.getInt("venda_id"));
                    
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
    
    // Nesse caso, não precisa do alterar.
    
    /*public static boolean alterar(VendaProdutoDao pObj){
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
                conexao.prepareStatement("UPDATE Vendas SET data_venda=?, total=?, clienteId=? WHERE id=? ");
            
            comandoSQL.setDouble(1, pObj.getVendaId());
            comandoSQL.setInt(2, pObj.getProdutoId());
            
            
                    
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
    }*/
}
