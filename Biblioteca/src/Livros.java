import java.time.LocalDate;

public class Livros implements Imprimivel {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean emprestado;
    private LocalDate dataEmprestimo;


    public Livros(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.emprestado = false;
        this.dataEmprestimo = null;
    }


    public boolean reservar() {
        if (!emprestado) {
            emprestado = true;
            dataEmprestimo = LocalDate.now();
            return true;
        } else {
            return false;
        }
    }

    public void devolver() {
        emprestado = false;
    }

    public boolean verificarAtrasoDevolucao(int limiteDias) {
        if (emprestado) {
            LocalDate dataAtual = LocalDate.now();
            LocalDate dataLimite = dataEmprestimo.plusDays(limiteDias);
            return dataAtual.isAfter(dataLimite);
        }
        return false;
    }


    public String imprimir() {
        String statusEmprestado = emprestado ? "Emprestado" : "Disponível";
        String info = "Título: " + titulo + "\nAutor: " + autor + "\nISBN: " + isbn + "\nStatus: " + statusEmprestado;
        return info;
    }

    public String getTitulo() {
        return titulo;
    }


    public String getIsbn() {
        return isbn;
    }


    public boolean isEmprestado() {
        return emprestado;
    }
}
