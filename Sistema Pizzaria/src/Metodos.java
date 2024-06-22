public class Metodos {

    public static void gerarPedido() {
        
        Pedidos pedido = new Pedidos();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Pizza");
            System.out.println("2. Adicionar Bebida");
            System.out.println("0. Finalizar Pedido");
            int escolha = Console.lerInt("Escolha uma opção: ");

            switch (escolha) {
                case 1:
                    int pizzaEscolha = Console.lerInt("Escolha uma pizza pelo número (1-20): ");
                    Pizza pizza = null;

                    switch (pizzaEscolha) {
                        case 1:
                            pizza = Pizza.p1;
                            break;
                        case 2:
                            pizza = Pizza.p2;
                            break;
                        case 3:
                            pizza = Pizza.p3;
                            break;
                        case 4:
                            pizza = Pizza.p4;
                            break;
                        case 5:
                            pizza = Pizza.p5;
                            break;
                        case 6:
                            pizza = Pizza.p6;
                            break;
                        case 7:
                            pizza = Pizza.p7;
                            break;
                        case 8:
                            pizza = Pizza.p8;
                            break;
                        case 9:
                            pizza = Pizza.p9;
                            break;
                        case 10:
                            pizza = Pizza.p10;
                            break;
                        case 11:
                            pizza = Pizza.p11;
                            break;
                        case 12:
                            pizza = Pizza.p12;
                            break;
                        case 13:
                            pizza = Pizza.p13;
                            break;
                        case 14:
                            pizza = Pizza.p14;
                            break;
                        case 15:
                            pizza = Pizza.p15;
                            break;
                        case 16:
                            pizza = Pizza.p16;
                            break;
                        case 17:
                            pizza = Pizza.p17;
                            break;
                        case 18:
                            pizza = Pizza.p18;
                            break;
                        case 19:
                            pizza = Pizza.p19;
                            break;
                        case 20:
                            pizza = Pizza.p20;
                            break;
                        default:
                            System.out.println("Número de pizza inválido!");
                    }

                    if (pizza != null) {
                        int tamanho = Console.lerInt("Escolha o tamanho da pizza (1-5): ");
                        if (tamanho >= 1 && tamanho <= 5) {
                            pizza.setTamanho(tamanho);
                            pedido.adicionarPizza(pizza);
                            System.out.println("Pizza adicionada ao pedido!");
                        } else {
                            System.out.println("Tamanho inválido! A pizza não será adicionada.");
                        }
                    }
                    

                case 2:
                    int bebidaEscolha = Console.lerInt("Escolha uma bebida pelo número (1-7): ");
                    switch (bebidaEscolha) {
                        case 1:
                            pedido.adicionarBebida(Bebidas.b1);
                            break;
                        case 2:
                            pedido.adicionarBebida(Bebidas.b2);
                            break;
                        case 3:
                            pedido.adicionarBebida(Bebidas.b3);
                            break;
                        case 4:
                            pedido.adicionarBebida(Bebidas.b4);
                            break;
                        case 5:
                            pedido.adicionarBebida(Bebidas.b5);
                            break;
                        case 6:
                            pedido.adicionarBebida(Bebidas.b6);
                            break;
                        case 7:
                            pedido.adicionarBebida(Bebidas.b7);
                            break;
                        default:
                            System.out.println("Número de bebida inválido!");
                    }
                    System.out.println("Bebida adicionada ao pedido!");
                    break;

                case 0:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        }

        System.out.println("Número do Pedido: " + pedido.getNumeroPedido());
        System.out.println("Total a pagar: R$ " + pedido.getPrecoTotal());
        System.out.println("Tempo de preparo: " + pedido.getTempoPedido() + " minutos");
    }

    public static boolean selecionarPizza(int pizzaEscolha, int tamanho, Pedidos pedido) {
        Pizza pizza = null;
    
        switch (pizzaEscolha) {
            case 1:
                pizza = Pizza.p1;
                break;
            case 2:
                pizza = Pizza.p2;
                break;
            case 3:
                pizza = Pizza.p3;
                break;
            case 4:
                pizza = Pizza.p4;
                break;
            case 5:
                pizza = Pizza.p5;
                break;
            case 6:
                pizza = Pizza.p6;
                break;
            case 7:
                pizza = Pizza.p7;
                break;
            case 8:
                pizza = Pizza.p8;
                break;
            case 9:
                pizza = Pizza.p9;
                break;
            case 10:
                pizza = Pizza.p10;
                break;
            case 11:
                pizza = Pizza.p11;
                break;
            case 12:
                pizza = Pizza.p12;
                break;
            case 13:
                pizza = Pizza.p13;
                break;
            case 14:
                pizza = Pizza.p14;
                break;
            case 15:
                pizza = Pizza.p15;
                break;
            case 16:
                pizza = Pizza.p16;
                break;
            case 17:
                pizza = Pizza.p17;
                break;
            case 18:
                pizza = Pizza.p18;
                break;
            case 19:
                pizza = Pizza.p19;
                break;
            case 20:
                pizza = Pizza.p20;
                break;
            default:
                return false; // Retorna falso se a escolha de pizza for inválida
        }
    
        if (pizza != null && tamanho >= 1 && tamanho <= 5) {
            pizza.setTamanho(tamanho);
            pedido.adicionarPizza(pizza); // Adiciona a pizza ao pedido
            return true; // Retorna verdadeiro se a pizza for adicionada com sucesso
        } else {
            return false; // Retorna falso se a pizza ou o tamanho forem inválidos
        }
    }

    public static Bebidas selecionarBebida(int bebidaEscolha, Pedidos pedido) {
        Bebidas bebida = null;
    
        switch (bebidaEscolha) {
            case 1:
                bebida = Bebidas.b1;
                break;
            case 2:
                bebida = Bebidas.b2;
                break;
            case 3:
                bebida = Bebidas.b3;
                break;
            case 4:
                bebida = Bebidas.b4;
                break;
            case 5:
                bebida = Bebidas.b5;
                break;
            case 6:
                bebida = Bebidas.b6;
                break;
            case 7:
                bebida = Bebidas.b7;
                break;
            default:
                System.out.println("Escolha de bebida inválida!");
                break;
        }
    
        if (bebida != null) {
            pedido.adicionarBebida(bebida);
            return bebida;
        } else {
            return null;
        }
    }
} 