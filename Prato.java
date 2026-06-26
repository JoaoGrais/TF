public class Prato {
    String nomePrato;
    double valor;
    int index;
    Ingredientes[] vetIngredientes;

    public Prato(String nomePrato, double valor, int quantidadeIngrediente){
        this.nomePrato = nomePrato;
        this.valor = valor;
        this.vetIngredientes = new Ingredientes [quantidadeIngrediente];
        index = 0;
    }

    public boolean adicionarIngrediente(Ingredientes ingredientes){
        if (index < vetIngredientes.length){
            vetIngredientes[index] = ingredientes;
            index++;
            return true;
        } else {
            return false;
        }
    }

    public Ingredientes consultarIngrediente(String nome){
        for (int i = 0; i < index; i++) {
            if (vetIngredientes[i].getNome().equals(nome)){
                return vetIngredientes[i];
            }
        }
        return null;
    }

    public int buscarPosicao(String nome) {
        for (int i = 0; i < index; i++) {
            if (vetIngredientes[i].getNome().equals(nome)) {
                return i;
            }
        }
        return -1;
    }
}
