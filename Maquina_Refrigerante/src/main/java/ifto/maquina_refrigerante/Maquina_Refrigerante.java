/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ifto.maquina_refrigerante;
import ifto.maquina_refri_manutencao.*;
import java.util.List;
import Models.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Rangerson TI
 */
public class Maquina_Refrigerante {

    public static void main(String[] args) {
        System.out.println("************ BEM-VINDO A MAQUINA DE REFRIGERANTES DO LUIS :) ************");
        System.out.print("\n ESCOLHA UM ITEM (pelo ID):");
        
        List<Produtos> listaProdutos = new SysManutencao().BuscarProdutos();

        if(listaProdutos.isEmpty()){
            JOptionPane.showConfirmDialog(null,"Nenhum produto disponível",null,JOptionPane.PLAIN_MESSAGE);
        }
        else{
            for(Produtos produtos: listaProdutos){
                System.out.println(""+produtos.id+" - "+produtos.nome);
            }
        }
    }
}