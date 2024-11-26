/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import Models.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.List;
import java.util.ArrayList;
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
            String sql = "UPDATE Qtd_Cedula_moeda_troco SET qtd_cedula_dez=?, qtd_cedula_cinco=?,"
                        + "qtd_cedula_dois=?, qtd_moeda_um=?, qtd_moeda_cinquenta_cents=? WHERE id=1;";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,_troco.qtd_cedula_dez);
            statement.setInt(2,_troco.qtd_cedula_cinco);
            statement.setInt(3,_troco.qtd_cedula_dois);
            statement.setInt(4,_troco.qtd_moeda_um);
            statement.setInt(5,_troco.qtd_moeda_cinquenta_cents);
            statement.executeUpdate();

            System.out.println(_troco.qtd_cedula_dez);
            System.out.println(_troco.qtd_cedula_cinco);
            System.out.println(_troco.qtd_cedula_dois);
            System.out.println(_troco.qtd_moeda_um);
            System.out.println(_troco.qtd_moeda_cinquenta_cents);
            JOptionPane.showMessageDialog(null, "Tabela de troco atualizada com sucesso","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Erro ao atualizar quantidade de cedulas/moedas: ", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutosDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public NotasTroco BuscarNotasTroco(){
        NotasTroco notaTroco = new NotasTroco();

        try{
            conexao = DriverManager.getConnection(caminho);
            Statement statement = conexao.createStatement();
            ResultSet troco = statement.executeQuery("SELECT * FROM Qtd_Cedula_moeda_troco WHERE id=1");
        
            while(troco.next()){
                notaTroco.qtd_cedula_dez = troco.getInt("qtd_cedula_dez");
                notaTroco.qtd_cedula_cinco = troco.getInt("qtd_cedula_cinco");
                notaTroco.qtd_cedula_dois = troco.getInt("qtd_cedula_dois");notaTroco.qtd_cedula_dois = troco.getInt("qtd_cedula_dois");
                notaTroco.qtd_moeda_um = troco.getInt("qtd_moeda_um");
                notaTroco.qtd_moeda_cinquenta_cents = troco.getInt("qtd_moeda_cinquenta_cents");
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
        return notaTroco;
    }
}
