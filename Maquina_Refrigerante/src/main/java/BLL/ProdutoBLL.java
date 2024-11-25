/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

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
                JOptionPane.showMessageDialog(null,"Valor do item deve ser maior que 50C",null, JOptionPane.ERROR_MESSAGE);
            }
            else{
              new ProdutosDAL().CadastrarProduto(_produto);
            }
        }
    }
    
    public List<Produtos> BuscarProdutos(){
        return new ProdutosDAL().BuscarProdutos();
    }
}
