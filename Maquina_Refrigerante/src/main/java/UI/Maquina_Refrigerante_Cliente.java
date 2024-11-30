/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import Models.*;
import BLL.*;
import DAL.*;
import java.io.IOException;
import java.util.Arrays;
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
                double[] valores_permitidos = {10.00,5.00,2.00,1.00,0.50};
                double valor_a_pagar=0.0;

                if(!new EstoqueBLL().VerificarEstoque(id_prod,1)){
                    JOptionPane.showMessageDialog(null, "Quantidade solicitada maior que volume do estoque.", null, JOptionPane.ERROR_MESSAGE);
                    Cliente();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Valor Total: "+(produto.valor_item),"Informativo",JOptionPane.INFORMATION_MESSAGE);

                    while(valor_a_pagar<produto.valor_item){
                        System.out.print("Valor a pagar: ");
                        double valor_parcial = ler.nextDouble();
                        if(!Arrays.stream(valores_permitidos).anyMatch((double v) -> v == valor_parcial)){
                            JOptionPane.showMessageDialog(null, "A maquina aceita apenas valores de: 10,5,2 reias ou moedas de 1 ou 0.50C", null, JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            valor_a_pagar = valor_a_pagar+valor_parcial;
                        }
                    }

                    VendaBLL vendaBLL = new VendaBLL();
                    vendaBLL.RealizarVenda(id_prod,produto,1,valor_a_pagar);
                }
            }
            Cliente();
        }
    }
}