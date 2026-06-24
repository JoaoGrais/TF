public class Cardapio{
private Pratos[] vetPratos; 
private int index; 

public Cardapio(int quantidadePratos){
    this.index = 0;
    this.vetPratos = new Prats[quantidadePratos];

} 
public boolean adicionarPrato(Prato prato){
    if(index<vetPratos.length){
        vetPratos[index]=prato;
        index++;
        return true;
    }
    return false; 
}




}
