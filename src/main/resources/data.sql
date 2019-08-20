insert into endereco(rua, numero, bairro, cidade, estado, cep)
    values('R fulano', 30, 'Antigo', 'Recife', 'PE', null);

insert into transportadora(email, nome, empresa, telefone, modal, celular, whats_app, endereco_id)
    values ('teste@email.com', 'NomeFantasia', 'Nome da empresa', '8131112233', 'AEREO', null, null, 1);
select * from endereco;