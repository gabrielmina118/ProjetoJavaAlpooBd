package Principal;

import BancoDados.ConectaBanco;
import Classes.Cliente;
import Classes.Distribuidor;
import DAO.ClienteDAO;
import DAO.DistribuidorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

    public class mainCliente {
    
    public static void main(String[] args) throws SQLException {
       
            
        //Conexao com o banco
        try(Connection con = new ConectaBanco().conexao()){
            ClienteDAO cliente = new ClienteDAO(con); // crio objeto clienteDAO
            List<Cliente> clientes = cliente.listar(); // Passando a funcao listar para "clientes"
            
            for(Cliente cl : clientes){
                System.out.println(cl);
            }
        }
            
   }
}
