public class Ingredientes {
    String nome;
    double quantidade;

    public Ingredientes(String nome, double quantidade){
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public void setNome(String nome) {this.nome = nome;}
    public void setQuantidade(double quantidade) {this.quantidade = quantidade;}

    public String getNome() {return nome;}
    public double getQuantidade() {return quantidade;}

    public String toString() {
        return ("\n o nome do ingrediente é " + nome + "\n e a quantidade " + quantidade);
    }
}
