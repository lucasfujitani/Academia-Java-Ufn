class ConsultaVeterinaria extends Servico {
    @Override
    public String descricao() {
        return "Consulta veterinária para o animal.";
    }

    @Override
    public double preco() {
        return 50.0; // Preço da consulta veterinária
    }
}
