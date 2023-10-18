import java.util.List;

class Agenda {
    private Animal animal;
    private Servico servico;
    private String data;
    private String horario;

    public Agenda(Animal animal, Servico servico, String data, String horario) {
        this.animal = animal;
        this.servico = servico;
        this.data = data;
        this.horario = horario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }


    public boolean verificarDisponibilidade(List<Agenda> agendamentos) {
        for (Agenda agenda : agendamentos) {
            if (agenda.getData().equals(this.getData()) && agenda.getHorario().equals(this.getHorario())) {
                return false; // Horário ocupado
            }
        }
        return true; // Horário disponível
    }
    public boolean agendar(List<Agenda> agendamentos) {
        if (verificarDisponibilidade(agendamentos)) {
            agendamentos.add(this);
            System.out.println("Agendamento realizado.");
            return true;
            } else {
            System.out.println("Horário já está ocupado. Escolha outro horário.");
            return false;
        }
    }
    public static void listarAgendamentos(List<Agenda> agendamentos) {
        System.out.println("Lista de Agendamentos:");
        for (Agenda agenda : agendamentos) {
            System.out.println("Data: " + agenda.getData());
            System.out.println("Horário: " + agenda.getHorario());
            System.out.println("Animal: " + agenda.getAnimal().getNome());
            System.out.println("Serviço: " + agenda.getServico().descricao());
            System.out.println();
        }
    }


}
