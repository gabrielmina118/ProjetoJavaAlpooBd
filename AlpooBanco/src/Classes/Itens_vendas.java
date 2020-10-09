package Classes;
    public class Itens_vendas {
    
        private Integer id_prod;
        private Integer id_venda;
        private Integer quantidade;
        private double sub_total;

        
        public Itens_vendas(Integer id_prod, Integer id_venda, Integer quantidade, double sub_total) {
            this.id_prod = id_prod;
            this.id_venda = id_venda;
            this.quantidade = quantidade;
            this.sub_total = sub_total;
        }

        public Integer getId_prod() {
            return id_prod;
        }

        public Integer getId_venda() {
            return id_venda;
        }

        public Integer getQuantidade() {
            return quantidade;
        }

        public double getSub_total() {
            return sub_total;
        }

        @Override
        public String toString() {
            return String.format("Itens vendas: %d - %d - %d - %f", 
                                this.id_prod,this.id_venda,this.quantidade,this.sub_total);
        }


        
}
