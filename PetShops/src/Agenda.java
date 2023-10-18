import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Agenda {
    private List<Agendamento> agendamentos;
    private SimpleDateFormat dateFormat;

    public Agenda() {
        agendamentos = new ArrayList<>();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    }

    public boolean agendar(Animal animal, Servico servico, Date horario) {
        if (!horarioOcupado(horario)) {
            Agendamento agendamento = new Agendamento(animal, servico, horario);
            agendamentos.add(agendamento);
            System.out.println("Agendamento realizado com sucesso.");
            return true;
        } else {
            System.out.println("Horário já ocupado.");
            return false;
        }
    }

    public void listarAgendamentos() {
        for (Agendamento agendamento : agendamentos) {
            System.out.println(agendamento);
        }
    }

    private boolean horarioOcupado(Date horario) {
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getHorario().equals(horario)) {
                return true;
            }
        }
        return false;
    }
}
