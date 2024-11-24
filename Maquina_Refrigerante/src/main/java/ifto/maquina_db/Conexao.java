/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifto.maquina_db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Rangerson TI
 */
public class Conexao {
    private Connection conexao;

    public boolean Conectar(){
        try{
            String caminho = "jdbc:sqlite:banco_de_dados/banco.db";
            this.conexao = DriverManager.getConnection(caminho);
            
            Statement statement = conexao.createStatement();
            statement.setQueryTimeout(15);

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Produto"
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "nome VARCHAR(20) NOT NULL,"
                    + "QtdML INT NOT NULL,"
                    + "QtdEstoque INT NOT NULL)");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Vendas"
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "cod_produto INTERGER NOT NULL,"
                    + "qtd_produto INT NOT NULL,"
                    + "valor_unitario REAL NOT NULL,"
                    + "valor_total REAL NOT NULL,"
                    + "data_venda DATETIME NOT NULL)");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Caixa"
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "valor_caixa REAL NOT NULL,"
                    + "data_valor DATE NOT NULL)");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Cedula_moeda_troco"
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "qtd_cedula_dez INT,"
                    + "qtd_cedula_cinco INT,"
                    + "qtd_cedula_dois INT,"
                    + "qtd_moeda_um INT,"
                    + "qtd_moeda_cinquenta_cents INT)");
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            System.out.println("Erro na conexão");
            return false;
        }

        return true;
    }
    
    public boolean Desconectar(){
        try{
            if (this.conexao.isClosed() == false){
                this.conexao.close();
        }
           /* Statement statement = conexao.createStatement();
            statement.setQueryTimeout(15);
            
            statement.executeUpdate("CREATE TABLE Refrigerantes(id INT PRIMARY KEY AUTO_INCREMENT, "
                                       + "nome VARCHAR(20), QtdML INT, QtdEstoque INT)");*/
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
        
        return true;
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
