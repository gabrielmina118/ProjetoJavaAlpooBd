create database lojaProjeto;

use lojaProjeto;


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
    id_itens_venda integer,
    data_venda date,
    hora_venda time,
    total_venda float,
    constraint fk_pessoa foreign key (id_cliente) references cliente(id_cliente),
    constraint fk_itens_venda foreign key (id_itens_venda) references itens_venda(id_itens_venda)
);

create table itens_venda(
	id_prod integer,
    id_venda integer,
    quantidade int,
    sub_total float,
    constraint fk_produto foreign key(id_prod) references produto(id_prod),
    constraint fk_venda foreign key(id_venda) references venda(id_vendas)
);
drop table itens_venda;
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


-- Inserindo distribuidor
insert into distribuidores(nome_fantasia,razao_social,telefone,email) values ("distribuidor do alemão","Alemão safado LTDA","984557365","alemao@safado");

-- Inserindo Produtos
insert into produto(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) values (1,5.30,"Maionese hell","2022-10-10",10.50,20);
insert into produto(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) values (1,2.30,"Biscoito Trakinas","2020-08-23",11.50,200);
insert into produto(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) values (1,6.30,"Batata palha hell","2020-11-29",10.50,20);
insert into produto(id_dist,preco_venda,descricao,data_validade,preco_custo,estoque) values (1,9.30,"KinderOvo","2021-12-30",20.50,20);

-- Inserindo cliente
insert into cliente(nome,data_nascimento,endereco,telefone,email) values ("Gabriel Silva","1997-12-08","Rua das acerolas","972843931","gabriel@mina");
insert into cliente(nome,data_nascimento,endereco,telefone,email) values ("Jose Maria","1977-09-18","Rua das Mangas","984561275","jose@maria");
insert into cliente(nome,data_nascimento,endereco,telefone,email) values ("Ichigo kurosaki","2000-08-25","Rua das Peras","965412354","ichigo@kurosaki");
insert into cliente(nome,data_nascimento,endereco,telefone,email) values ("Naruto Uzumaki","1980-01-29","Rua das maças","988746520","naruto@uzumaki");
insert into cliente(nome,data_nascimento,endereco,telefone,email) values ("Eduard Eric","1970-02-28","Rua das jabuticabas","985552397","eduard@eric");


