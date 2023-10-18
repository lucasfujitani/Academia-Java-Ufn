import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Inicia as listas
        List<Produto> produtos = new ArrayList<>();
        List<Servico> servicos = new ArrayList<>();
        List<Agenda> agendamentos = new ArrayList<>();

        //Cria os animais com as subclasses
        Animal   animal1 = new Cachorro("Rex", "Golden Retriever", "2020-05-15", "João");
        Animal animal2 = new Gato("Whiskers", "Siamês", "2019-08-20", "Maria");

        //cria os produtos e adiciona na lista
        Produto racao = new Alimento("Ração", 15.0, 100);
        Produto bola = new Brinquedo("Bola", 10.0, 50);
        produtos.add(racao);
        produtos.add(bola);

        //vende produto
        racao.vender(1);
        System.out.println("----------------------------");

         //cria os servicos e adiciona na lista
        Servico banho = new Banho();
        Servico tosa = new Tosa();
        Servico consultaVeterinaria = new ConsultaVeterinaria();
        servicos.add(consultaVeterinaria);
        servicos.add(banho);
        servicos.add(tosa);

        // Cria lista de serviços disponíveis com os serviços
        List<Servico> servicosDisponiveis = List.of(banho, tosa, consultaVeterinaria);
        //Chama o método  listarServicosDisponiveis para listar os serviços disponíveis
        Servico.listarServicosDisponiveis(servicosDisponiveis);
        System.out.println("---------------------------");


        // Cria  lista de produtos disponíveis com os produtos
        List<Produto> produtosDisponiveis = List.of(racao, bola);
        //Chama o método listarProdutosDisponiveis para listar os produtos disponíveis
        Produto.listarProdutosDisponiveis(produtosDisponiveis);
        System.out.println("----------------------------");

        // Cria um agendamento com animal, servico, data e horário
        Agenda agenda1 = new Agenda(animal1, banho, "2023-10-17", "09:00");
        // Chama o método agendar para tentar agendar o serviço
        agenda1.agendar(agendamentos);

        // Chama o método listarAgendamentos para listar os agendamentos
        Agenda.listarAgendamentos(agendamentos);
    }
}