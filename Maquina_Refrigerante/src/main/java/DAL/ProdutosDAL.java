/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import Models.*;
import java.sql.Connection;
import java.util.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rangerson TI
 */
public class ProdutosDAL {

    String caminho = "jdbc:sqlite:banco_de_dados/banco.db";
    Connection conexao;
    
    public void CadastrarProduto(Produtos _produto){

        try{
            conexao = DriverManager.getConnection(caminho);
            String sql = "INSERT INTO Produto(nome,QtdML,QtdEstoque,valor_item) VALUES(?,?,?,?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,_produto.nome);
            statement.setInt(2,_produto.QtdML);
            statement.setInt(3,_produto.QtdEstoque);
            statement.setDouble(4,_produto.valor_item);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Erro ao cadastrar novo produto: ", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutosDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Produtos> BuscarProdutos(){
        List<Produtos> produtosModel = new ArrayList<>();
        Produtos produto;

        try{
            conexao = DriverManager.getConnection(caminho);
            Statement statement = conexao.createStatement();
            ResultSet produtos = statement.executeQuery("SELECT * FROM Produto WHERE QtdEstoque>0");
            
            while(produtos.next()){
                produto = new Produtos();
                produto.id = produtos.getInt("id");
                produto.nome = produtos.getString("nome");
                produto.QtdML = produtos.getInt("QtdML");
                produto.QtdEstoque = produtos.getInt("QtdEstoque");
                produto.valor_item = produtos.getDouble("valor_item");
                produtosModel.add(produto);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Erro ao buscar produto", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutosDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return produtosModel;
        
    }
}
