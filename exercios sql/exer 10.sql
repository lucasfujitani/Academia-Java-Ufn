use teste;

-- 10
SELECT departamentos.nome AS Nome_Departamento, COUNT(funcionarios.ID) as Numero_Funcionarios 
from departamentos
left join funcionarios on departamentos.ID = funcionarios.departamentoID
group by departamentos.nome; 