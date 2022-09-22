create table tb_assistances
(
    id          bigint auto_increment
        primary key,
    description varchar(350) not null,
    name        varchar(150) not null
);

INSERT INTO tb_assistances(name,description) values ('Troca de Aparelho','Troca de Aparelho decodificador de sinal');
INSERT INTO tb_assistances(name,description) values ('Troca de cabo interno','Troca de cabo interno do decodificador');
INSERT INTO tb_assistances(name,description) values ('Troca de fiação interna','Troca de fiação interna da residência');
INSERT INTO tb_assistances(name,description) values ('Manutentenção de Fogão','Ajuste sem necessidade de troca de peças');
INSERT INTO tb_assistances(name,description) values ('Manutentação de geladeira','Manutentação na geladeira');
INSERT INTO tb_assistances(name,description) values ('Manutenção na máquina de lavar','Manutenção sem necessidade de compra de peças');