package Classes;
    public class Cliente {
    
        private Integer id;
        private String nome;
        private String data_nascimento;
        private String endereco;
        private String telefone;
        private String email;

        
            // Construtor para inicializar os atributos vindo da MAIN
            public Cliente(String nome, String data_nascimento, String endereco, String telefone, String email) {
                this.nome = nome;
                this.data_nascimento = data_nascimento;
                this.endereco = endereco;
                this.telefone = telefone;
                this.email = email;
            }
        
            // Construtor para inicializar os atributos vindos do Banco de dados
            public Cliente(Integer id, String nome, String data_nascimento, String endereco, String telefone, String email) {
                this.id = id;
                this.nome = nome;
                this.data_nascimento = data_nascimento;
                this.endereco = endereco;
                this.telefone = telefone;
                this.email = email;
            }


            public String getNome() {
                return nome;
            }

            public String getData_nascimento() {
                return data_nascimento;
            }

            public String getEndereco() {
                return endereco;
            }

            public String getTelefone() {
                return telefone;
            }

            public String getEmail() {
                return email;
            }
            // Setando o id criado no Bd para a classe cliente
            public void setId(Integer id){
                this.id = id;
            }
            
            // Transforma todo o Objeto em String
            @Override
            public String toString() {
                return String.format("O cliente inserido: %d - %s - %s - %s - %s - %s",
                                     this.id,this.nome,this.data_nascimento,this.endereco,this.telefone,this.email);
           }
            
    
}
