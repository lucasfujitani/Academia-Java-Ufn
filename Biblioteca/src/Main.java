import java.util.List;

public class Main {
    public static void main(String[] args) {

                Biblioteca biblioteca = new Biblioteca();

                // Adicionar livros ao catálogo
                Livros livro1 = new Livros("Dom Quixote", "Miguel de Cervantes", "ISBN1");
                Livros livro2 = new Livros("1984", "George Orwell", "ISBN2");
                Livros livro3 = new Livros("Apanhador no Campo de Centeio", "J.D. Salinger", "ISBN3");

                biblioteca.adicionarLivro(livro1);
                biblioteca.adicionarLivro(livro2);
                biblioteca.adicionarLivro(livro3);

                // Reservar um livro (livro1)
                boolean reserva1 = livro1.reservar();
                System.out.println("Reserva do Livro 1: " + reserva1);

                // Devolver um livro (livro2)
                livro2.devolver();
                System.out.println("Status de empréstimo do Livro 2 após devolução: " + livro2.isEmprestado());

                // Buscar livros por título
                String tituloBuscado = "Dom Quixote";
                List<Livros> livrosEncontrados = biblioteca.buscarPorTitulo(tituloBuscado);

                System.out.println("\nLivros encontrados com o título \"" + tituloBuscado + "\":");
                for (Livros livro : livrosEncontrados) {
                    System.out.println(livro.exibirInfo());
                }

                // Emprestar um livro (livro3)
                boolean emprestado = biblioteca.emprestarLivro("ISBN3");
                System.out.println("Empréstimo do Livro 3 bem-sucedido: " + emprestado);

                // Devolver um livro (livro3)
                biblioteca.devolverLivro("ISBN3");

                // Listar todos os livros no catálogo
                System.out.println("\nLista de todos os livros no catálogo:");
                List<Livros> todosLivros = biblioteca.listarLivros();
                for (Livros livro : todosLivros) {
                    System.out.println("================");
                    System.out.println(livro.exibirInfo());
                }

                // Listar os livros emprestados
                System.out.println("\nLista de livros emprestados:");
                List<Livros> livrosEmprestados = biblioteca.listarLivrosEmprestados();
                for (Livros livro : livrosEmprestados) {
                    System.out.println(livro.exibirInfo());
                }
            }
        }












