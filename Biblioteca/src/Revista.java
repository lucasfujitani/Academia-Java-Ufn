import java.time.LocalDate;
public class Revista implements Imprimivel {
    private String titulo;
    private String empresa;
    private int edicao;
    private boolean emprestado;
    private int nmrCopias;


    public Revista(String titulo, String empresa, int edicao) {
        this.titulo = titulo;
        this.empresa = empresa;
        this.edicao = edicao;
        this.emprestado = emprestado;
        this.nmrCopias = 1;
    }

    public boolean reservar() {
        if (!emprestado) {
            emprestado = true;
            return true;
        } else {
            return false;
        }
    }
    public void devolver() {
        emprestado = false;
    }

    public String imprimir() {
        if (emprestado = false) {
            nmrCopias++;
            return "Revista{" +
                    "titulo='" + titulo + '\'' +
                    ", empresa='" + empresa + '\'' +
                    ", edicao=" + edicao +
                    ", emprestado=" + emprestado +
                    ", nmrCopias=" + nmrCopias +
                    '}';
        }return "Erro livro emprestado";
    }


}
