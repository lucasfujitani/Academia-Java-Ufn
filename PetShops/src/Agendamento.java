import java.util.Date;

public class Agendamento {
    private Animal animal;
    private Servico servico;
    private Date horario;
///////////////////////
    public Agendamento(Animal animal, Servico servico, Date horario) {
        this.animal = animal;
        this.servico = servico;
        this.horario = horario;
    }
    //////////////////////////////


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

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }
////////////////////
    @Override
    public String toString() {
        return "Agendamento{" +
                "animal=" + animal.getNome() +
                ", servico=" + servico.descricao() +
                ", horario=" + horario +
                '}';
    }
}
