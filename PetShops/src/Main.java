import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {

    public static void main(String[] args) {
        // Criando horários
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date horario1 = null;
        Date horario2 = null;

        try {
            horario1 = dateFormat.parse("10/10/2023 14:30");
            horario2 = dateFormat.parse("15/10/2023 10:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Criar objetos de exemplo
        Animal animal1 = new Animal("Fido", "Cachorro", "Bulldog", "20/12/2019", "João");
        Animal animal2 = new Animal("Whiskers", "Gato", "Siamese", "20/10/2022", "Maria");

        Produto produto1 = new Produto("Ração", "Alimento", 30.0, 100);
        Produto produto2 = new Produto("Brinquedo", "Diversão", 15.0, 50);

        // Criando serviços
        Servico servico1 = new BanhoTosa();
        Servico servico2 = new ConsultaVeterinario();

        // Testar a agenda
        Agenda agenda = new Agenda();
        agenda.agendar(animal1, servico1, horario1);
        agenda.agendar(animal2, servico2, horario2);
        agenda.listarAgendamentos();
    }
}