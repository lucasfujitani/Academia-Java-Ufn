import java.text.SimpleDateFormat;
import java.util.Date;

public class Animal {
    private String nome;
    private String especie;
    private String raça;
    private String dataNascimento;
    private String proprietario;
    /////////////////////////////


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    /////////////////////////////
    public Animal(String nome, String especie, String raça, String dataNascimento, String proprietario) {
        this.nome = nome;
        this.especie = especie;
        this.raça = raça;
        this.dataNascimento = dataNascimento;
        this.proprietario = proprietario;
    }

    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", raça='" + raça + '\'' +
                ", data=" + dataNascimento +
                ", proprietario='" + proprietario + '\'' +
                '}';
    }
}
