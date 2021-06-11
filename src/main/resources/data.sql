INSERT INTO CATEGORIA(nome) VALUES ('Fantasia');
INSERT INTO CATEGORIA(nome) VALUES ('Horror');

INSERT INTO AUTOR(nome) VALUES ('George R R Martin');
INSERT INTO AUTOR(nome) VALUES ('Edgar Allan Poe');

INSERT INTO LIVRO(nome, codigo, data_criacao, publicado, categoria_id) VALUES ('Festim dos corvos', '123-456-178', '2021-06-12', 1, 1);
INSERT INTO LIVRO(nome, codigo, data_criacao, publicado, categoria_id) VALUES ('A Dança dos Dragões', '123-456-179', '2021-06-12', 1, 1);
INSERT INTO LIVRO(nome, codigo, data_criacao, publicado, categoria_id) VALUES ('O Corvo', '123-456-180', '2021-06-12', 1, 2);

INSERT INTO LIVRO_AUTORES(livro_id, autores_id) VALUES (1,1);
INSERT INTO LIVRO_AUTORES(livro_id, autores_id) VALUES (2,1);
INSERT INTO LIVRO_AUTORES(livro_id, autores_id) VALUES (3,2);
