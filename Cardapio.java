public class Cardapio{
    private Prato[] vetPratos;
    private int index;

    public Cardapio(int quantidadePratos){
        this.index = 0;
        this.vetPratos = new Prato[quantidadePratos];

    }
    public boolean adicionarPrato(Prato prato){
        if(index < vetPratos.length){
            vetPratos[index]=prato;
            index++;
            return true;
        }
        return false;
    }
    public boolean removerPrato(String nomePrato){
        for(int i =0; i<index; i++){
            if(vetPratos[i].getNome().equalsIgnoreCase(nomePrato)){
                for(int j =i; j< index - 1; j++){ //comecar em i pois e onde o ingrediente a ser removido esta
                    vetPratos[j] = vetPratos[j + 1]; //tirou o ingrediente anterior

                }
                index--;
                vetPratos[index] = null;
                return true;
            }
        }
        return false;
    }
    
    public Prato buscarPratoPorNome(String nomePrato){
        for (int i = 0; i < index; i++) {
            if (vetPratos[i].getNome().equalsIgnoreCase(nomePrato)){
                return vetPratos[i];
            }
        } return null;
    }

    public int buscarPosicao(Prato prato){
        for (int i = 0; i < index; i++) {
            if (vetPratos[i].getNome().equalsIgnoreCase(prato.getNome())){
                return i;
            }
        }
        return -1;
    }
    
    public Prato[] buscarPratoIngrediente(String nomeIngrediente){
        int tamanho = 0; 
        for(int i =0; i<index;i++){
            if(vetPratos[i].consultarIngrediente(nomeIngrediente)!= null){ //se tiver um ingrediente com esse nome , ou seja, não estiver vazio, então tem um prato com esse ingrediente
                tamanho++; 
            }
        }
        Prato[] pratosIngrediente = new Prato[tamanho]; 
        int j =0; //pois i e j não lidaram sempre com o mesmo objeto no vetor; 
        for(int i =0; i<index;i++){
            if(vetPratos[i].consultarIngrediente(nomeIngrediente)!= null){ //se tiver um ingrediente com esse nome , ou seja, não estiver vazio, então tem um prato com esse ingrediente
                pratosIngrediente[j] = vetPratos[i];  
                j++; 
            }
        }
        return pratosIngrediente;
    }
    public double buscarValorCardapio(){
        double somatorio = 0;
        for (int i = 0; i < index; i++) {
            somatorio += vetPratos[i].getValor();
        }
        return somatorio;
    }

    public Prato buscarPratoEconomico(){
        Prato achou = null;
        double menor = Double.MAX_VALUE;
        for (int i = 0; i < index; i++) {
           if (vetPratos[i].getValor() < menor){
              achou = vetPratos[i];
              menor = vetPratos[i].getValor();
           }
        }
        return achou;
    }

    public void mostrarPratos(){
        if(index==0){
        System.out.println("Não há pratos no cardápio!"); //caso não existam pratos ainda
        }else{
          for (int i = 0; i < index; i++) {
            System.out.println(vetPratos[i].getNome() + "| R$" + vetPratos[i].getValor()); 
            Ingredientes[] vet = vetPratos[i].getVetIngredientes(); 
            for(int j =0; j< vet.length; j++){
                if(vet[j] != null){
                    System.out.println(" - " + vet[j].getNome()+ "|" + vet[j].getQuantidade() + "|" + vet[j].getMedida()+"|"); 
                    //pois cada prato pode ter mais de um ingrediente, então devemos percorrer o vetor de ingredientes desse prato
                }
            }
          }
        }
    }
}       