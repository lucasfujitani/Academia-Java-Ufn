use exercicio_2;



-- 4
create table Membro(
ID int primary key auto_increment,
Nome varchar(20),
Email varchar(20)

);

create table Filme(
ID int primary key auto_increment,
Titulo varchar(20),
Diretor varchar(20),
Genero  varchar(20)
);

create table Assistencia(
Membro_ID int,
Filme_ID int,
Data_Assistencia date,
foreign key (Membro_ID) references Membro(ID),
foreign key (Filme_ID) references Filme(ID)

)