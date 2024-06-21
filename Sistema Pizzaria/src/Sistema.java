public class Sistema {

    private static int proximoIdPizza = 1;
    private static int proximoIdPedido = 1;

    public static void executarSistema() {
        boolean executando = true;

        while (executando) {
            exibirMenu();
            int opcao = Console.lerInt("Digite a opção desejada: ");
            verificarOpcao(opcao);
        }
    }

    private static void exibirMenu() {
        System.out.println("\n### Sistema de Pizzaria ###");
        System.out.println("1. Realizar Pedidos");
        System.out.println("2. Exibir Cardápio");
        System.out.println("3. Listar pedidos realizados");
        System.out.println("4. Sair");
    }

    private static void verificarOpcao(int op) {
        switch (op) {
            case 1:
                RealizarPedido();
                break;
            case 2:
                ExibirCardapio();
                break;
            case 3:
                ListarPedidos();
                break;
            case 4:
            System.out.println("Saindo do sistema...");
            System.exit(0);
            break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    private static void RealizarPedido() {
        System.out.println("\n### Cadastro de Nova Pizza ###");
        String nome = Console.lerString("Digite o nome da pizza: ");
        float preco = Console.lerFloat("Digite o preço da pizza: ");

        // Simulação de cadastro
        System.out.println("Pizza cadastrada com sucesso!");
        proximoIdPizza++;
    }

    private static void ExibirCardapio() {
        System.out.println("\n### Listagem de Pizzas ###");
        System.out.println("Aqui deveria listar todas as pizzas cadastradas.");

        // Simulação de listagem
        System.out.println("Nenhuma pizza cadastrada.");
    }

    private static void ListarPedidos() {
        System.out.println("\n### Realização de Pedido ###");


        // Simulação de realização de pedido
        System.out.println("Pedido realizado com sucesso!");
        proximoIdPedido++;

        // Simulação de listagem
        System.out.println("Nenhum pedido realizado.");
    }
}