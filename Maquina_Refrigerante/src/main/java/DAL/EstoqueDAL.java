/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.NotasTroco;
import Models.Produtos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rangerson TI
 */
public class EstoqueDAL {
    
    String caminho = "jdbc:sqlite:banco_de_dados/banco.db";
    Connection conexao;
    
    public void EntradaDeEstoque(int _id, int _est_total){
        
        try{
            conexao = DriverManager.getConnection(caminho);
            String sql = "UPDATE Produto SET QtdEstoque=? WHERE id=?;";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,_est_total);
            statement.setInt(2,_id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tabela de troco atualizada com sucesso","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar estoque: "+ex,"SQL Error" , JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutosDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
