package DAO;

import BancoDados.ConectaBanco;
import Classes.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

    public class VendasDAO {
    
        
        private Connection con;
        
        //Conecta com o Banco , com o parâmentro passado pela MAIN
        public VendasDAO(Connection con){
            this.con = con;
        }
        
        public void inserir(Vendas v) throws SQLException{
            try(Connection conecta = new ConectaBanco().conexao()){
                
                String sql = "insert into vendas(id_cliente,data_venda,hora_venda,total_venda) values(?,?,?,?)";
                try(PreparedStatement pstm = conecta.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
                    
                    pstm.setInt(1, v.getId_cliente());
                    pstm.setString(2,v.getData_venda());
                    pstm.setString(3,v.getHora_venda());
                    pstm.setDouble(4, v.getTotal_venda());
                    
                    pstm.execute();
                    try(ResultSet rst = pstm.getGeneratedKeys()){
                        while(rst.next()){
                            v.setId_vendas(rst.getInt(1));
                        }
                        
                    }
                }
            }
        }
         public List<Vendas> listar() throws SQLException{
            //Criar list de vendas
            List<Vendas> vendas =  new ArrayList<>();
            
            // Comando interpretado pelo SQL
            String sql = "SELECT * FROM VENDAS";
            
            //Inserção do comando no prepareStatement
            try(PreparedStatement pstm = con.prepareStatement(sql)){
                pstm.execute();
                
                //Retorno das informações no banco
                try(ResultSet rst = pstm.getResultSet()){
                        while(rst.next()){
                            //Criar Objeto cliente e inserir no arrayList
                            Vendas vend = new Vendas(
                                              rst.getInt(1),
                                              rst.getInt(2),
                                              rst.getString(3),
                                              rst.getString(4),
                                              rst.getDouble(5)
                                             );
                            vendas.add(vend);
                        }
                }
            }
            return vendas;
        }
              public void deletar(Vendas c) throws SQLException{
            try(Connection conecta = new ConectaBanco().conexao()){
                
                String sql = "DELETE FROM VENDAS WHERE ID_CLIENTE = ?";
                try(PreparedStatement pstm = conecta.prepareStatement(sql)){
                
                    pstm.setInt(1, c.getId_vendas());
                    pstm.execute();
                    
                    
                    System.out.println("Deletado com sucesso");
                }
            }
        }
}
