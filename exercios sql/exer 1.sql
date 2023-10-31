use teste;


-- 1
-- cria tabela departamento
create Table departamentos(
ID int primary KEY AUTO_INCREMENT,
nome VARCHAR(50)
);


-- cria tabela funcionarios
create Table funcionarios(
ID int primary KEY AUTO_INCREMENT, -- campo id como chave primaria automaticamente
nome VARCHAR(50),
cargo VARCHAR(50), 
salario DECIMAL(10,2), -- o valor 10 representa o total de digitos  e 2 reprensenta as casas decimais
dataContratacao DATE,
departamentoID int, 
foreign KEY (departamentoID) REFERENCES departamentos(ID) -- chave estrangeira que faz referencia ao ID na tabela departamentos
);




