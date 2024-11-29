/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.EstoqueDAL;
import DAL.ProdutosDAL;
import Models.Produtos;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rangerson TI
 */
public class ProdutoBLL {
    public void CadastrarProduto(Produtos _produto){

        if(_produto.nome.length()<2){
            JOptionPane.showMessageDialog(null,"Nome deve conter mais de 1 caractere",null, JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(_produto.valor_item<0.50){
                JOptionPane.showMessageDialog(null,"Preço do produto deve ser maior que 50C",null, JOptionPane.ERROR_MESSAGE);
            }
            else{
              new ProdutosDAL().CadastrarProduto(_produto);
            }
        }
    }
    
    public void EditarPrecoProduto(int _id, double _novo_valor){

        if(_novo_valor<0.50){
            JOptionPane.showMessageDialog(null, "Preço do produto deve ser maior que 50C", null, JOptionPane.ERROR_MESSAGE);
        }
        else{
            new ProdutosDAL().EditarPrecoProduto(_id,_novo_valor);
        }
    }
    
    public List<Produtos> BuscarTodosProdutos(){
        return new ProdutosDAL().BuscarTodosProdutos();
    }
    
  
    public List<Produtos> BuscarProdutos(){
        return new ProdutosDAL().BuscarProdutos();
    }
}
