/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.List;

/**
 *
 * @author Rangerson TI
 */
public class Venda {
    public int id;
    public int cod_produto;
    public int qtd_produto;
    public float valor_unitario;
    public float valor_compra;
    public float valor_pago;
    public float valor_troco;
    public String data_venda;
    List<Venda> venda;
}
