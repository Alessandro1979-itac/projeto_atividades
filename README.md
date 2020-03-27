# Projeto Atividades
Este repositório contém setes atividades que estão descritas da seguinte forma:

## 1. Substituindo caracteres no local:

Dada um array de caracteres, escreva um método para substituir todos os espaços por "&32". Você pode assumir que o array possui slots suficientes no final para armazenar os caracteres adicionais e que você recebe o comprimento "verdadeiro" do array. (Por favor, execute esta operação no local sem outra estrutura auxiliar).

Exemplo:
Entrada: “Usuário não é permitido”, 19
Saída: "Usuário e 32 e 32 e não permitido"

Solução: [aqui] (/projeto_atividades/Questoes/QuestaoOne.kt)

##2. Verifique as palavras com letras desordenadas:

Nosso cérebro pode ler textos, mesmo que as letras sejam confusas, como a seguinte frase: "Você pode usar esse método para desaprovar as mensagens de erro". Dadas duas sequências, escreva um método para decidir se uma é uma permutação parcial da outra. Considere uma permutação parcial apenas se:

- A primeira letra não mudou de lugar
- Se a palavra tiver mais de 3 letras, até 2/3 das letras mudaram de lugar

Exemplos:
you, yuo -> true  
probably, porbalby -> true  
despite, desptie -> true  
moon, nmoo -> false  
misspellings, mpeissngslli -> false

Solução: [aqui] (/projeto_atividades/Questoes/QuestaoTwo.kt)

##3. Verifique as palavras com erros de digitação:

Existem três tipos de erros de digitação que podem ser executados em cadeias: inserir um caractere, remover um caractere ou substituir um caractere. Dadas duas sequências, escreva uma função para verificar se elas estão a um erro de digitação (ou zero erros de digitação).

Exemplos:
pale, ple -> true   
pales, pale -> true    
pale, bale -> true   
pale, bake -> false

Solução: [aqui] (/projeto_atividades/Questoes/QuestaoThree.kt)

##4. [Android] Pesquise em uma lista:

Escreva um aplicativo com uma atividade que mostre uma lista de itens e uma caixa de pesquisa. O usuário espera que a pesquisa retorne um resultado, mesmo que a palavra digitada seja parcialmente permutada ou tenha um erro de digitação (como explicado nos problemas anteriores), mas não os dois.

Solução: [App aqui] (/projeto_atividades/Questao_Four)

##5. Remova duplicatas no segmento de email:

Quando diferentes clientes de email são usados ​​no mesmo encadeamento, a discussão fica confusa porque as mensagens antigas são incluídas novamente e duplicadas. Dado um segmento de email (representado por uma lista vinculada de mensagens não classificada), escreva uma função que remova mensagens duplicadas.

Solução: [Aqui] (/projeto_atividades/Questoes/QuestaoFive.kt)

## 6. [Android] Serviço de processador de email:

Escreva um aplicativo com um serviço (sem atividades) que receba solicitações de outros aplicativos com um thread de email (como uma lista vinculada), aplique o algoritmo anterior e retorne uma versão mais limpa do mesmo thread de email. Solicitações simultâneas devem estar na fila.

Solução: [App serviço] (/projeto_atividades/QuestaoSix) e [Teste App serviço] (/projeto_atividades/QuestaoSixTest)

## 7. Interseção de lista vinculada:

Se duas solicitações na fila tiverem listas vinculadas que se cruzam (como o exemplo abaixo), o serviço anterior poderá ser aprimorado para processar apenas a diferença entre elas. Escreva um método que receba duas listas vinculadas individualmente e retorne o nó de interseção das duas listas (se existir). Observe que a interseção é definida por referência, não por valor.
(Não é necessário alterar a resposta anterior).

Solução: [Aqui] (/projeto_atividades/Questoes/QuestaoSeven.kt)

## Começando

Para executar o projeto, será necessário instalar os seguintes programas:

As Questões 1, 2, 3, 5 e 7 foram desenvolvidas no:
-[IntelliJ IDEA](https://www.jetbrains.com/idea/)

As Questões 4 e 6 foram desenvolvidas no:
-[Android Studio](https://developer.android.com/studio/?gclid=Cj0KCQjwyPbzBRDsARIsAFh15JYL1ugsy3lbx5zn72fUXvPrxI6jqXz2U2QTCR1ioXnNQSYMavaJW-IaAvcNEALw_wcB)

## Desenvolvimento

Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

```shell
cd "diretorio de sua preferencia"
git clone https://github.com/Alessandro1979-itac/projeto_atividades.git
```
