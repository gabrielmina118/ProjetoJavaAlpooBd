package Principal;

import BancoDados.ConectaBanco;
import Classes.Vendas;
import DAO.VendasDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

    public class mainVendas {
        public static void main(String[] args) throws SQLException {
           
            //Inserindo nova venda como objeto
            Vendas vend = new Vendas(1,"2020-10-08","20:08",150);
            
            try(Connection con = new ConectaBanco().conexao()){
                VendasDAO vendas = new VendasDAO(con); //Criando o DAO passando a conexao
                List<Vendas> ve = vendas.listar(); // adicionando na variavel todo o ArrayList
                
                vendas.inserir(vend); // Inserindo no ArrayList o objeto
                
                // Listando o List de vendas
                for(Vendas v : ve){
                    System.out.println(v);
                }
            }
        }
}
