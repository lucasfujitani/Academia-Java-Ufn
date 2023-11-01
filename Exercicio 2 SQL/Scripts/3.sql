use exercicio_2;

-- 3
create table Cliente(
CPF char(11) PRIMARY KEY,
Nome varchar(20),
Email varchar(20)

);

create table Produto(
Codigo VARCHAR(50) primary key,
Nome varchar(20),
Preco decimal (10,2)

);

create table Compra(
Compra_ID int primary key auto_increment,
Cliente_CPF char(11),
Produto_Codigo VARCHAR(50),
Data_Compra date,
Quantidade INT,
foreign key (Cliente_CPF) references Cliente(CPF),
foreign key (Produto_Codigo) references Produto(Codigo)

);

