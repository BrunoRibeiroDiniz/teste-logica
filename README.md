# teste-logica

Atividade 1: Realizada em Java Script, com uma interface simples que permite a inserção da palavra a ser analisada e a escolha dos parâmetros adicionais: ignorar case sensitive e ignorar espaços. Foram feitas duas funções de verificação:
                  1- Utilizando a função reverse para inverter a palavra e depois comparando as duas
                  2- Loop percorrendo a palavra das extremidades até o meio, comparando cada caractere
                  
Atividade 2: Realizada em Java, foi utilizado um HashMap para guardar as frases do arquivo. A cada linha de leitura, a string resultante é separada por pipes e adicionada ao HashMap caso não exista,se já existir, seu valor de frequência é incrementado. Então, basicamente temos {chave, valor} sendo a chave a frase e o valor o número de ocorrências.
Após montado o HashMap, o mesmo precisou ser ordenado inversamente, para que fossem exibidas primeiramente as frases que possuem maior frequência. O loop para a exibição das frases foi configurado para exibir as 50000 mais frequentes, como foi mencionado no exemplo da descrição da atividade.
