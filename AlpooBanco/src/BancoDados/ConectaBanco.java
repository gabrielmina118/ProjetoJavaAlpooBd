package BancoDados;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class ConectaBanco {
    // Interface da pool para conexao com o Banco de dados;
    private DataSource data;
    
        public ConectaBanco(){
            // Pool de conexao , passando os dados do banco de dados 
           ComboPooledDataSource combo = new ComboPooledDataSource();
           combo.setJdbcUrl("jdbc:mysql://localhost/lojaProjeto?useTimezone=true&serverTimezone=UTC");
           combo.setUser("root");
           combo.setPassword("a258mina");
           
           combo.setMaxPoolSize(10); // Tamanho limite de conexoes abertas
           
           this.data =  combo;

        }
        /* Conexao com o banco de dados , passando o Datasource , 
            assim a variavel data acessa o funcao getConnection e retorna uma Connection.
        */
        public Connection conexao() throws SQLException{
            return this.data.getConnection();
        }
}
