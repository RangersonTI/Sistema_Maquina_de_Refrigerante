/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author Rangerson TI
 */
public class VendaDAL {
    
    String caminho = "jdbc:sqlite:banco_de_dados/banco.db";
    Connection conexao;    
    
    public void RealizarVenda(int _id, Produtos _produto, int qtd_solicitado, double valor_a_pagar){
        try{
            Date dataHoraAtual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String data_atual = formato.format(dataHoraAtual);
            
            conexao = DriverManager.getConnection(caminho);
            String sql = "INSERT INTO Venda(cod_produto,qtd_produto,valor_unitario,valor_total,data_venda) VALUES(?,?,?,?,?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,_produto.id);
            statement.setInt(2,qtd_solicitado);
            statement.setDouble(3,_produto.valor_item);
            statement.setDouble(3,valor_a_pagar);
            statement.setString(4,data_atual);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Erro ao efetuar venda: "+ex, JOptionPane.ERROR_MESSAGE);
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
