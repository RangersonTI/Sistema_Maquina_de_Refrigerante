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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rangerson TI
 */
public class NotasTrocoDAL {

    String caminho = "jdbc:sqlite:banco_de_dados/banco.db";
    Connection conexao;

    public void EntradaDeTroco(NotasTroco _troco){

        try{
            conexao = DriverManager.getConnection(caminho);
            String sql = "UPDATE Qtd_Cedula_moeda_troco set qtd_cedula_dez=? ,qtd_cedula_cinco=?,"
                        + "qtd_cedula_dois=?, qtd_moeda_um=?, qtd_moeda_um=?) where id=1";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,_troco.qtd_cedula_dez);
            statement.setInt(2,_troco.qtd_cedula_cinco);
            statement.setInt(3,_troco.qtd_cedula_dois);
            statement.setInt(4,_troco.qtd_moeda_um);
            statement.setInt(5,_troco.qtd_moeda_cinqueta_cents);
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
}
