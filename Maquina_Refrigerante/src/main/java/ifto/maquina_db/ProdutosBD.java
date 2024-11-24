/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifto.maquina_db;
import Models.*;
import java.util.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rangerson TI
 */
public class ProdutosBD {

    public void CadastrarProduto(Produtos _produto){
        Conexao connect = new Conexao();

        try{
            connect.Conectar();
            //Statement statement = connect.createStatement();
            //statement.setQueryTimeout(15);
            String sql = "INSERT INTO Produto(nome,QtdML,QtdEstoque) VALUES(?,?,?)";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1,_produto.nome);
            statement.setInt(2,_produto.QtdML);
            statement.setInt(1,_produto.QtdEstoque);
            statement.executeUpdate();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Erro ao buscar produto", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso","Informativo",JOptionPane.INFORMATION_MESSAGE);
            connect.Desconectar();
        }
    }

    public List<Produtos> BuscarProdutos(){
        Conexao connect = new Conexao();
        List<Produtos> produtosModel = new ArrayList<>();
        Produtos produto;

        try{
            connect.Conectar();
            Statement statement = connect.createStatement();
            ResultSet produtos = statement.executeQuery("SELECT * FROM Produto WHERE QtdEstoque>0");

            while(produtos.next()){
                produto = new Produtos();


                produto.id = produtos.getInt("id");
                produto.nome = produtos.getString("nome");
                produto.QtdML = produtos.getInt("QtdML");
                produto.QtdEstoque = produtos.getInt("QtdEstoque");
                produtosModel.add(produto);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Erro ao buscar produto", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            connect.Desconectar();
            return produtosModel;
        }
        
    }
}
