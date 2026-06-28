public class Prato {
    private String nomePrato;
    private double valor;
    private int index;
    private Ingredientes[] vetIngredientes;

    public Prato(String nomePrato, double valor, int quantidadeIngrediente){
        this.nomePrato = nomePrato;
        this.valor = valor;
        this.vetIngredientes = new Ingredientes [quantidadeIngrediente];
        index = 0;
    }
    public void setNome(String nomePrato){
        this.nomePrato = nomePrato;
    }
    public void setValor(double valor){
        this.valor=valor;
    }
    public void setQuantidadeIngrediente(int quantidadeIngrediente){
        this.vetIngredientes =new Ingredientes[quantidadeIngrediente];
    }
    public String getNome(){
        return nomePrato;
    }
    public double getValor(){
        return valor;
    }
    public Ingredientes[] getVetIngredientes(){
        return vetIngredientes;
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
    public boolean removerIngrediente(String nomeIngrediente){
       for(int i =0; i<index; i++){
           if(vetIngredientes[i].getNome().equalsIgnoreCase(nomeIngrediente)){
             for(int j =i; j<index-1; j++){ //começar em i pois é onde o ingrediente a ser removido está
               vetIngredientes[j] = vetIngredientes[j+1]; //tirou o ingrediente anterior
               
             }
             index--;
             vetIngredientes[index] = null; 
             return true; 
           }
        }
        return false; 
    }
    public Ingredientes consultarIngrediente(String nome){
        for (int i = 0; i < index; i++) {
            if (vetIngredientes[i].getNome().equalsIgnoreCase(nome)){
                return vetIngredientes[i];
            }
        }
        return null;
    }
    public int buscarPosicao(String nome) {
        for (int i = 0; i < index; i++) {
            if (vetIngredientes[i].getNome().equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }
}
