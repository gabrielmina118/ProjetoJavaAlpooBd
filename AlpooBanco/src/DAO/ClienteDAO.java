package DAO;

import Classes.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class ClienteDAO {
    
        private Connection con;
        
        //Conecta com o Banco , com o parâmentro passado pela MAIN
        public ClienteDAO(Connection con){
            this.con = con;
        }
        
        // Retorna uma array de clientes
        public List<Cliente> listar() throws SQLException{
            //Criar list de clientes
            List<Cliente> clientes =  new ArrayList<>();
            
            // Comando interpretado pelo SQL
            String sql = "SELECT * FROM CLIENTE";
            
            //Inserção do comando no prepareStatement
            try(PreparedStatement pstm = con.prepareStatement(sql)){
                pstm.execute();
                
                //Retorno das informações no banco
                try(ResultSet rst = pstm.getResultSet()){
                        while(rst.next()){
                            //Criar Objeto cliente e inserir no arrayList
                            Cliente cliente = new Cliente(
                                              rst.getInt(1),
                                              rst.getString(2),
                                              rst.getString(3),
                                              rst.getString(4),
                                              rst.getString(5),
                                              rst.getString(6)
                                             );
                            clientes.add(cliente);
                        }
                }
            }
            return clientes;
        }
}
