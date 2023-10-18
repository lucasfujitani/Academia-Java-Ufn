import java.util.List;

 abstract class Produto {
    private String nome;
    private String categoria;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, String categoria, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void vender(int quantidade) {
        if (quantidade <= quantidadeEmEstoque) {
            quantidadeEmEstoque -= quantidade;
            System.out.println("Venda realizada: " + quantidade + "x " + nome);
        } else {
            System.out.println("Estoque insuficiente para " + nome);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public static void listarProdutosDisponiveis(List<Produto> produtosDisponiveis) {
        System.out.println("Produtos disponíveis:");
        for (Produto produto : produtosDisponiveis) {
            System.out.println(produto.getNome() + ": " + produto.getQuantidadeEmEstoque() + " em estoque");
        }
    }
}