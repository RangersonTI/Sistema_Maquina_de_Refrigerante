/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifto.maquina_refri_manutencao;
import ifto.maquina_db.*;
import Models.*;
import java.util.List;
/**
 *
 * @author Rangerson TI
 */
public class SysManutencao {
    public void CadastrarRefrigerante(){
        Conexao connect = new Conexao();
        connect.Conectar();
        connect.Desconectar();
    }

    public List<Produtos> BuscarProdutos(){
        return new ProdutosBD().BuscarProdutos();
    }

    public void EntradaDeEstoque(){
        
    }
    
    public void SaidaDeEstoque(){
        
    }
}
