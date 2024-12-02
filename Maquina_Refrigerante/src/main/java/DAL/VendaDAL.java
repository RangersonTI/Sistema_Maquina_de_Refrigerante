/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.NotasTrocoBLL;
import Models.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangerson TI
 */
public class VendaDAL {

    String caminho = "jdbc:sqlite:banco_de_dados/banco.db";
    Connection conexao;

    public void RealizarVenda(int _id, Produtos _produto, int qtd_solicitado, double valor_a_pagar){
        try{
            LocalDateTime data_atual_obj = LocalDateTime.now();
            DateTimeFormatter formato_datahora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String datahora_atual = data_atual_obj.format(formato_datahora);
            double valor_compra = qtd_solicitado*_produto.valor_item;
            conexao = DriverManager.getConnection(caminho);
            
            if(new NotasTrocoBLL().VerificarTroco(valor_a_pagar-valor_compra)){
                String sql = "INSERT INTO Vendas(cod_produto,qtd_produto,valor_unitario,valor_compra,valor_pago,valor_troco,data_venda) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement statement = conexao.prepareStatement(sql);
                statement.setInt(1,_produto.id);
                statement.setInt(2,qtd_solicitado);
                statement.setDouble(3,_produto.valor_item);
                statement.setDouble(4, valor_compra);
                statement.setDouble(5,valor_a_pagar);
                statement.setDouble(6,(valor_a_pagar-valor_compra));
                statement.setString(7,datahora_atual);
                statement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Venda realizada com sucesso","Informativo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao efetuar venda: "+ex, null, JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutosDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Venda> RelatorioVendas(String data_inicial, String data_final){
        List<Venda> vendas_list = new ArrayList<>();
        Venda venda;

        try{
            conexao = DriverManager.getConnection(caminho);
            String sql = "SELECT * FROM Vendas WHERE data_venda BETWEEN ? and ?;";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,data_inicial+" 00:00");
            statement.setString(2,data_final+" 23:59");
            ResultSet vendas = statement.executeQuery();

            while(vendas.next()){
                venda = new Venda();
                venda.id = vendas.getInt("id");
                venda.cod_produto = vendas.getInt("cod_produto");
                venda.qtd_produto = vendas.getInt("qtd_produto");
                venda.valor_unitario = vendas.getFloat("valor_unitario");
                venda.valor_compra = vendas.getFloat("valor_compra");
                venda.valor_pago = vendas.getFloat("valor_pago");
                venda.valor_troco = vendas.getFloat("valor_troco");
                venda.data_venda = vendas.getString("data_venda");
                vendas_list.add(venda);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Erro ao buscar dados paa relatório.", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutosDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return vendas_list;
    }
}