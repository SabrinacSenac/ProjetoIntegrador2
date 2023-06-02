Drop Database If Exists padoca;

Create Database padoca;

Use padoca;

Create Table cliente (
	id				Int Primary Key Auto_Increment,
	nome			Varchar(100),
    cpf				Char(14),
    telefone		Varchar(20),
    data_nascimento	DateTime(2),
    email			Varchar(100),
    estado_civil	Varchar(20),
    sexo			Varchar(20),
    cep				Char(9),
    rua				Varchar(100),
    numero			Int,
    bairro			Varchar(75),
    cidade			Varchar(75),
    uf				Char(2));
    
Create Table produto (
	id				Int Primary Key Auto_Increment,
    nome			Varchar(100),
    data_fabricacao	DateTime(2),
    categoria		Varchar(50),
    qtd				Int,
    peso			Decimal(5,2),
    preco			Decimal(5,2)
);

Create Table vendas (
	id				Int Primary Key Auto_Increment,
    data_venda		DateTime(2),
    total			Decimal(5,2),
    cliente_id		Int,
Foreign Key (cliente_id) References cliente(id)
);

Create Table vendas_produto (
	id				Int Primary Key Auto_Increment,
    venda_id		Int,
    produto_id		Int,
    qtd				Int,
Foreign Key (venda_id) References vendas(id),
Foreign Key (produto_id) References produto(id)
);