import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Sistema {

    private static GerenciarUsuario gerenciarUsuario = new GerenciarUsuario();
    private static Usuario usuarioLogado = null;

    public static void executarSistema() {

        boolean executando = true;

        while (executando) {
            if (usuarioLogado == null) {
                exibirMenuInicial();
            } else {
                exibirMenuLogado();
            }
            int opcao = Console.lerInt("Digite a opção desejada: ");
            if (usuarioLogado == null) {
                verificarOpcaoInicial(opcao);
            } else {
                verificarOpcaoLogado(opcao);
            }
        }
        gerenciarUsuario.salvarUsuarios();
    }

    private static void exibirMenuInicial() {
        
        System.out.println("\n--- Sistema de Pizzaria ---");
        System.out.println("1. Realizar Login");
        System.out.println("2. Cadastrar Usuário");
        System.out.println("3. Exibir Cardápio");
        System.out.println("4. Sair");
    }

    private static void exibirMenuLogado() {

        System.out.println("\n--- Sistema de Pizzaria ---");
        System.out.println("1. Realizar Pedidos");
        System.out.println("2. Exibir Cardápio");
        System.out.println("3. Listar Pedidos Realizados");
        System.out.println("4. Verificar Histórico de Pedidos");
        System.out.println("5. Sair");
    }

    private static void verificarOpcaoInicial(int op) {
        switch (op) {
            case 1:
                realizarLogin();
                break;
            case 2:
                cadastrarUsuario();
                break;
            case 3:
                Metodos.exibirCardapio();
                break;
            case 4:
                System.out.println("\nSaindo do sistema...");
                System.exit(0);
                break;
            default:
                System.out.println("\nOpção inválida. Tente novamente.");
                break;
        }
    }

    private static void verificarOpcaoLogado(int op) {
        switch (op) {
            case 1:
                gerarPedido();
                break;
            case 2:
                Metodos.exibirCardapio();
                break;
            case 3:
                listarPedidosRealizados();
                break;
            case 4:
                listarHistoricoPedidos();
                break;
            case 5:
                usuarioLogado = null;
                System.out.println("\nLogout realizado com sucesso.");
                break;
            default:
                System.out.println("\nOpção inválida. Tente novamente.");
                break;
        }
    }

    private static void realizarLogin() {

        System.out.print("\nDigite seu CPF: ");
        String cpf = Console.lerString();
        System.out.print("Digite sua senha: ");
        String senha = Console.lerString();

        Usuario usuarioEncontrado = gerenciarUsuario.realizarLogin(cpf, senha);
        if (usuarioEncontrado != null) {
            usuarioLogado = usuarioEncontrado;
            System.out.println("\nLogin realizado com sucesso.");
            usuarioLogado.carregarHistoricoPedidos(cpf);
        } else {
            System.out.println("\nCPF ou senha incorretos. Tente novamente.");
        }
    }

    private static void cadastrarUsuario() {
        System.out.println("\n--- Cadastro de Usuário ---");
        System.out.print("Nome: ");
        String nome = Console.lerString();
        System.out.print("CPF: ");
        String cpf = Console.lerString();
        System.out.print("Endereço: ");
        String endereco = Console.lerString();
        System.out.print("E-mail: ");
        String email = Console.lerString();
        System.out.print("Telefone: ");
        String telefone = Console.lerString();
        System.out.print("Senha: ");
        String senha = Console.lerString();

        gerenciarUsuario.cadastrarUsuario(nome, cpf, endereco, email, telefone, senha);
    }

    public static void gerarPedido() {
        if (usuarioLogado == null) {
            System.out.println("\nVocê precisa estar logado para realizar pedidos.");
            return;
        }

        Metodos.exibirCardapio();
        Pedidos pedido = new Pedidos();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Pizza");
            System.out.println("2. Adicionar Bebida");
            System.out.println("3. Customizar Pizza");
            System.out.println("4. Finalizar Pedido");
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
                    }
                    break;

                case 2:
                    int bebidaEscolha = Console.lerInt("\nEscolha uma bebida pelo número (1-15): ");
                    Bebidas bebidaAdicionada = Metodos.selecionarBebida(bebidaEscolha, pedido);

                    try {
                        if (bebidaAdicionada != null) {
                            System.out.println("\nBebida adicionada ao pedido!");
                        }
                    } catch (Exception e) {
                        System.out.println("\nEscolha de bebida inválida. A bebida não foi adicionada.");
                    }
                    break;

                case 3:
                    Metodos.customPizza(pedido);
                    break;
                case 4:
                    System.out.println("\n======= Dados do Pedido =======");
                    System.out.println("\nNúmero do Pedido: " + pedido.getNumeroPedido());

                    // Mostrar bebidas, se houver
                    List<Bebidas> bebidas = pedido.getBebidas();
                    if (!bebidas.isEmpty()) {
                        System.out.println("\nBebidas:");
                        for (Bebidas bebida : bebidas) {
                            System.out.println(
                                    "- " + bebida.getNome() + ": R$ " + String.format("%.2f", bebida.getPreco()));
                        }
                    }

                    // Mostrar pizzas, se houver
                    List<Pizza> pizzas = pedido.getPizzas();
                    if (!pizzas.isEmpty()) {
                        System.out.println("\nPizzas:");
                        for (Pizza pizza : pizzas) {
                            System.out.println(
                                    "- " + pizza.getNome() + ": R$ " + String.format("%.2f", pizza.getPreco()));
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
                    
                    try {
                        if ("sim".equalsIgnoreCase(confirmacaoPagamento.trim())) {
                            System.out.println("\nPagamento realizado com sucesso! Recibo disponível.");
                            // Caso afirmativo, gerar recibo
                            usuarioLogado.adicionarPedido(pedido);
                            usuarioLogado.listarHistoricoPedidos();

                            String caminhoArquivo = "recibo.txt"; // Especificar o caminho desejado
                            gerarRecibo(pedido, caminhoArquivo);

                            String caminhoHistorico = "historico_pedidos_" + usuarioLogado.getCpf() + ".txt";
                            usuarioLogado.salvarHistoricoPedidos(caminhoHistorico);

                        }       
                    } catch (Exception e) {
                        System.out.println("Pagamento não autorizado. Pedido cancelado!");
                    }
                    continuar = false; // Sair do loop após finalizar pedido
                    break;
            }
        }
    }

    private static void listarPedidosRealizados() {
        if (usuarioLogado == null) {
            System.out.println("Você precisa estar logado para visualizar os pedidos realizados.");
            return;
        }

        List<Pedidos> pedidos = usuarioLogado.getHistoricoPedidos();
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado até o momento.");
        } else {
            System.out.println("\n--- Pedidos Realizados ---");
            for (Pedidos pedido : pedidos) {
                System.out.println("Número do Pedido: " + pedido.getNumeroPedido());
                System.out.println("Preço Total: R$ " + String.format("%.2f", pedido.getPrecoTotal()));
                System.out.println("Tempo de Preparo: " + pedido.getTempoPedido() + " minutos");
                System.out.println(); // linha em branco para separar os pedidos
            }
        }
    }

    private static void listarHistoricoPedidos() {
        if (usuarioLogado == null) {
            System.out.println("Você precisa estar logado para visualizar o histórico de pedidos.");
            return;
        }

        usuarioLogado.listarHistoricoPedidos();
    }

    public static void gerarRecibo(Pedidos pedido, String caminhoArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            writer.write("\nRecibo do Pedido\n");
            writer.write("================\n");
            writer.write("Numero do Pedido: " + pedido.getNumeroPedido() + "\n");
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
            writer.write("Preco Total: R$ " + String.format("%.2f", pedido.getPrecoTotal()) + "\n");
            writer.write("Tempo de Preparo: " + pedido.getTempoPedido() + " minutos\n");
            writer.write("================\n");
            writer.write("Obrigado por sua compra!");
        } catch (IOException e) {
            System.err.println("Erro ao gerar recibo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        
        executarSistema();
    }
}