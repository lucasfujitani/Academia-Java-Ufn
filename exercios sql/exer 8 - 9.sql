use teste;

-- 8 
-- seliciona cargo e avg calcula media salarial do salario e chama de mediaSalaria
SELECT cargo, avg(salario) as mediaSalarial
from funcionarios
group by cargo;

-- 9 
SELECT funcionarios.nome AS Nome_Funcionario, departamentos.nome AS Nome_Departamento
FROM funcionarios 
INNER JOIN departamentos ON funcionarios.departamentoID = departamentos.ID;