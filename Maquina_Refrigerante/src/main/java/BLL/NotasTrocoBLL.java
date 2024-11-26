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
}
