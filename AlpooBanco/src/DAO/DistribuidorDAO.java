package DAO;

import BancoDados.ConectaBanco;
import Classes.Cliente;
import Classes.Distribuidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DistribuidorDAO {

        private Connection con;
        
        //Conecta com o Banco , com o parâmentro passado pela MAIN
        public DistribuidorDAO(Connection con){
            this.con = con;
        }
        
        public void inserir(Distribuidor d) throws SQLException{
            try(Connection con = new ConectaBanco().conexao()){
                
                String sql = "INSERT INTO DISTRIBUIDORES(nome_fantasia,razao_social,telefone,email) VALUES(?,?,?,?)";
                try(PreparedStatement pstm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
                    pstm.setString(1,d.getNome_fantasia());
                    pstm.setString(2,d.getRazao_social());
                    pstm.setString(3,d.getTelefone());
                    pstm.setString(4,d.getEmail());
                    
                    pstm.execute();
                    try(ResultSet rst = pstm.getGeneratedKeys()){
                        while(rst.next()){
                            d.setId(rst.getInt(1));
                        }
                        
                    }
                }
            }
        }
         public List<Distribuidor> listar() throws SQLException{
            //Criar list de distribuidores
            List<Distribuidor> distribuidores =  new ArrayList<>();
            
            // Comando interpretado pelo SQL
            String sql = "SELECT * FROM DISTRIBUIDORES";
            
            //Inserção do comando no prepareStatement
            try(PreparedStatement pstm = con.prepareStatement(sql)){
                pstm.execute();
                
                //Retorno das informações no banco
                try(ResultSet rst = pstm.getResultSet()){
                        while(rst.next()){
                            //Criar Objeto cliente e inserir no arrayList
                            Distribuidor distri = new Distribuidor(
                                              rst.getInt(1),
                                              rst.getString(2),
                                              rst.getString(3),
                                              rst.getString(4),
                                              rst.getString(5)
                                             );
                            distribuidores.add(distri);
                        }
                }
            }
            return distribuidores;
        }
        
        

}
