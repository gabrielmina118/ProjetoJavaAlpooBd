package Principal;

import BancoDados.ConectaBanco;
import Classes.Distribuidor;
import DAO.DistribuidorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

    public class mainDistribuidor {
        public static void main(String[] args) throws SQLException {
            
            // Criando objeto de um Distribuidor
            Distribuidor dist = new Distribuidor("Coelho neto","Coelho neto LTDA","32548765","Coelho@neto");
            
            // O TRY serve para tratar excecao do connection e fechar a conexao
            try(Connection con = new ConectaBanco().conexao()){
                DistribuidorDAO d = new DistribuidorDAO(con); // Criando o DAO
                List<Distribuidor> distribuidores = d.listar(); // inserindo na variavel o ArrayList
                
                d.inserir(dist); // Inserindo novo Objeto na Lista
                
                // Listando o ArrayList
                for(Distribuidor di :distribuidores){
                    System.out.println(di);
                }
            }
            
        }
}
