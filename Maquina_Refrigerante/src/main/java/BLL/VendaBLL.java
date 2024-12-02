/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DAL.*;
import Models.*;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Rangerson TI
 */
public class VendaBLL {
    
    public void RealizarVenda(int _id, Produtos _produto, int qtd_solicitar, double valor_a_pagar){

        double total_a_pagar = (_produto.valor_item * qtd_solicitar);

        if(valor_a_pagar<total_a_pagar){
            JOptionPane.showMessageDialog(null,"Valor a pagar menor que valor da compra. (Total da compra: R$"+total_a_pagar+"\nOperação cancelada",null, JOptionPane.ERROR_MESSAGE);
        }
        else{
            new VendaDAL().RealizarVenda(_id,_produto,qtd_solicitar,valor_a_pagar);
            //JOptionPane.showMessageDialog(null, "Seu troco: "+(valor_a_pagar-total_a_pagar),"Informativo",JOptionPane.INFORMATION_MESSAGE);
            new NotasTrocoBLL().VerificarTroco(valor_a_pagar-total_a_pagar);
        }
    }

    public List<Venda> RelatorioVendas(String data_inicial, String data_final){
        return new VendaDAL().RelatorioVendas(data_inicial, data_final);
    }
}
