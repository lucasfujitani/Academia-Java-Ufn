import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livros> catalogo;

    public Biblioteca() {
        catalogo = new ArrayList<>();
    }



    public void adicionarLivro(Livros livro) {
        catalogo.add(livro);
    }


    public void removerLivro(String isbn) {
        catalogo.removeIf(livro -> livro.getIsbn().equals(isbn));
    }


    public List<Livros> buscarPorTitulo(String titulo) {
        List<Livros> livrosEncontrados = new ArrayList<>();
        for (Livros livro : catalogo) {
            if (livro.getTitulo().contains(titulo)) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public boolean emprestarLivro(String isbn) {
        for (Livros livro : catalogo) {
            if (livro.getIsbn().equals(isbn)) {
                return livro.reservar();
            }
        }
        return false;
    }

    public void devolverLivro(String isbn) {
        for (Livros livro : catalogo) {
            if (livro.getIsbn().equals(isbn)) {
                livro.devolver();
                break;
            }
        }
    }
    public List<Livros> verificarAtrasosDevolucao(int limiteDias) {
        List<Livros> livrosComAtraso = new ArrayList<>();
        for (Livros livro : catalogo) {
            if (livro.verificarAtrasoDevolucao(limiteDias)) {
                livrosComAtraso.add(livro);
            }
        }
        return livrosComAtraso;
    }
    public List<Livros> listarLivrosEmprestados() {
        List<Livros> livrosEmprestados = new ArrayList<>();
        for (Livros livro : catalogo) {
            if (livro.isEmprestado()) {
                livrosEmprestados.add(livro);
            }
        }
        return livrosEmprestados;
    }

    public List<Livros> listarLivros() {
        return catalogo;
    }
}
