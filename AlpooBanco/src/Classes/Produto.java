package Classes;
    public class Produto {
        
        private Integer id;
        private Integer id_dist;
        private double preco_venda;
        private String descricao;
        private String data_validade;
        private double preco_custo;
        private Integer estoque;
        
        // Construtor do BD
        public Produto(Integer id, Integer id_dist, double preco_venda, String descricao, String data_validade, double preco_custo, Integer estoque) {
            this.id = id;
            this.id_dist = id_dist;
            this.preco_venda = preco_venda;
            this.descricao = descricao;
            this.data_validade = data_validade;
            this.preco_custo = preco_custo;
            this.estoque = estoque;
        }
        //Construtor da MAIN
        public Produto(Integer id_dist, double preco_venda, String descricao, String data_validade, double preco_custo, Integer estoque) {
            this.id_dist = id_dist;
            this.preco_venda = preco_venda;
            this.descricao = descricao;
            this.data_validade = data_validade;
            this.preco_custo = preco_custo;
            this.estoque = estoque;
        }

        public Integer getId(){
            return id;
        }
        public Integer getId_dist() {
            return id_dist;
        }

        public double getPreco_venda() {
            return preco_venda;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getData_validade() {
            return data_validade;
        }

        public double getPreco_custo() {
            return preco_custo;
        }

        public Integer getEstoque() {
            return estoque;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return String.format("O Produto é: %d - %d - %f - %s - %s - %f - %d",
                                    this.id,this.id_dist,this.preco_venda,this.descricao,this.data_validade,this.preco_custo,this.estoque);
        }
        
        
        
}
