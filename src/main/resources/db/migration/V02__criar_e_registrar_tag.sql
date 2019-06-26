CREATE TABLE tag (
         codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
         nome VARCHAR(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tag (nome) values ('Xbox');
INSERT INTO tag (nome) values ('PlayStation');
INSERT INTO tag (nome) values ('Curso online');
INSERT INTO tag (nome) values ('Cinema');
INSERT INTO tag (nome) values ('Lolzinho');