package Principal;

import BancoDados.ConectaBanco;
import Classes.Cliente;
import DAO.ClienteDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

    public class mainCliente {
    
    public static void main(String[] args) throws SQLException {
        
       //Inserindo cliente novo
        Cliente maria = new Cliente("Maria do carmo","1980-06-20","Rua do carmo","987456652","maria@carmo");
        
        //Conexao com o banco
        try(Connection con = new ConectaBanco().conexao()){
            ClienteDAO cli = new ClienteDAO(con); // crio objeto clienteDAO
            List<Cliente> clientes = cli.listar(); // Passando a funcao listar para "clientes"
            
            //Adicionando Novo cliente
            cli.inserir(maria);
            
            // Removendo Maria
            cli.deletar(maria);
            
            for(Cliente cl : clientes){
                System.out.println(cl);
            }
        }
            
   }

}
