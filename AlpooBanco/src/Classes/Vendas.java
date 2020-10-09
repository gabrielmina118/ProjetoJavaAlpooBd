package Classes;
    public class Vendas {
    
        private Integer id_vendas;
        private Integer id_cliente;
        private String data_venda;
        private String hora_venda;
        private double total_venda;

         // Construtor da MAIN
        public Vendas(Integer id_cliente, String data_venda, String hora_venda, double total_venda) {
            this.id_cliente = id_cliente;
            this.data_venda = data_venda;
            this.hora_venda = hora_venda;
            this.total_venda = total_venda;
        }
        
        //Construtor do Banco
        public Vendas(Integer id_vendas, Integer id_cliente, String data_venda, String hora_venda, double total_venda) {
            this.id_vendas = id_vendas;
            this.id_cliente = id_cliente;
            this.data_venda = data_venda;
            this.hora_venda = hora_venda;
            this.total_venda = total_venda;
        }

        public Integer getId_vendas(){
            return this.id_vendas;
        }
        public Integer getId_cliente() {
            return id_cliente;
        }

        public String getData_venda() {
            return data_venda;
        }

        public String getHora_venda() {
            return hora_venda;
        }

        public double getTotal_venda() {
            return total_venda;
        }

        public void setId_vendas(Integer id_vendas) {
            this.id_vendas = id_vendas;
        }

        @Override
        public String toString() {
            return String.format("A Venda é : %d - %d - %s - %s - %f", 
                                 this.id_vendas,this.id_cliente,this.data_venda,this.hora_venda,this.total_venda);
        }

        
        
}
