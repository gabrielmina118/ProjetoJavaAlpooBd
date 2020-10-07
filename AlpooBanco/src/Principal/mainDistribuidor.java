package Principal;

import BancoDados.ConectaBanco;
import Classes.Distribuidor;
import DAO.DistribuidorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

    public class mainDistribuidor {
        public static void main(String[] args) throws SQLException {
            
            Distribuidor dist = new Distribuidor("Coelho neto","Coelho neto LTDA","32548765","Coelho@neto");
            
            
            try(Connection con = new ConectaBanco().conexao()){
                DistribuidorDAO d = new DistribuidorDAO(con);
                List<Distribuidor> distribuidores = d.listar();
                
                d.inserir(dist);
                
                for(Distribuidor di :distribuidores){
                    System.out.println(di);
                }
            }
            
        }
}
