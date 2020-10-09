package DAO;

import BancoDados.ConectaBanco;
import Classes.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

    public class ClienteDAO {
    
        private Connection con;
        
        //Conecta com o Banco , com o parâmentro passado pela MAIN
        public ClienteDAO(Connection con){
            this.con = con;
        }
        
        public void inserir(Cliente c) throws SQLException{
            try(Connection conecta = new ConectaBanco().conexao()){
                
                String sql ="INSERT INTO CLIENTE(NOME,DATA_NASCIMENTO,ENDERECO,TELEFONE,EMAIL) VALUES(?,?,?,?,?)";
                
                try(PreparedStatement  pstm = conecta.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
                    pstm.setString(1,c.getNome());
                    pstm.setString(2,c.getData_nascimento());
                    pstm.setString(3,c.getEndereco());
                    pstm.setString(4,c.getTelefone());
                    pstm.setString(5,c.getEmail());
                    
                    pstm.execute();
                    try(ResultSet rst = pstm.getGeneratedKeys()){
                        while(rst.next()){
                            c.setId_cliente(rst.getInt(1));
                        }
                    }
                    
                }
                
            }
            
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
        public void deletar(Cliente c) throws SQLException{
            try(Connection conecta = new ConectaBanco().conexao()){
                
                String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";
                try(PreparedStatement pstm = conecta.prepareStatement(sql)){
                
                    pstm.setInt(1, c.getId());
                    pstm.execute();
                    
                    
                    System.out.println("Deletado com sucesso");
                }
            }
        }
}
