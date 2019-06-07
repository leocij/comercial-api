create table oportunidade (
    id bigint auto_increment not null,
    nome_prospecto varchar(80) not null,
    descricao varchar(200) not null,
    valor decimal(10,2),
    primary key (id)
);

insert into oportunidade (nome_prospecto, descricao, valor) values ('João da Silva', 'Projeto de CRM em java', 190000.00);
insert into oportunidade (nome_prospecto, descricao, valor) values ('José Pereira', 'Projeto de CALLCENTER', 80000.00);
