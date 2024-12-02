/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import Models.*;
import DAL.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rangerson TI
 */
public class NotasTrocoBLL {
    
    public void EntradaDeTroco(NotasTroco _troco,NotasTroco _trocoAnterior){
        if(_troco.qtd_cedula_dez<0 || _troco.qtd_cedula_cinco<0 || _troco.qtd_cedula_dois<0 || _troco.qtd_moeda_um<0 || _troco.qtd_moeda_cinquenta_cents<0){
            JOptionPane.showMessageDialog(null,"Os campos JAMAIS devem ter valores negativos.\nCaso não haja entrada de determinada nota, informe '0'.",null, JOptionPane.ERROR_MESSAGE);
        }
        else{
            _troco.qtd_cedula_dez = _troco.qtd_cedula_dez + _trocoAnterior.qtd_cedula_dez;
            _troco.qtd_cedula_cinco = _troco.qtd_cedula_cinco + _trocoAnterior.qtd_cedula_cinco;
            _troco.qtd_cedula_dois = _troco.qtd_cedula_dois + _trocoAnterior.qtd_cedula_dois;
            _troco.qtd_moeda_um = _troco.qtd_moeda_um + _trocoAnterior.qtd_moeda_um;
            _troco.qtd_moeda_cinquenta_cents = _troco.qtd_moeda_cinquenta_cents + _trocoAnterior.qtd_moeda_cinquenta_cents;
            
            new NotasTrocoDAL().EntradaDeTroco(_troco);
        }
    }

    public NotasTroco BuscarNotasTroco(){
        return new NotasTrocoDAL().BuscarNotasTroco();
    }
    
    public void VerificarTroco(double _troco){

        // Validar se o troco é maior que 0
        if (_troco <= 0) {
            
        }
        else{

            NotasTroco notasTroco = new NotasTrocoDAL().BuscarNotasTroco();
            
            int notas10 = notasTroco.qtd_cedula_dez;
            int notas5 = notasTroco.qtd_cedula_cinco;
            int notas2 = notasTroco.qtd_cedula_dois;
            int moedas1 = notasTroco.qtd_moeda_um;
            int moedas50 = notasTroco.qtd_moeda_cinquenta_cents;
            
            // Variáveis para mostrar o troco no JOptionPane
            int troco_notas10 =0;
            int troco_notas5 =0;
            int troco_notas2 =0;
            int troco_moeda1 =0;
            int troco_moeda50C =0;
            
            
            // Valores das notas em centavos
            int[] valores = {1000, 500, 200, 100, 50};
            int[] quantidadesDisponiveis = {notas10, notas5, notas2, moedas1, moedas50};
            int[] quantidadeUsada = new int[valores.length];
            int[] valores_troco_qtd = new int[5];

            int trocoCentavos = (int) Math.round(_troco * 100); // Troco em centavos
            
            for (int i = 0; i < valores.length; i++) {
                while (trocoCentavos >= valores[i] && quantidadesDisponiveis[i] > 0) {
                    quantidadeUsada[i]++;
                    quantidadesDisponiveis[i]--;
                    trocoCentavos -= valores[i];
                }
            }

            // Verificar se sobrou troco
            if (trocoCentavos > 0) {
                JOptionPane.showMessageDialog(null,"Não há notas ou moedas suficientes para o troco. Compra cancelada.",null, JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println("Notas e moedas utilizadas para o troco:");
                for (int i = 0; i < valores.length; i++) {
                    if (quantidadeUsada[i] > 0) {
                        if (valores[i] >= 100) {
                            valores_troco_qtd[i] = quantidadeUsada[i];
                        } else {
                            valores_troco_qtd[i] = quantidadeUsada[i];
                        }
                        
                    }
                }
            }
                
                // Passa para as variáveis de troco, a quatidade certa para cada
                
                troco_notas10 = valores_troco_qtd[0];
                troco_notas5 = valores_troco_qtd[1];
                troco_notas2 = valores_troco_qtd[2];
                troco_moeda1 = valores_troco_qtd[3];
                troco_moeda50C = valores_troco_qtd[4];
                JOptionPane.showMessageDialog(null, "Troco do cliente: "+_troco+"\n\nNotas de 10: "
                        + "                                     "+troco_notas10+"\nNotas de 5:"+troco_notas5+"\n"
                                                                + "Notas de 2: "+troco_notas2+"\nMoedas de 1: "+troco_moeda1+"\n"
                                                                 + "Moedas de 50c: "+troco_moeda50C+"\n","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

