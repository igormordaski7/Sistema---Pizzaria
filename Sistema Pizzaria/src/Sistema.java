import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
                gerarPedido();
                break;
            case 2:
                // ExibirCardapio();
                break;
            case 3:
                // ListarPedidos();
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

        public static void gerarPedido() {
        
            Pedidos pedido = new Pedidos();
            boolean continuar = true;
    
            while (continuar) {
                System.out.println("Menu:");
                System.out.println("1. Adicionar Pizza");
                System.out.println("2. Adicionar Bebida");
                System.out.println("3. Finalizar Pedido");
                int escolha = Console.lerInt("Escolha uma opção: ");

                switch (escolha) {
                    case 1:
                    int pizzaEscolha = Console.lerInt("\nEscolha uma pizza pelo número (1-20): ");
                    int tamanhoPizza = Console.lerInt("\nEscolha o tamanho da pizza (1-5): ");
                    boolean pizzaAdicionada = Metodos.selecionarPizza(pizzaEscolha, tamanhoPizza, pedido);

                    try {
                        if (pizzaAdicionada) {
                            System.out.println("\nPizza adicionada ao pedido com sucesso!");
                        }
                    } catch (Exception e) {
                            System.out.println("Não foi possível adicionar a pizza no pedido!" + e.getMessage());
                    } break;


                    case 2: 
                    int bebidaEscolha = Console.lerInt("\nEscolha uma bebida pelo número (1-15): ");
                    Bebidas bebidaAdicionada = Metodos.selecionarBebida(bebidaEscolha, pedido);
                    
                    try {
                        if (bebidaAdicionada != null) {
                        System.out.println("\nBebida adicionada ao pedido!");
                    
                    }} catch (Exception e) {
                        System.out.println("\nEscolha de bebida inválida. A bebida não foi adicionada.");
                    } break;

                    case 3:
                    System.out.println("\n======= Dados do Pedido =======");
                    System.out.println("\nNúmero do Pedido: " + pedido.getNumeroPedido());

                    // Mostrar bebidas, se houver
                    List<Bebidas> bebidas = pedido.getBebidas();
                    if (!bebidas.isEmpty()) {
                        System.out.println("\nBebidas:");
                        for (Bebidas bebida : bebidas) {
                            System.out.println("- " + bebida.getNome() + ": R$ " + String.format("%.2f", bebida.getPreco()));
                        }
                    }

                    // Mostrar pizzas, se houver
                    List<Pizza> pizzas = pedido.getPizzas();
                    if (!pizzas.isEmpty()) {
                        System.out.println("\nPizzas:");
                        for (Pizza pizza : pizzas) {
                            System.out.println("- " + pizza.getNome() + ": R$ " + String.format("%.2f", pizza.getPreco()));
                            System.out.println("  Ingredientes:");
                            System.out.println("    Massa: " + pizza.getMassa().getNome());
                            System.out.println("    Molho: " + pizza.getMolho().getNome());
                            for (Ingredientes recheio : pizza.getRecheios()) {
                                System.out.println("    Recheio: " + recheio.getNome());
                            }
                            System.out.println("  Tamanho: " + pizza.getTamanho());
                            System.out.println("  Tempo de Preparo: " + pizza.getTempPreparo() + " minutos");
                        }
                    }

                    // Mostrar preço total do pedido
                    System.out.println("\n===============================");
                    System.out.println("Preço Total: R$ " + String.format("%.2f", pedido.getPrecoTotal()));
                    System.out.println("Tempo de Preparo: " + pedido.getTempoPedido() + " minutos");
                    System.out.println("===============================");

                    String confirmacaoPagamento = Console.lerString("Deseja confirmar o pagamento? (Digite 'sim' para confirmar): ");
                if ("sim".equalsIgnoreCase(confirmacaoPagamento.trim())) {
                    System.out.println("\nPagamento realizado com sucesso! Recibo disponível.");
                    // Caso afirmativo, gerar recibo
                    String caminhoArquivo = "recibo.txt"; // Especificar o caminho desejado
                    gerarRecibo(pedido, caminhoArquivo);
                }
                break;

                }
    }
    }

    public static void gerarRecibo(Pedidos pedido, String caminhoArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            writer.write("\nRecibo do Pedido\n");
            writer.write("================\n");
            writer.write("Número do Pedido: " + pedido.getNumeroPedido() + "\n");
            writer.write("Bebidas:\n");
            for (Bebidas bebida : pedido.getBebidas()) {
                writer.write("- " + bebida.getNome() + ": R$ " + String.format("%.2f", bebida.getPreco()) + "\n");
            }
            writer.write("Pizzas:\n");
            for (Pizza pizza : pedido.getPizzas()) {
                writer.write("- " + pizza.getNome() + ": R$ " + String.format("%.2f", pizza.getPreco()) + "\n");
                writer.write("  Ingredientes:\n");
                writer.write("    Massa: " + pizza.getMassa().getNome() + "\n");
                writer.write("    Molho: " + pizza.getMolho().getNome() + "\n");
                for (Ingredientes recheio : pizza.getRecheios()) {
                    writer.write("    Recheio: " + recheio.getNome() + "\n");
                }
                writer.write("  Tamanho: " + pizza.getTamanho() + "\n");
                writer.write("  Tempo de Preparo: " + pizza.getTempPreparo() + " minutos\n");
            }
            writer.write("================\n");
            writer.write("Preço Total: R$ " + String.format("%.2f", pedido.getPrecoTotal()) + "\n");
            writer.write("Tempo de Preparo: " + pedido.getTempoPedido() + " minutos\n");
            writer.write("================\n");
            writer.write("Obrigado por sua compra!");
        } catch (IOException e) {
            System.err.println("Erro ao gerar recibo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        gerarPedido();
    }
}