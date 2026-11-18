# Avaliação P2 de Estruturas de Dados

## Documento Técnico – Controle de Check-in de Aeroporto

---

## 1. Identificação do Projeto

| Campo | Informação |
|---|---|
| Projeto | Controle de Check-in de Aeroporto |
| Disciplina | Estruturas de Dados |
| Integrantes | Murilo Silva Dantas; Melissa Martins Libanio; Laura De Melo |
| Estrutura de dados | Fila adaptada da Lista Dupla (Lista Duplamente Ligada) |
| Linguagem / Ambiente | Java, projeto ListaDuplamenteLigada |
| Data | 18/11/2026 |

## 2. Descrição do Problema

Em um aeroporto, os passageiros chegam ao balcão de check-in e aguardam atendimento. O atendimento deve respeitar a ordem de chegada: o primeiro passageiro a entrar na fila é o primeiro a ser atendido (FIFO – *First In, First Out*). O sistema desenvolvido controla essa fila, permitindo cadastrar o passageiro que chega, atender o próximo, consultar quem é o próximo e acompanhar quantos passageiros ainda aguardam.

## 3. Estrutura de Dados Utilizada

### 3.1 Da Lista Dupla para a Fila

O projeto base fornecido possuía uma lista duplamente ligada, formada pelas classes **Lista** e **No**, que armazenava apenas um nome. Essa lista foi transformada na classe **ListaDupla**, e o nó passou a guardar um objeto **Passageiro**, além das referências *ant* (nó anterior) e *prox* (próximo nó). A classe **Fila** foi adaptada a partir da **ListaDupla**: a fila utiliza uma lista e restringe o acesso a ela, de modo que o passageiro sempre **entra pelo fim** e **sai pelo início**.

### 3.2 Principais alterações em relação ao projeto base

Foram acrescentados à lista o controle do tamanho (atributo *tamanho*), o método *removerInicio*, o método *consultarInicio* e o método *listar*, que percorre a estrutura do início ao fim. O atributo auxiliar *aux*, que apenas repetia o papel do atributo *fim*, foi eliminado. O método de inserção foi renomeado para *inserirFim*, deixando claro onde o nó é incluído. Não foi utilizada nenhuma API do Java que implemente estruturas de dados.

### 3.3 As cinco operações básicas da fila

| Operação | Método da Fila | Método da ListaDupla usado | Descrição |
|---|---|---|---|
| Enfileirar | `enfileirar(Passageiro)` | `inserirFim` | Insere o passageiro no fim da fila. |
| Desenfileirar | `desenfileirar()` | `removerInicio` | Remove e devolve o passageiro do início (null se vazia). |
| Primeiro | `primeiro()` | `consultarInicio` | Devolve o passageiro do início sem removê-lo. |
| Vazia | `vazia()` | `vazia` | Informa se não há passageiros aguardando. |
| Tamanho | `tamanho()` | `getTamanho` | Informa quantos passageiros estão na fila. |

Todas as operações executam em tempo constante, pois a lista mantém referências diretas para o início e para o fim, sem necessidade de percorrer os nós. Apenas a exibição completa da fila percorre todos os elementos.

## 4. Organização do Código

O projeto segue a estrutura obrigatória solicitada:

```text
src/
├── modelo/
│   └── Passageiro.java
├── estrutura/
│   ├── No.java
│   ├── ListaDupla.java
│   └── Fila.java
└── Principal.java
```

### modelo

A classe **Passageiro** representa o domínio do problema. Possui *id* (gerado automaticamente em ordem crescente), *nome*, *documento*, *voo* e *destino*, com construtor, métodos *get*/*set* e *toString*.

### estrutura

A classe **No** guarda um passageiro e as referências para o nó anterior e o próximo. A classe **ListaDupla** implementa a lista duplamente ligada com início, fim e tamanho. A classe **Fila** aplica a regra FIFO sobre a lista e oferece as cinco operações básicas, além do método *exibir*, usado para mostrar todos os passageiros aguardando.

### Principal

A classe **Principal** contém o método *main* e o menu em modo texto, repetido até o usuário escolher a opção 0, com a escolha tratada por *switch/case*. Ela apenas lê os dados do teclado e chama a **Fila**; a regra da estrutura fica toda no pacote *estrutura*.

## 5. Funcionalidades e Demonstração

O menu oferece as opções: **1** – entrar na fila (enfileirar); **2** – atender o próximo passageiro (desenfileirar); **3** – consultar o próximo da fila; **4** – verificar se a fila está vazia; **5** – quantidade de passageiros na fila; **6** – exibir a fila completa; **0** – sair. Nos prints a seguir, o menu foi omitido nas repetições para facilitar a leitura.

### 5.1 Menu e fila vazia

![Figura 1 – Menu inicial e operações com a fila vazia (opções 4, 2 e 3)](prints/01_menu_e_fila_vazia.png)

*Figura 1 – Menu inicial e operações com a fila vazia (opções 4, 2 e 3).*

### 5.2 Enfileirar passageiros

![Figura 2 – Entrada de três passageiros na fila (opção 1)](prints/02_enfileirar_passageiros.png)

*Figura 2 – Entrada de três passageiros na fila (opção 1).*

### 5.3 Exibir a fila, consultar o primeiro e ver o tamanho

![Figura 3 – Opções 6, 3 e 5](prints/03_exibir_primeiro_tamanho.png)

*Figura 3 – Opções 6, 3 e 5: a ordem de chegada é mantida e o primeiro é Ana Souza.*

### 5.4 Atender passageiro (desenfileirar)

![Figura 4 – Opção 2 atende Ana Souza](prints/04_desenfileirar_e_fila_atual.png)

*Figura 4 – Opção 2 atende Ana Souza (primeiro a chegar); a fila passa a começar por Bruno Lima.*

### 5.5 Opção inválida e saída

![Figura 5 – Tratamento de opção inválida e encerramento do programa](prints/05_opcao_invalida_e_sair.png)

*Figura 5 – Tratamento de opção inválida e encerramento do programa.*

## 6. Conclusão

A adaptação da lista duplamente ligada para uma fila mostrou-se adequada ao problema do check-in: a regra FIFO é garantida ao inserir sempre no fim e remover sempre do início, e as operações têm custo constante. A separação em pacotes (modelo, estrutura e principal) deixou cada classe com uma única responsabilidade, o que facilita a manutenção e a reutilização da estrutura em outros domínios. Os testes realizados com a fila vazia, com vários passageiros e com opção inválida confirmaram o funcionamento correto das cinco operações obrigatórias.
