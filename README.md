# Sistema de Pizzaria

## Descrição
Este sistema de pizzaria permite gerenciar um cardápio de pizzas, onde é possível adicionar diferentes tipos de massas, molhos e recheios. Os usuários podem se cadastrar, realizar login, visualizar o cardápio e fazer pedidos personalizados.

## Estrutura do Projeto

### Classes Principais
- **Sistema**: Controla o fluxo principal do sistema, gerencia os menus e ações do usuário.
- **Principal**: Contém o método `main` que inicia o sistema.
- **Pizza**: Representa uma pizza com massa, molho, recheios, preço e tempo de preparo. Permite adicionar recheios e calcular preço e tempo de preparo baseado no tamanho da pizza.
- **Recheio**: Classe abstrata para os diferentes tipos de recheios (doce e salgado).
- **RecheioDoce**: Herda de `Recheio` e define recheios doces.
- **RecheioSalgado**: Herda de `Recheio` e define recheios salgados.
- **GerenciarUsuario**: Gerencia os usuários, incluindo cadastro, login e salvamento de dados.
- **Usuario**: Representa um usuário do sistema.
- **Console**: Utilitário para leitura de dados do console.
- **Metodos**: Métodos auxiliares para exibir cardápio e selecionar itens.
- **Pedidos**: Representa um pedido realizado por um usuário.

### Estrutura de Diretórios
```
{{{{
    

AINDA NÃO ORGANIZAMOS A ESTRUTURA DE DIRETÓRIOS
ASSIM QUE ESTIVER FEITO INCLUIREMOS NESTE ESPAÇO

}}}}

### Classe Pizza
A classe `Pizza` é responsável por representar uma pizza, contendo os seguintes atributos e métodos:
- **Atributos**:
  - `nome`: Nome da pizza.
  - `massa`: Massa utilizada.
  - `molho`: Molho utilizado.
  - `recheios`: Lista de recheios.
  - `preco`: Preço da pizza.
  - `tempPreparo`: Tempo de preparo da pizza.
  - `tamanho`: Tamanho da pizza (1 a 5).

- **Métodos**:
  - `Pizza(String nome, Ingredientes massa, Ingredientes molho)`: Construtor que inicializa a pizza com nome, massa e molho.
  - `addRecheio(Ingredientes recheio)`: Adiciona um recheio à pizza e recalcula preço e tempo de preparo.
  - `setTamanho(int tamanho)`: Define o tamanho da pizza e recalcula preço e tempo de preparo.
  - `calcular()`: Calcula o preço e o tempo de preparo da pizza com base no tamanho e ingredientes.

### Classe Sistema
A classe `Sistema` gerencia o fluxo principal do programa e interações do usuário:
- **Métodos**:
  - `executarSistema()`: Inicia o loop principal do sistema.
  - `exibirMenuInicial()`: Exibe o menu inicial para usuários não logados.
  - `exibirMenuLogado()`: Exibe o menu para usuários logados.
  - `verificarOpcaoInicial(int op)`: Verifica e executa a opção escolhida no menu inicial.
  - `verificarOpcaoLogado(int op)`: Verifica e executa a opção escolhida no menu logado.
  - `realizarLogin()`: Realiza o login de um usuário.
  - `cadastrarUsuario()`: Cadastra um novo usuário.
  - `gerarPedido()`: Permite ao usuário gerar um pedido, adicionar pizzas e bebidas.

## Como Executar

1. **Compilar o código**:
   ```sh
   javac src/*.java -d out/
   ```

2. **Executar o programa**:
   ```sh
   java -cp out/ Principal
   ```

3. **Interagir com o sistema**:
   - No menu inicial, escolha entre realizar login, cadastrar usuário, exibir cardápio ou sair.
   - Após realizar login, você pode fazer pedidos, exibir cardápio, listar pedidos realizados, verificar histórico de pedidos ou sair.

## Pizzas Disponíveis
O sistema possui um conjunto de pizzas pré-definidas. Cada pizza possui uma massa, molho e uma lista de recheios. A seguir, estão alguns exemplos de pizzas disponíveis:

- **Calabresa Acebolada**: Massa m1, Molho m1, Recheios: calabresa, cebola, mussarela.
- **Quatro Queijos**: Massa m1, Molho m1, Recheios: mussarela, cheddar, provolone, parmesão.
- **Frango Crocante**: Massa m1, Molho m1, Recheios: frango, batata-palha.

Para uma lista completa das pizzas, consulte o código da classe `Pizza`.

## Customização de Pizzas
Os usuários podem customizar suas pizzas adicionando recheios extras e escolhendo o tamanho da pizza. O tamanho influencia no preço e tempo de preparo da pizza.

## Histórico de Pedidos
Os usuários logados podem visualizar o histórico de seus pedidos anteriores, facilitando a repetição de pedidos.

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para fazer um fork do projeto e enviar pull requests.
