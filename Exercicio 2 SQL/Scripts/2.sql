use exercicio_2;

-- 2
create table Professor(
ID int primary key auto_increment,
Nome varchar (20),
Area_Especializada varchar(20),
Codigo_Identificacao INT
);

create table Aluno(
Matricula int primary key auto_increment,
Nome varchar(20),
Data_Nascimento date
);

create table Orientecao(
Professor_ID int,
Aluno_Matricula int,
foreign key (Professor_ID) references Professor(ID),
foreign key (Aluno_Matricula) references Aluno(Matricula)
);