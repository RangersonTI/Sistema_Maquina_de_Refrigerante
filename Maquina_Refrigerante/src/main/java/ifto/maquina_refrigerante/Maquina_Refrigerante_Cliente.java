/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifto.maquina_refrigerante;

import Models.*;
import BLL.*;
import DAL.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Rangerson TI
 */
public class Maquina_Refrigerante_Cliente {
    public void Cliente() throws IOException{
        Scanner ler = new Scanner(System.in);

        new DAL.CriarBancoDeDados().CriarBancoDeDados();
        System.out.println("************ BEM-VINDO A MAQUINA DE REFRIGERANTES DO LUIS :) ************");
        System.out.print("\n ESCOLHA UM ITEM (pelo ID):\n\n");

        List<Produtos> listaProdutos = new ProdutoBLL().BuscarProdutos();

        if(listaProdutos.isEmpty()){
            JOptionPane.showConfirmDialog(null,"Nenhum produto disponível",null,JOptionPane.PLAIN_MESSAGE);
        }
        else{
            for(Produtos produtos: listaProdutos){
                System.out.println(""+produtos.id+" - "+produtos.nome+"(R$"+produtos.valor_item+") - (Disp.:"+produtos.QtdEstoque+")");
            }
            System.out.print("\n\n");
        }
        String leitura = ler.next();

        if ("admin".equals(leitura)){
            Maquina_Refrigerante_Admin maq_adm = new Maquina_Refrigerante_Admin();
            maq_adm.TelaAdministrador();
        }
        else{
            int id_prod=0;
            
            try{
                id_prod = Integer.parseInt(leitura);
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "A opção informada não é um número.\nPor favor informe um número conforme as opções.", null, JOptionPane.ERROR_MESSAGE);
            }
            ProdutosDAL produto_DAL = new ProdutosDAL();
            Produtos produto = produto_DAL.BuscarProdutoPorID(id_prod);

            if(produto.nome==null){
                JOptionPane.showMessageDialog(null, "Produto informado é inválido.\nPor favor, tente novamente", null, JOptionPane.ERROR_MESSAGE);
                Cliente();
            }
            else{
                System.out.print("\nQtd a solicitar: ");
                int qtd_solicitar = ler.nextInt();

                EstoqueBLL ha_estoque = new EstoqueBLL();
                
                if(!ha_estoque.VerificarEstoque(id_prod,qtd_solicitar)){
                    JOptionPane.showMessageDialog(null, "Quantidade solicitada maior que volume do estoque.", null, JOptionPane.ERROR_MESSAGE);
                    Cliente();
                }
                else{
                    System.out.print("\nValor a pagar: ");
                    double valor_a_pagar = ler.nextDouble();
                    
                    VendaBLL vendaBLL = new VendaBLL();
                    vendaBLL.RealizarVenda(id_prod,produto,qtd_solicitar,valor_a_pagar);
                    
                }
            }
            Cliente();
        }
    }
}