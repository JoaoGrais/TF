README.TXT — Trabalho Final — Fundamentos de Programação — Turma 15

================================================================================

1. NOME E NÚMERO DE MATRÍCULA DOS MEMBROS

> João Pedro Everling Gonçalves — 26108132
> João Guilherme Grais Dias — 26111282
> Juliano Rafael Dorneles Nunes — 26103698

================================================================================

2. LINK PARA O VÍDEO NO YOUTUBE

https://youtu.be/yJ9yf3_DStg

================================================================================

3. FONTES DE CONSULTA E AJUDA UTILIZADAS

As principais fontes de consulta que utilizamos para elaborar o programa foram as
listas de exercícios providenciadas pela professora, especialmente:

5.1) Semana 12 (25-29/05) — Vetores e Vetores de Objetos:
  As listas de exercícios em geral nos ajudaram a entender melhor o funcionamento
  de vetores e como manipulá-los.

5.2) Semana 13 (01-05/06) — Vetores de Objetos:
  Em especial o exercício do "Bichos", que foi uma referência importante para
  entendermos como gerenciar vetores de objetos com inserção e remoção.

5.3) Semana 14 (08-12/06) — Vetores de Objetos:
  Em especial as listas 2 e 3, sendo que o exercício do "Caminhão" (lista 3)
  teve grande impacto no desenvolvimento do trabalho, servindo como base para a
  estrutura de gerenciamento de vetores que usamos nas classes Prato e Cardapio.
  A estrutura do Caminhão também nos auxiliou diretamente na formulação das
  classes Cardapio e Application, especialmente na organização do menu e nas
  chamadas de métodos.

5.4) Colega Renan Bernardo da Silva:
  Nos deu um auxilio inicial para contextualizar a estrutura geral do sistema,
  o que ajudou  na hora de definir como organizar as classes Ingrediente,
  Prato e Cardapio antes de começarmos a desenvolver.

5.5) Claude (claude.ai) — Inteligência Artificial:
  Utilizamos para revisar e corrigir o código. Detalhes no tópico 4.

================================================================================

4. INTELIGÊNCIA ARTIFICIAL UTILIZADA

Ferramenta: Claude (Anthropic) — https://claude.ai

Usamos o Claude para revisar e corrigir o código que desenvolvemos.

O Claude foi usado como apoio para revisar erros de lógica e execução, verificar
o funcionamento do programa em diferentes cenários e identificar problemas que
passaram despercebidos durante o desenvolvimento. O objetivo não foi gerar código
pronto, mas sim entender o porquê dos erros e corrigi-los.

No que nos auxiliou:
4.1) Revisão dos métodos da classe Prato, identificando erros como o
  getQuantidadeIngrediente que retornava endereço de memória em vez do vetor,
  e a ausência dos modificadores private nos atributos
4.2) Identificação do erro de índice no loop de reorganização do removerIngrediente,
  onde i estava sendo usado no lugar de j
4.3) Correção do produtoLinha que estava inicializado com 0 em vez de 1, o que
  fazia o resultado ser sempre zero
4.4) Identificação da confusão entre String e objeto Prato no case 4 da Application
4.5) Realização de testes simulados de todos os casos do menu, identificando que o
  case 6 poderia causar um NullPointerException com o cardápio vazio, e que o
  switch não tratava opções inválidas
4.6) Auxílio na compreensão e implementação do método buscarPratoIngrediente, cujo
  enunciado continha um erro de redação

Sequência de prompts utilizada:

1. "Estou fazendo meu TF, no momento estou na parte de adicionar os métodos na
   classe Prato, poderia conferir?" — abertura da revisão do TF

2. Envio do método removerIngrediente > o Claude identificou o erro no loop de
   reorganização (i no lugar de j)

3. Envio completo da classe Prato > Claude identificou que os atributos estavam
   sem modificadores de acesso e deveriam ser declarados como private, garantindo
   que o index, controlador interno, só pudesse ser acessado pela
   própria classe. Além disso, o getter do vetor de ingredientes estava tentando
   retornar um item específico usando uma variável inexistente no escopo
   (quantidadeIngrediente), quando o correto era retornar o vetor inteiro. Por
   fim, os métodos consultarIngrediente e buscarPosicao estavam usando .equals()
   no lugar de .equalsIgnoreCase(), o que tornava as buscas sensíveis a
   maiúsculas e minúsculas.

4. Dúvida sobre o método buscarPratoIngrediente > o Claude explicou o erro de
   redação no enunciado e como implementar corretamente

5. Envio das classes Cardapio e Application completas > o Claude realizou testes
   simulados de todos os casos do menu e identificou os problemas no case 6 e
   ausência do default no switch

6. Envio das versões corrigidas > aprovação final

================================================================================

5. LIÇÕES APRENDIDAS

5.2) Aprendemos como inicializar variáveis corretamente importa muito na prática:
  descobrimos que produto = 0 em um método de multiplicação sempre retornava zero,
  e que Double.MAX_VALUE é a forma correta de inicializar uma variável quando
  queremos buscar o menor valor de um conjunto.

5.3) Entendemos melhor o papel do index no gerenciamento de vetores: ele não apenas
  controla quantos elementos foram inseridos, mas é essencial para garantir que
  inserções, remoções e reorganizações ocorram de forma correta e segura, evitando
  acessos a posições nulas ou fora dos limites.

5.4) Compreendemos na prática a importância dos modificadores de acesso (private,
  public), especialmente no caso do index, que por ser um controlador interno
  crítico deve ser acessível apenas pela própria classe, protegendo a integridade
  dos dados.

5.5) Aprendemos como separar responsabilidades entre classes, mantendo cada uma com
  seu papel bem definido no sistema, o que tornou o código mais organizado e
  fácil de manter.

5.6) Entendemos a diferença entre retornar um objeto e retornar um endereço de
  memória, algo que descobrimos ao corrigir o getter do vetor de ingredientes.

5.7) Percebemos como é importante tratar casos extremos, como cardápio vazio ou
  opções inválidas no menu, para garantir que o programa não quebre em nenhuma
  situação.

================================================================================

6. DIFICULDADES ENCONTRADAS E COMO AS SUPERAMOS

6.1) Reorganização do vetor após remoção:
  Tivemos dificuldade em implementar corretamente o loop de reorganização no
  removerIngrediente, pois acabamos usando o índice i no lugar de j, o que fazia
  elementos errados serem sobrescritos. Superamos ao revisar a lógica com cuidado
  e entender que a reorganização precisa começar exatamente na posição do elemento
  removido.

6.2) Gerenciamento do index:
  Entender o papel do index como controlador interno do vetor foi desafiador no
  início, especialmente em situações de remoção, onde é necessário decrementá-lo
  e anular a última posição para evitar duplicatas. Superamos com a prática nos
  exercícios semanais, em especial o exercício do Caminhão.

6.3) Retorno incorreto do getter do vetor:
  Ao implementar o getter de vetIngredientes, o método tentava retornar um
  elemento específico usando uma variável que não existia no escopo, causando erro
  de compilação. Superamos ao entender a diferença entre retornar o vetor inteiro
  e retornar um elemento do vetor.

6.4) Confusão entre objeto e String no case 4:
  Ao implementar a busca do prato para adicionar ingrediente, declaramos como
  String a variável que deveria armazenar o objeto Prato, o que impedia a chamada
  dos métodos. Superamos ao entender a diferença entre guardar o nome do prato e
  guardar o objeto prato em si.

6.5) Tratamento de casos extremos:
  Inicialmente o programa poderia quebrar em situações como cardápio vazio ao
  buscar o prato econômico, ou ao receber uma opção inválida no menu. Superamos
  ao realizar testes sistemáticos de todos os casos e adicionar as verificações
  necessárias.
================================================================================
