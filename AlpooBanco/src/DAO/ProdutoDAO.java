package DAO;

import BancoDados.ConectaBanco;
import Classes.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

    public class ProdutoDAO {
    
                private Connection con;
        
        //Conecta com o Banco , com o parâmentro passado pela MAIN
        public ProdutoDAO(Connection con){
            this.con = con;
        }
        
        public void inserir(Produto p) throws SQLException{
            try(Connection con = new ConectaBanco().conexao()){
                
                String sql = "INSERT INTO PRODUTO(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) VALUES(?,?,?,?,?,?)";
                try(PreparedStatement pstm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
                    pstm.setInt(1, p.getId_dist());
                    pstm.setDouble(2,p.getPreco_venda());
                    pstm.setString(3, p.getDescricao());
                    pstm.setString(4, p.getData_validade());
                    pstm.setDouble(5, p.getPreco_custo());
                    pstm.setInt(6, p.getEstoque());
                    pstm.execute();
                    
                    try(ResultSet rst = pstm.getGeneratedKeys()){
                        while(rst.next()){
                            p.setId(rst.getInt(1));
                        }
                        
                    }
                }
            }
        }
         public List<Produto> listar() throws SQLException{
            //Criar list de produto
            List<Produto> produtos =  new ArrayList<>();
            
            // Comando interpretado pelo SQL
            String sql = "SELECT * FROM PRODUTO";
            
            //Inserção do comando no prepareStatement
            try(PreparedStatement pstm = con.prepareStatement(sql)){
                pstm.execute();
                
                //Retorno das informações no banco
                try(ResultSet rst = pstm.getResultSet()){
                        while(rst.next()){
                            //Criar Objeto cliente e inserir no arrayList
                            Produto prod = new Produto(
                                              rst.getInt(1),
                                              rst.getInt(2),
                                              rst.getDouble(3),
                                              rst.getString(4),
                                              rst.getString(5),
                                              rst.getDouble(6),
                                              rst.getInt(7)
                                             );
                            produtos.add(prod);
                        }
                }
            }
            return produtos;
        }
             public void deletar(Produto p) throws SQLException{
            try(Connection conecta = new ConectaBanco().conexao()){
                
                String sql = "DELETE FROM PRODUTO WHERE ID_CLIENTE = ?";
                try(PreparedStatement pstm = conecta.prepareStatement(sql)){
                
                    pstm.setInt(1, p.getId());
                    pstm.execute();
                    
                    
                    System.out.println("Deletado com sucesso");
                }
            }
        } 
         
}
