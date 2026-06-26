public class Cardapio{
private Prato[] vetPratos; 
private int index; 

public Cardapio(int quantidadePratos){
    this.index = 0;
    this.vetPratos = new Prato[quantidadePratos];

} 
public boolean adicionarPrato(Prato prato){
    if(index<vetPratos.length){
        vetPratos[index]=prato;
        index++;
        return true;
    }
    return false; 
}
public boolean removerPrato(String nomePrato){
    for(int i =0; i<index; i++){
     if(vetPratos[i].getNome().equalsIgnoreCase(nomePrato)){
       for(int j =i; j<index-1; j++){ //começar em i pois é onde o ingrediente a ser removido está
          vetPratos[j] = vetPratos[j+1]; //tirou o ingrediente anterior
             
       }
       index--;
       vetPratos[index] = null; 
       return true; 
     }
    }
    return false; 
} 
public Prato buscarPratoPorNome(String nomePrato){}
public int buscarPosicao(Prato prato){}
public Prato[] buscarPratoIngrediente(String nomePrato){}
public double buscarValorCardapio(){}
public Prato buscarPratoEconomico(){}
public void mostrarPratos(){}




}
