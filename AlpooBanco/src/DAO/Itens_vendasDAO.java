package DAO;

import BancoDados.ConectaBanco;
import Classes.Itens_vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class Itens_vendasDAO {
    
        private Connection con;
        
        public Itens_vendasDAO(Connection con){
            this.con = con;
        }
        
        public void inserir(Itens_vendas iv) throws SQLException{
            try(Connection conecta = new ConectaBanco().conexao()){
                
                String sql ="insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(?,?,?,?)";
                try(PreparedStatement pstm = conecta.prepareStatement(sql)){
                    pstm.setInt(1, iv.getId_prod());
                    pstm.setInt(2,iv.getId_venda());
                    pstm.setInt(3, iv.getQuantidade());
                    pstm.setDouble(4, iv.getSub_total());
                    pstm.execute();
                    
                }
            }
        }
        
        public List<Itens_vendas> listar() throws SQLException{
            List<Itens_vendas> vendas = new ArrayList<>();
            
            String sql = "SELECT * FROM ITENS_VENDA";
            try(PreparedStatement pstm = con.prepareStatement(sql)){
                pstm.execute();
                
                try(ResultSet rst = pstm.getResultSet()){
                    while(rst.next()){
                        Itens_vendas itens = new Itens_vendas(
                                                        rst.getInt(1),
                                                        rst.getInt(2),
                                                        rst.getInt(3),
                                                        rst.getDouble(4)
                                                );
                        vendas.add(itens);
                    }
                }
            }
            return vendas;
        }
        
        
}
