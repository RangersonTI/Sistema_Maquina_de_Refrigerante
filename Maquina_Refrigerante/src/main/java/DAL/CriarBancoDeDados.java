/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.io.File;

/**
 *
 * @author Rangerson TI
 */
public class CriarBancoDeDados {
    private Connection conexao;

    public void CriarBancoDeDados(){
        if(!new File("C:\\Users\\Rangerson TI\\Documents\\GitHub\\Sistema_Maquina_de_Refrigerante\\Maquina_Refrigerante\\banco_de_dados\\banco.db").exists()){
            if(!new File("/home/202212160019@ifto.local/Documentos/GitHub/Sistema_Maquina_de_Refrigerante/Maquina_Refrigerante/banco_de_dados/banco.db").exists()){
                try{

                    String caminho = "jdbc:sqlite:banco_de_dados/banco.db";
                    this.conexao = DriverManager.getConnection(caminho);

                    Statement statement = conexao.createStatement();
                    statement.setQueryTimeout(15);

                    statement.executeUpdate("CREATE TABLE IF NOT EXISTS Produto"
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + "nome VARCHAR(20) NOT NULL,"
                            + "QtdML INT NOT NULL,"
                            + "QtdEstoque INT,"
                            + "valor_item REAL NOT NULL)");

                    statement.executeUpdate("CREATE TABLE IF NOT EXISTS Vendas"
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + "cod_produto INTERGER NOT NULL,"
                            + "qtd_produto INT NOT NULL,"
                            + "valor_unitario REAL NOT NULL,"
                            + "valor_total REAL NOT NULL,"
                            + "valor_troco REAL NOT NULL,"
                            + "data_venda DATETIME NOT NULL)");

                    statement.executeUpdate("CREATE TABLE IF NOT EXISTS Caixa"
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + "valor_caixa REAL NOT NULL,"
                            + "data_valor DATE NOT NULL)");

                    statement.executeUpdate("CREATE TABLE IF NOT EXISTS Qtd_Cedula_moeda_troco"
                            + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + "qtd_cedula_dez INT,"
                            + "qtd_cedula_cinco INT,"
                            + "qtd_cedula_dois INT,"
                            + "qtd_moeda_um INT,"
                            + "qtd_moeda_cinquenta_cents INT)");

                    statement.executeUpdate("INSERT INTO Qtd_Cedula_moeda_troco(qtd_cedula_dez,qtd_cedula_cinco,"
                            + "qtd_cedula_dois, qtd_moeda_um, qtd_moeda_cinquenta_cents) VALUES(0,0,0,0,0)");

                    this.conexao.close();
                }
                catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, ex, "Erro ao criar banco de dados.", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, "Banco de dados criado com sucesso", null, JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}