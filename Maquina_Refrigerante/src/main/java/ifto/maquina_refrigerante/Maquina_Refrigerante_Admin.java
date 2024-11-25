/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifto.maquina_refrigerante;
import java.util.Scanner;
import javax.swing.JOptionPane;
import Models.*;
import BLL.*;
import java.io.IOException;

/**
 *
 * @author Rangerson TI
 */
public class Maquina_Refrigerante_Admin {
    public void TelaAdministrador() throws IOException{
        Scanner ler = new Scanner(System.in);
        Produtos _produto = new Produtos();
        NotasTroco _troco = new NotasTroco();

        System.out.println("************ BEM-VINDO A MAQUINA DE REFRIGERANTES DO LUIS :) ************(modo administrador)");
        System.out.print("\n SELECIONE UMA OPÇÃO:\n\n");
        System.out.println("1 - Adicionar Novo Refrigerante");
        System.out.println("2 - Adicionar Troco ao Caixa");
        System.out.println("3 - Editar Preço do Refrigerante");
        System.out.println("4 - Entrada de Estoque");
        System.out.println("5 - Relatório de Vendas");
        System.out.println("6 - Sair!\n");

        String opc = ler.next();

        switch(opc){
            case "1":
                System.out.println("\n************ CADASTRO DE REFRIGERANTES ************\n");
                
                System.out.print("Nome: ");
                _produto.nome = ler.next();

                System.out.print("Preço: ");
                _produto.valor_item = ler.nextDouble();

                System.out.print("Capacidade (em ML): ");
                _produto.QtdML = ler.nextInt();

                System.out.print("Estoque Inicial: ");
                _produto.QtdEstoque = ler.nextInt();

                new ProdutoBLL().CadastrarProduto(_produto);
                TelaAdministrador();
                
            case "2":
                System.out.println("\n************ ENTRADA DE TROCO ************\n");
                
                System.out.print("Notas de 10: (qtd)");
                _troco.qtd_cedula_dez = ler.nextInt();

                System.out.print("Notas de 5: (qtd)");
                _troco.qtd_cedula_cinco = ler.nextInt();
                
                System.out.print("Notas de 2: (qtd)");
                _troco.qtd_cedula_dois = ler.nextInt();
                
                System.out.print("Moedas de 1: (qtd)");
                _troco.qtd_moeda_um = ler.nextInt();
                
                System.out.print("Moedas de 50C: (qtd)");
                _troco.qtd_moeda_cinqueta_cents = ler.nextInt();

                new NotasTrocoBLL().EntradaDeTroco(_troco);
                TelaAdministrador();
                
            case "3":
                TelaAdministrador();
                
            case "4":
                TelaAdministrador();
                
            case "5":
                TelaAdministrador();
                
            case "6":
                new Maquina_Refrigerante_Cliente().Cliente();
                
            default:
                JOptionPane.showMessageDialog(null, "Opção Inválida", null, JOptionPane.ERROR_MESSAGE);
        }
    }
}
