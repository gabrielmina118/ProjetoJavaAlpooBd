create database lojaProjeto;

use lojaProjeto;

select * from itens_venda;
create table cliente(
	id_cliente integer not null primary key auto_increment,
    nome varchar(50),
    data_nascimento date,
    endereco varchar(50),
    telefone varchar(12),
    email varchar(20)
);

create table vendas(
	id_vendas integer not null primary key auto_increment,
    id_cliente integer,
    data_venda date,
    hora_venda time,
    total_venda float,
    constraint fk_pessoa foreign key (id_cliente) references cliente(id_cliente)
);

create table itens_venda(
	id_prod integer,
    id_venda integer,
    quantidade int,
    sub_total float,
    constraint fk_produto foreign key(id_prod) references produto(id_prod),
    constraint fk_venda foreign key(id_venda) references vendas(id_vendas)
);

create table distribuidores(
	id_dist integer not null primary key auto_increment,
    nome_fantasia varchar(50),
    razao_social varchar(50),
    telefone varchar(12),
    email varchar(20)
);

create table produto(
	id_prod integer not null primary key auto_increment,
    id_dist integer,
    preco_venda float,
    descricao varchar(50),
    data_validade date,
    preco_custo float,
    estoque int,
    constraint fk_distribuidores foreign key (id_dist) references distribuidores(id_dist)
);
		
-- Inserindo distribuidores
insert into distribuidores(nome_fantasia,razao_social,telefone,email) values ("distribuidor do alemão","Alemão safado LTDA","984557365","alemao@safado");
insert into distribuidores(nome_fantasia,razao_social,telefone,email) values ("distribuidor do Seu Tiao","tiao berranteiro LTDA","987410365","tiao@berrante");


-- Inserindo Produtos
insert into produto(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) values (1,5.30,"Maionese hell","2022-10-20",10.50,12);
insert into produto(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) values (2,2.30,"Biscoito Trakinas","2020-08-23",11.50,45);
insert into produto(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) values (1,6.30,"Batata palha hell","2020-11-29",10.50,23);
insert into produto(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) values (2,9.30,"KinderOvo","2021-12-30",20.50,35);
insert into produto(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) values (1,3.30,"Sabao em pó","2022-12-24",12.90,50);
insert into produto(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) values (2,9.30,"Detergente ipê","2022-01-28",12.60,32);
insert into produto(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) values (1,6.30,"Biscoito bolacha","2022-10-31",14.57,64);
insert into produto(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) values (2,5.80,"Vodka bigAplle","2022-11-26",21.50,17);
insert into produto(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) values (1,15.30,"cerveja skol 350ml","2022-04-25",18.50,29);
insert into produto(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) values (2,6.90,"Cerveja budweiser 1L","2020-07-10",11.90,48);

-- Inserindo cliente
insert into cliente(nome,data_nascimento,endereco,telefone,email) values ("Gabriel Silva","1997-12-08","Rua das acerolas","972843931","gabriel@mina");
insert into cliente(nome,data_nascimento,endereco,telefone,email) values ("Jose Maria","1977-09-18","Rua das Mangas","984561275","jose@maria");
insert into cliente(nome,data_nascimento,endereco,telefone,email) values ("Ichigo kurosaki","2000-08-25","Rua das Peras","965412354","ichigo@kurosaki");
insert into cliente(nome,data_nascimento,endereco,telefone,email) values ("Naruto Uzumaki","1980-01-29","Rua das maças","988746520","naruto@uzumaki");
insert into cliente(nome,data_nascimento,endereco,telefone,email) values ("Eduard Eric","1970-02-28","Rua das jabuticabas","985552397","eduard@eric");


-- Inserindo Vendas
insert into vendas(id_cliente,data_venda,hora_venda,total_venda) values(1,"2020-10-07","13:20",20);
insert into vendas(id_cliente,data_venda,hora_venda,total_venda) values(1,"2020-07-27","13:20",20);

insert into vendas(id_cliente,data_venda,hora_venda,total_venda) values(2,"2020-10-17","13:20",20);

insert into vendas(id_cliente,data_venda,hora_venda,total_venda) values(2,"2020-10-27","13:20",20);

insert into vendas(id_cliente,data_venda,hora_venda,total_venda) values(3,"2020-10-08","13:20",20);
insert into vendas(id_cliente,data_venda,hora_venda,total_venda) values(3,"2020-10-25","13:20",20);

insert into vendas(id_cliente,data_venda,hora_venda,total_venda) values(4,"2020-10-26","13:20",20);
insert into vendas(id_cliente,data_venda,hora_venda,total_venda) values(4,"2020-10-23","13:20",20);

insert into vendas(id_cliente,data_venda,hora_venda,total_venda) values(5,"2020-10-12","13:20",20);
insert into vendas(id_cliente,data_venda,hora_venda,total_venda) values(5,"2020-10-29","13:20",20);

-- Insert de Itens_venda
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(1,1,2,10.6);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(4,1,1,9.30);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(5,1,1,3.3);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(8,2,1,10.6);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(7,2,1,9.30);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(9,2,1,3.3);

insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(1,3,2,10.6);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(3,3,3,5.30);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(5,3,4,9.3);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(9,4,5,11.6);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(7,4,6,12.30);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(10,4,7,30.3);

insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(10,5,8,50.6);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(2,5,9,46.30);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(3,5,10,100.3);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(4,6,11,110.6);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(5,6,12,123.30);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(6,6,12,130.3);

insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(6,7,2,5.6);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(7,7,4,9.20);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(8,7,5,13.3);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(9,8,1,14.6);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(10,8,2,21.30);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(1,8,4,17.3);

insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(2,9,1,19.6);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(3,9,2,19.30);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(4,9,2,2.3);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(5,10,3,1.6);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(6,10,3,12.30);
insert into itens_venda (id_prod,id_venda,quantidade,sub_total) values(7,10,3,31.3);

-- Cliente ,venda ,nomeProduto e total
select cliente.nome as NomeCliente , vendas.id_vendas as Id_vendas , produto.descricao as NomeProduto , vendas.total_venda as TotVenda from cliente inner join vendas inner join itens_venda inner join produto
	where vendas.id_cliente =cliente.id_cliente and itens_venda.id_venda =vendas.id_vendas and itens_venda.id_prod = produto.id_prod order by Id_vendas;

-- Cliente com venda
select cliente.id_cliente as IDCLIENTE, cliente.nome as nomeCLiente, vendas.id_vendas as IDVENDA , vendas.data_venda as DATAVENDA  
		from vendas inner join cliente where vendas.id_cliente = cliente.id_cliente;
        
-- Distribuidores com produto
select distribuidores.nome_fantasia as Nome_destribuidor , produto.descricao as NomeProduto from distribuidores inner join produto where produto.id_dist = distribuidores.id_dist;
 