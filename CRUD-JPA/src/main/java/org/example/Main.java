package org.example;
import javax.persistence.EntityManager;  // Importa EntityManager, usado para interagir com o contexto de persistência.
import javax.persistence.EntityManagerFactory;  // Importa EntityManagerFactory, que cria instâncias de EntityManager.
import javax.persistence.Persistence;
import java.util.Scanner;



public class Main {public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myJPAUnit");
    EntityManager em = emf.createEntityManager();

    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Escolha uma operação:");
        System.out.println("1. Inserir um Cliente");
        System.out.println("2. Ler um Cliente");    
        System.out.println("3. Atualizar um Cliente");
        System.out.println("4. Excluir um Cliente");
        System.out.println("0. Sair");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer de entrada

        switch (choice) {
            case 1:
                // Operação de criação (Create)
                System.out.println("Digite o nome do cliente: ");
                String nome = scanner.nextLine();
                System.out.println("Digite o email do cliente: ");
                String email = scanner.nextLine();
                System.out.println("Digite o endereço do cliente: ");
                String endereco = scanner.nextLine();

                em.getTransaction().begin();
                Cliente novoCliente = new Cliente(null, nome, email, endereco);
                em.persist(novoCliente);
                em.getTransaction().commit();
                System.out.println("Cliente inserido com sucesso!");
                break;

            case 2:
                // Operação de leitura (Read)
                System.out.println("Digite o ID do cliente a ser lido: ");
                Long  id = scanner.nextLong();

                em.getTransaction().begin();
                Cliente cliente = em.find(Cliente.class, id);
                em.getTransaction().commit();

                if (cliente != null) {
                    System.out.println("Cliente encontrado: " + cliente);
                } else {
                    System.out.println("Cliente não encontrado.");
                }
                break;

            case 3:
                System.out.println("Digite o ID do cliente a ser atualizado: ");
                long clienteId = scanner.nextLong();
                scanner.nextLine(); // Limpa o buffer de entrada

                em.getTransaction().begin();
                Cliente clienteParaAtualizar = em.find(Cliente.class, clienteId);
                if (clienteParaAtualizar != null) {
                    System.out.println("Digite o novo nome (ou deixe em branco para manter o valor atual): ");
                    String novoNome = scanner.nextLine();
                    if (!novoNome.isEmpty()) {
                        clienteParaAtualizar.setNome(novoNome);
                    }

                    System.out.println("Digite o novo email (ou deixe em branco para manter o valor atual): ");
                    String novoEmail = scanner.nextLine();
                    if (!novoEmail.isEmpty()) {
                        clienteParaAtualizar.setEmail(novoEmail);
                    }

                    System.out.println("Digite o novo país (ou deixe em branco para manter o valor atual): ");
                    String novoPais = scanner.nextLine();
                    if (!novoPais.isEmpty()) {
                        clienteParaAtualizar.setPais(novoPais);
                    }

                    em.getTransaction().commit();
                    System.out.println("Cliente atualizado com sucesso!");
                } else {
                    em.getTransaction().rollback();
                    System.out.println("Cliente não encontrado. A transação foi cancelada.");
                }
                break;


            case 4:
                // Operação de exclusão (Delete)
                System.out.println("Digite o ID do cliente a ser excluído: ");
                Long clienteParaExcluirId = scanner.nextLong();

                em.getTransaction().begin();
                Cliente clienteParaExcluir = em.find(Cliente.class, clienteParaExcluirId);
                if (clienteParaExcluir != null) {
                    em.remove(clienteParaExcluir);
                    em.getTransaction().commit();
                    System.out.println("Cliente excluído com sucesso!");
                } else {
                    em.getTransaction().rollback();
                    System.out.println("Cliente não encontrado. A transação foi cancelada.");
                }
                break;

            case 0:
                // Encerrar o programa
                em.close();
                emf.close();
                System.exit(0);

            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                break;
        }
    }


}
}
