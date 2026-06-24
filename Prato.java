public class Prato{
private String nome; 
private double valor;
private Ingrediente[] vetIngredientes;
private int index; //inserções e remoções

public Prato(String nome, double valor, int quantidadeIngrediente){
    this.nome = nome;
    this.valor = valor; 
    this.vetIngredientes = new Ingrediente[quantidadeIngrediente]; //criei um vetor de ingredientes que comporta até x quantidade
    this.index = 0; 
}
public boolean adicionarIngrediente(Ingrediente ingrediente){
    if(index<vetIngredientes.length){
        vetIngredientes[index]= ingrediente;
        index++;
        return true;
    }
    else{
        return false; 
    }
}
//ESPAÇO PRA ADICONAR A B  
public boolean removerIngrediente(String nomeIngrediente){
    for(int i =0; i<index;i++){
        if(vetIngredientes[i].getNome().equalsIgnoreCase(nomeIngrediente)){
            for(int j = i; j<index-1;j++){
            vetIngredientes[j] = vetIngredientes[j+1];
            }
            index--; 
            vetIngredientes[index] = null;
            return true;

        } 
    }
//ESPAÇO PARA ADICIONAR O D     
        return false; 
 }     
}
