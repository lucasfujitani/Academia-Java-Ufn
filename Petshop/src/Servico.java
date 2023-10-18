import java.util.List;

abstract class Servico {
    public abstract String descricao();
    public abstract double preco();

    public static void listarServicosDisponiveis(List<Servico> servicosDisponiveis) {
        System.out.println("Serviços disponíveis:");
        for (Servico servico : servicosDisponiveis) {
            System.out.println(servico.descricao() + ", Preço: " + servico.preco());
        }
    }
}
