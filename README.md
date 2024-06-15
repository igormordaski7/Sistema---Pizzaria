# Sistema---Pizzaria


Console.java
- leitura de dados

Principal.java
- metodo main chamando classe menu

Sistema.java
- switch case chamando as funções de cada opção do menu

Bebidas.java
- uma lista de bebidas com poucas opções só pra ter

Ingredientes.java
- todos os ingredientes com os atributos tempo de preparo e custo

Pizza.java
- todos os sabores de pizza com os atributos ingredientes, cujo tempo de preparo é a soma dos atributos tempo de preparo e custos dos ingredientes.

Pedidos.java
- superclasse contendo x objetos pizza e y objetos bebidas, ele gera um array list com a lista de nomes dos itens selecionados, um array list com os preços individuiais dos itens, e um método que calcula o preço total somando todos os preços

Metodos.java
- classe com os métodos chamados no menu como "customizar pizza" que mostra todos os ingredientes e calcula o tepo de preparo e o custo da pizza e "cardapio" que mostra todo os sabores de pizza
