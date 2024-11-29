/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DAL.*;
import Models.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rangerson TI
 */
public class EstoqueBLL {
    public void EntradaDeEstoque(int _id, int QtdEstoqueEntrada){
        ProdutosDAL produtoDAL = new ProdutosDAL();
        Produtos produto = produtoDAL.BuscarProdutoPorID(_id);
        
        if(QtdEstoqueEntrada<0){
            JOptionPane.showMessageDialog(null, "Entrada de estoque não pode ser negativa.", null, JOptionPane.ERROR_MESSAGE);
        }
        else{
            int est_total = produto.QtdEstoque+QtdEstoqueEntrada;
            new EstoqueDAL().EntradaDeEstoque(_id,est_total);
        }
    }

    public void SaidaDeEstoque(){
        
    }
}
