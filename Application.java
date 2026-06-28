import java.util.Scanner;

public class Application {
    public static void main(String[] args){
    int opcao =0; 
    Cardapio cardapio = new Cardapio(10);
    Scanner input = new Scanner(System.in);
        while(opcao !=10){
        System.out.println("*********************************************");
        System.out.println("Bem vindo ao Application! O que deseja fazer?");
        System.out.println("[1]Adicionar prato no cardápio" + 
                           "\n[2]Remover prato do cardápio" +
                           "\n[3]Consultar cardápio" +
                           "\n[4]Adicionar ingrediente no prato"+
                           "\n[5]Remover ingrediente do prato"+
                           "\n[6]Prato mais econômico" +
                           "\n[7]Pratos que contém um determinado ingrediente"+
                           "\n[8]Valor do cardápio do dia" +  
                           "\n[10]Sair do programa"); 
        System.out.println("*********************************************");
        opcao= input.nextInt();
        input.nextLine(); 
        switch(opcao){
            case 1:
                
                System.out.println("Acione um prato ao cardápio: ");
                System.out.println("Nome do prato: ");
                String nomePrato = input.nextLine(); 
                System.out.println("Qual o valor do prato? ");
                double valorPrato = input.nextDouble(); 
                input.nextLine(); 
                System.out.println("Quantos ingredientes terá no prato? "); 
                int quantidadeIngredientes = input.nextInt(); 
                input.nextLine(); 
                Prato pratoNovo = new Prato(nomePrato, valorPrato, quantidadeIngredientes); 
                if(cardapio.adicionarPrato(pratoNovo)){
                    System.out.println("Prato adicionado ao cardapio com sucesso!");
                }else{
                    System.out.println("Cardapio cheio, não foi possível adicionar o prato desejado");
                } 
            break;
            case 2:
                
                System.out.println("Removendo um prato do cardápio: ");
                System.out.println("Nome do prato a ser removido: ");
                String nomePratoRemover = input.nextLine(); 
                if(cardapio.removerPrato(nomePratoRemover)){
                    System.out.println("Prato removido do cardapio com sucesso!");
                }else{
                    System.out.println("Prato não encontrado, não foi possível remover o prato desejado");
                } 
            break;
            case 3:
                cardapio.mostrarPratos();
                System.out.println("*********************************************");
            break;
            case 4:
                System.out.println("A que prato você quer adicionar o ingrediente? Nome: ");
                String nomePratoBuscando = input.nextLine(); 
                Prato pratoBuscando = cardapio.buscarPratoPorNome(nomePratoBuscando); 
                if(pratoBuscando !=null){
                System.out.println("Adicione um ingrediente ao prato: "); 
                System.out.println("Nome do ingrediente: "); 
                String nomeIngrediente = input.nextLine(); 
                System.out.println("Quantidade a ser posta do ingrediente: "); 
                double quantidadeIngrediente = input.nextDouble();
                input.nextLine(); 
                System.out.println("Medida do ingrediente: "); 
                String medidaIngrediente = input.nextLine();
                Ingredientes ingredienteNovo = new Ingredientes(nomeIngrediente, quantidadeIngrediente, medidaIngrediente);
                if(pratoBuscando.adicionarIngrediente(ingredienteNovo)){
                    System.out.println(nomeIngrediente + " adicionado ao(a) " + nomePratoBuscando + " com sucesso!");
                }else{
                    System.out.println("Não foi possível adicionar o ingrediente ao prato, pois não há espaço disponível");
                }
              }else{
                System.out.println("Insira um nome de prato válido");
              }
                ; //ajuda
            break;
            case 5:
                System.out.println("De que prato você quer retirar o ingrediente?");
                String nomePratoBuscando2 = input.nextLine(); 
                Prato pratoBuscando2 = cardapio.buscarPratoPorNome(nomePratoBuscando2); 
                if(pratoBuscando2 !=null){
                 System.out.println("Remova um ingrediente do prato: "); 
                 System.out.println("Nome do ingrediente: "); 
                 String nomeIngrediente = input.nextLine();   
                 if(pratoBuscando2.removerIngrediente(nomeIngrediente)){
                   System.out.println("Ingrediente " + nomeIngrediente + " removido de " + nomePratoBuscando2 + " com sucesso!"); 
                 }else{
                   System.out.println("Não foi possível remover o ingrediente do prato! [Inexistente ou Nome Incorreto]");  
                 }
                }else{
                    System.out.println("Esse prato não existe no cardápio, ou o nome foi digitado incorretamente"); 
                }
            break;
            case 6: 
                
              Prato pratoEco = cardapio.buscarPratoEconomico(); 
                if(pratoEco != null){
                System.out.println(pratoEco.getNome() + "| R$" + pratoEco.getValor()); 
                Ingredientes[] vet = pratoEco.getVetIngredientes(); 
                for(int j =0; j< vet.length; j++){
                    if(vet[j] != null){
                        System.out.println(" - " + vet[j].getNome()+ "|" + vet[j].getQuantidade() + "|" + vet[j].getMedida()+"|"); 
                        //basicamente o mostrarPratos só que só pro Economico 
                    }
                }
               }else{
                System.out.println("Não há pratos no cardápio ou não existe um menor valor do prato no cardápio"); 
              } 
            break;
            case 7:
                System.out.println("Que ingrediente você deseja buscar? ");
                String nomeIngrediente2 = input.nextLine(); 
                Prato[] pratosIngrediente = cardapio.buscarPratoIngrediente(nomeIngrediente2);
                if(pratosIngrediente.length >0){ //pq se o vetor tiver vazio, ele tem tamanho 0, ou seja, se for maior do que zero, quer dizer que tem um prato que possui o ingrediente que se busca
              System.out.println("Pratos que possuem esse ingrediente: "); 
                for (int i = 0; i < pratosIngrediente.length; i++) {
                System.out.println( pratosIngrediente[i].getNome() + "| R$" +  pratosIngrediente[i].getValor()); 
                Ingredientes[] vet2 =  pratosIngrediente[i].getVetIngredientes(); 
                for(int j =0; j< vet2.length; j++){
                    if(vet2[j] != null){
                        System.out.println(" - " + vet2[j].getNome()+ "|" + vet2[j].getQuantidade() + "|" + vet2[j].getMedida()+"|"); 
                        //pois cada prato pode ter mais de um ingrediente, então devemos percorrer o vetor de ingredientes desse prato
                    }
                }
              }
             }else{
              System.out.println("Não existem pratos com esse ingrediente");  
            }
            break;
            case 8:
                System.out.println("O valor do cardápio hoje é de R$" + cardapio.buscarValorCardapio());
            break;
            case 10:
                break; 
            default: 
                System.out.println("Opção inexistente! Escolha uma opção válida.");
            break;
        }
    }
    System.out.println("Encerrando Application, obrigado por vir!"); 
    System.out.println("*********************************************");
}
}
