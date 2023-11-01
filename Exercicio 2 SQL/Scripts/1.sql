create schema exercicio_2;

-- 1
create table Leitor (	
ID int primary key auto_increment,
Nome varchar(20),
Endereco varchar (20),
NumeroTelefone varchar(20)
);

create table Livro(
ISBN VARCHAR(20) primary Key,
Titulo varchar(20),
Autor varchar(20),
AnoPublicacao int
);

CREATE TABLE Emprestimo(
ID int primary key auto_increment,
Leitor_ID int,
Livro_ISBN varchar(20),
DataEmprestimo date, 
DataDevolucao date,
foreign key (Leitor_ID) references Leitor(ID),
foreign key (Livro_ISBN) references Livro(ISBN)
);