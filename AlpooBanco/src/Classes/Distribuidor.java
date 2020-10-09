package Classes;
    public class Distribuidor {
    
        private Integer id;
        private String nome_fantasia;
        private String razao_social;
        private String telefone;
        private String email;

        // Insert da Main
        public Distribuidor(String nome_fantasia, String razao_social, String telefone, String email) {
            this.nome_fantasia = nome_fantasia;
            this.razao_social = razao_social;
            this.telefone = telefone;
            this.email = email;
        }
        
        //Insert da banco
        public Distribuidor(Integer id, String nome_fantasia, String razao_social, String telefone, String email) {
            this.id = id;
            this.nome_fantasia = nome_fantasia;
            this.razao_social = razao_social;
            this.telefone = telefone;
            this.email = email;
        }
        

        public String getNome_fantasia() {
            return nome_fantasia;
        }

        public String getRazao_social() {
            return razao_social;
        }

        public String getTelefone() {
            return telefone;
        }

        public String getEmail() {
            return email;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return String.format("O distribuidor é: %d - %s - %s - %s ",
                                        this.id,this.nome_fantasia,this.razao_social,this.telefone,this.email);
        }



}
