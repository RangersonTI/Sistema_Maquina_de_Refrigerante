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
    
    public boolean VerificarEstoque(int _id, int qtd_solicitado){
        if(qtd_solicitado<=0){
            JOptionPane.showMessageDialog(null, "Quantidade solicitada deve ser maior que 0", null, JOptionPane.ERROR_MESSAGE);
        }
        else{
            ProdutosDAL produto_DAL = new ProdutosDAL();
            Produtos produtos = produto_DAL.BuscarProdutoPorID(_id);
            
            if(produtos.QtdEstoque<qtd_solicitado){
                return false;
            }
            else{
                return true;
            }
        }
        return true;
    }
}
