package Principal;

import BancoDados.ConectaBanco;
import Classes.Produto;
import DAO.ProdutoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

    public class mainProduto {
        public static void main(String[] args) throws SQLException {
            
            Produto prod = new Produto(2,15.30,"Cerveja Amstel 473ML Geladinha","2020-10-07",10.50,120);
            
            try(Connection con = new ConectaBanco().conexao()){
                ProdutoDAO p = new ProdutoDAO(con);
                List<Produto> produtos = p.listar();
               // p.inserir(prod);
               // p.deletar(prod);
                
                for(Produto pr:produtos){
                    System.out.println(pr);
                }
            }
        }
}
