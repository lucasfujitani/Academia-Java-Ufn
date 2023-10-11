public class Produto {
 private String nome;
 private String categoria;
 private double preço;
 private int quantidade;
/////////////////////////////

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
 //////////////////


    public Produto(String nome, String categoria, double preço, int quantidade) {
        this.nome = nome;
        this.categoria = categoria;
        this.preço = preço;
        this.quantidade = quantidade;
    }

///////////////////////

    public void vender(int vendas){
        if (getQuantidade() > vendas){
            setQuantidade(getQuantidade()- vendas);
            System.out.println("Venda realizada com sucesso.");
        }else {
            System.out.println("sem estoque");
        }

    }





}
