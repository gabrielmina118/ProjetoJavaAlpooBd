package Principal;

import BancoDados.ConectaBanco;
import Classes.Itens_vendas;
import DAO.Itens_vendasDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

    public class mainItens_vendas {
        public static void main(String[] args) throws SQLException {
            
            //Inserindo novo item
            Itens_vendas itens = new Itens_vendas(10,10,2,5.45);
            
            try(Connection con = new ConectaBanco().conexao()){
                
                Itens_vendasDAO item =  new Itens_vendasDAO(con);
                List<Itens_vendas> itensVendas = item.listar();
                
                //Inserindo novo item no arrayList
                item.inserir(itens);
                
                
                for(Itens_vendas i : itensVendas){
                    System.out.println(i);
                }
            }
        }
}
