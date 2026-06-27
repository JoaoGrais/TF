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
                for(int j =i; j< index - 1; j++){ //come�ar em i pois � onde o ingrediente a ser removido est�
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
            if (vetPratos[i].getNome().equals(nomePrato)){
                return vetPratos[i];
            }
        } return null;
    }

    public int buscarPosicao(Prato prato){
        for (int i = 0; i < index; i++) {
            if (vetPratos[i].getNome().equals(prato.getNome())){
                return i;
            }
        }
        return -1;
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
        for (int i = 0; i < index; i++) {
            vetPratos[i].getNome();
            vetPratos[i].getValor();
            vetPratos[i].getVetIngredientes();
        }
    }
}
