import java.util.ArrayList;
import java.util.List;

public class Metodos {

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
            case 8:
                bebida = Bebidas.b8;
                break;
            case 9:
                bebida = Bebidas.b9;
                break;
            case 10:
                bebida = Bebidas.b10;
                break;
            case 11:
                bebida = Bebidas.b11;
                break;
            case 12:
                bebida = Bebidas.b12;
                break;
            case 13:
                bebida = Bebidas.b13;
                break;
            case 14:
                bebida = Bebidas.b14;
                break;
            case 15:
                bebida = Bebidas.b15;
                break;
        }

        if (bebida != null) {
            pedido.adicionarBebida(bebida);
            return bebida;
        } else {
            return null;
        }
    }

    public static void exibirCardapio() {
        List<Pizza> pizzas = gerarCPizzas();
        List<Bebidas> bebidas = gerarCBebidas();

        System.out.println("\nPizzas disponíveis no cardápio:");
        for (int i = 0; i < pizzas.size(); i++) {
            Pizza p = pizzas.get(i);
            System.out.println((i + 1) + ". " + p.getNome() + " - Preço: R$" + p.getPreco());
        }

        System.out.println("\nBebidas disponíveis no cardápio:");
        for (int i = 0; i < bebidas.size(); i++) {
            Bebidas b = bebidas.get(i);
            System.out.println((i + 1) + ". " + b.getNome() + " - Preço: R$" + b.getPreco());
        }

        System.out.println("\n1. Exibir ingredientes da Pizza");
        System.out.println("0. Voltar");
        int op2 = Console.lerInt();

        switch (op2) {
            case 1:
                detalhePizza();
                break;
            default:
                break;
        }
    }

    public static List<Pizza> gerarCPizzas() {
        List<Pizza> cardapio = new ArrayList<>();
        cardapio.add(Pizza.p1);
        cardapio.add(Pizza.p2);
        cardapio.add(Pizza.p3);
        cardapio.add(Pizza.p4);
        cardapio.add(Pizza.p5);
        cardapio.add(Pizza.p6);
        cardapio.add(Pizza.p7);
        cardapio.add(Pizza.p8);
        cardapio.add(Pizza.p9);
        cardapio.add(Pizza.p10);
        cardapio.add(Pizza.p11);
        cardapio.add(Pizza.p12);
        cardapio.add(Pizza.p13);
        cardapio.add(Pizza.p14);
        cardapio.add(Pizza.p15);
        cardapio.add(Pizza.p16);
        cardapio.add(Pizza.p17);
        cardapio.add(Pizza.p18);
        cardapio.add(Pizza.p19);
        cardapio.add(Pizza.p20);
        return cardapio;
    }

    public static List<Bebidas> gerarCBebidas() {
        List<Bebidas> cBebidas = new ArrayList<>();
        cBebidas.add(Bebidas.b1);
        cBebidas.add(Bebidas.b2);
        cBebidas.add(Bebidas.b3);
        cBebidas.add(Bebidas.b4);
        cBebidas.add(Bebidas.b5);
        cBebidas.add(Bebidas.b6);
        cBebidas.add(Bebidas.b7);
        cBebidas.add(Bebidas.b8);
        cBebidas.add(Bebidas.b9);
        cBebidas.add(Bebidas.b10);
        cBebidas.add(Bebidas.b11);
        cBebidas.add(Bebidas.b12);
        cBebidas.add(Bebidas.b13);
        cBebidas.add(Bebidas.b14);
        cBebidas.add(Bebidas.b15);
        return cBebidas;
    }

    public static void detalhePizza() {
        List<Pizza> pizzas = gerarCPizzas();
        int escolha = lerEscolhaPizza(pizzas.size());
        if (escolha != -1) {
            Pizza pizzaEscolhida = pizzas.get(escolha - 1);
            exibirDetalhesPizza(pizzaEscolhida);
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    public static void exibirDetalhesPizza(Pizza pizzaEscolhida) {
        System.out.println("\nInformações da pizza '" + pizzaEscolhida.getNome() + "':");
        System.out.println(
                "Descrição: " + pizzaEscolhida.getMassa().getNome() + ", " + pizzaEscolhida.getMolho().getNome());
        System.out.println("Recheios:");
        for (Ingredientes ingrediente : pizzaEscolhida.getRecheios()) {
            System.out.println("- " + ingrediente.getNome());
        }
        System.out.println("Preço: R$" + pizzaEscolhida.getPreco());
        System.out.println("Tempo de preparo: " + pizzaEscolhida.getTempPreparo() + " minutos");

    }

    public static int lerEscolhaPizza(int numPizzas) {
        int escolha = Console.lerInt("Escolha o número da pizza (1-20): ");
        if (escolha >= 0 && escolha <= numPizzas) {
            return escolha;
        } else {
            return -1;
        }
    }

    private static void exibirRecheio() {
        List<Recheio> recheios = gerarListRecheios();

        System.out.println("\nRecheios disponíveis:");
        for (int i = 0; i < recheios.size(); i++) {
            Recheio r = recheios.get(i);
            System.out.println((i + 1) + ". " + r.getNome() + " - Preço: R$" + r.getPreco());
        }
    }

    public static List<Recheio> gerarListRecheios() {
        List<Recheio> recheios = new ArrayList<>();
        recheios.add(RecheioSalgado.r1);
        recheios.add(RecheioSalgado.r2);
        recheios.add(RecheioSalgado.r3);
        recheios.add(RecheioSalgado.r4);
        recheios.add(RecheioSalgado.r5);
        recheios.add(RecheioSalgado.r6);
        recheios.add(RecheioSalgado.r7);
        recheios.add(RecheioSalgado.r8);
        recheios.add(RecheioSalgado.r9);
        recheios.add(RecheioSalgado.r10);
        recheios.add(RecheioSalgado.r11);
        recheios.add(RecheioSalgado.r12);
        recheios.add(RecheioSalgado.r13);
        recheios.add(RecheioSalgado.r14);
        recheios.add(RecheioSalgado.r15);
        recheios.add(RecheioSalgado.r16);
        recheios.add(RecheioSalgado.r17);
        recheios.add(RecheioSalgado.r18);
        recheios.add(RecheioSalgado.r19);
        recheios.add(RecheioSalgado.r20);
        recheios.add(RecheioSalgado.r21);
        recheios.add(RecheioSalgado.r22);
        recheios.add(RecheioSalgado.r23);
        recheios.add(RecheioSalgado.r24);
        recheios.add(RecheioSalgado.r25);
        recheios.add(RecheioSalgado.r26);
        recheios.add(RecheioSalgado.r27);
        recheios.add(RecheioSalgado.r28);
        recheios.add(RecheioSalgado.r29);
        recheios.add(RecheioSalgado.r30);
        recheios.add(RecheioSalgado.r31);
        recheios.add(RecheioDoce.r1);
        recheios.add(RecheioDoce.r2);
        recheios.add(RecheioDoce.r3);
        recheios.add(RecheioDoce.r4);
        recheios.add(RecheioDoce.r5);
        recheios.add(RecheioDoce.r6);
        recheios.add(RecheioDoce.r7);
        recheios.add(RecheioDoce.r8);
        recheios.add(RecheioDoce.r9);
        recheios.add(RecheioDoce.r10);
        recheios.add(RecheioDoce.r11);
        recheios.add(RecheioDoce.r12);
        recheios.add(RecheioDoce.r13);
        recheios.add(RecheioDoce.r14);
        recheios.add(RecheioDoce.r15);
        recheios.add(RecheioDoce.r16);
        recheios.add(RecheioDoce.r17);
        recheios.add(RecheioDoce.r18);
        recheios.add(RecheioDoce.r19);
        recheios.add(RecheioDoce.r20);
        recheios.add(RecheioDoce.r21);
        return recheios;
    }

    public static void customPizza(Pedidos pedido) {
        // Seleção da massa
        System.out.println("Escolha a massa:");
        System.out.println("1. Tradicional");
        System.out.println("2. Doce");
        System.out.println("3. Vegana");
        int op1 = Console.lerInt();
        Ingredientes massa = null;

        switch (op1) {
            case 1:
                massa = Massa.m1;
                break;
            case 2:
                massa = Massa.m2;
                break;
            case 3:
                massa = Massa.m3;
                break;
            default:
                System.out.println("Escolha inválida de massa.");
                return;
        }

        // Seleção do molho
        System.out.println("Escolha o molho:");
        System.out.println("0. Sem Molho");
        System.out.println("1. Tomate");
        System.out.println("2. Barbecue");
        System.out.println("3. Chocolate");
        System.out.println("4. Chocolate-branco");
        System.out.println("5. Vegano");
        int op2 = Console.lerInt();
        Ingredientes molho = null;

        switch (op2) {
            case 0:
                molho = Molho.m0;
                break;
            case 1:
                molho = Molho.m1;
                break;
            case 2:
                molho = Molho.m2;
                break;
            case 3:
                molho = Molho.m3;
                break;
            case 4:
                molho = Molho.m4;
                break;
            case 5:
                molho = Molho.m5;
                break;
            default:
                System.out.println("Escolha inválida de molho.");
                return;
        }

        // Criação da pizza
        Pizza customPizza = new Pizza("Personalizada", massa, molho);

        // Seleção de recheios
        boolean adicionarMaisRecheios = true;
        while (adicionarMaisRecheios) {
            System.out.println("Escolha um recheio (1-52):");
            exibirRecheio();

            int op3 = Console.lerInt();
            Ingredientes recheio = null;

            switch (op3) {
                case 1:
                    recheio = RecheioSalgado.r1;
                    break;
                case 2:
                    recheio = RecheioSalgado.r2;
                    break;
                case 3:
                    recheio = RecheioSalgado.r3;
                    break;
                case 4:
                    recheio = RecheioSalgado.r4;
                    break;
                case 5:
                    recheio = RecheioSalgado.r5;
                    break;
                case 6:
                    recheio = RecheioSalgado.r6;
                    break;
                case 7:
                    recheio = RecheioSalgado.r7;
                    break;
                case 8:
                    recheio = RecheioSalgado.r8;
                    break;
                case 9:
                    recheio = RecheioSalgado.r9;
                    break;
                case 10:
                    recheio = RecheioSalgado.r10;
                    break;
                case 11:
                    recheio = RecheioSalgado.r11;
                    break;
                case 12:
                    recheio = RecheioSalgado.r12;
                    break;
                case 13:
                    recheio = RecheioSalgado.r13;
                    break;
                case 14:
                    recheio = RecheioSalgado.r14;
                    break;
                case 15:
                    recheio = RecheioSalgado.r15;
                    break;
                case 16:
                    recheio = RecheioSalgado.r16;
                    break;
                case 17:
                    recheio = RecheioSalgado.r17;
                    break;
                case 18:
                    recheio = RecheioSalgado.r18;
                    break;
                case 19:
                    recheio = RecheioSalgado.r19;
                    break;
                case 20:
                    recheio = RecheioSalgado.r20;
                    break;
                case 21:
                    recheio = RecheioSalgado.r21;
                    break;
                case 22:
                    recheio = RecheioSalgado.r22;
                    break;
                case 23:
                    recheio = RecheioSalgado.r23;
                    break;
                case 24:
                    recheio = RecheioSalgado.r24;
                    break;
                case 25:
                    recheio = RecheioSalgado.r25;
                    break;
                case 26:
                    recheio = RecheioSalgado.r26;
                    break;
                case 27:
                    recheio = RecheioSalgado.r27;
                    break;
                case 28:
                    recheio = RecheioSalgado.r28;
                    break;
                case 29:
                    recheio = RecheioSalgado.r29;
                    break;
                case 30:
                    recheio = RecheioSalgado.r30;
                    break;
                case 31:
                    recheio = RecheioSalgado.r31;
                    break;
                case 32:
                    recheio = RecheioDoce.r1;
                    break;
                case 33:
                    recheio = RecheioDoce.r2;
                    break;
                case 34:
                    recheio = RecheioDoce.r3;
                    break;
                case 35:
                    recheio = RecheioDoce.r4;
                    break;
                case 36:
                    recheio = RecheioDoce.r5;
                    break;
                case 37:
                    recheio = RecheioDoce.r6;
                    break;
                case 38:
                    recheio = RecheioDoce.r7;
                    break;
                case 39:
                    recheio = RecheioDoce.r8;
                    break;
                case 40:
                    recheio = RecheioDoce.r9;
                    break;
                case 41:
                    recheio = RecheioDoce.r10;
                    break;
                case 42:
                    recheio = RecheioDoce.r11;
                    break;
                case 43:
                    recheio = RecheioDoce.r12;
                    break;
                case 44:
                    recheio = RecheioDoce.r13;
                    break;
                case 45:
                    recheio = RecheioDoce.r14;
                    break;
                case 46:
                    recheio = RecheioDoce.r15;
                    break;
                case 47:
                    recheio = RecheioDoce.r16;
                    break;
                case 48:
                    recheio = RecheioDoce.r17;
                    break;
                case 49:
                    recheio = RecheioDoce.r18;
                    break;
                case 50:
                    recheio = RecheioDoce.r19;
                    break;
                case 51:
                    recheio = RecheioDoce.r20;
                    break;
                case 52:
                    recheio = RecheioDoce.r21;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    recheio = null;
                    break;
            }

            customPizza.addRecheio(recheio);

            System.out.println("Deseja adicionar mais recheios? (1 - Sim, 0 - Não)");
            int continuar = Console.lerInt();
            adicionarMaisRecheios = continuar == 1;
        }

        // Definição do tamanho da pizza
        System.out.println("Escolha o tamanho da pizza (1 a 5):");
        int tamanhoEscolha = Console.lerInt();
        if (tamanhoEscolha >= 1 && tamanhoEscolha <= 5) {
            customPizza.setTamanho(tamanhoEscolha);
        } else {
            System.out.println("Escolha inválida de tamanho.");
            return;
        }

        // Adiciona a pizza personalizada ao pedido
        pedido.adicionarPizza(customPizza);
        System.out.println("Pizza personalizada adicionada ao pedido com sucesso!");
    }

    public static void exibirDetalhesPizza(int numPizzas) {

        throw new UnsupportedOperationException("Unimplemented method 'exibirDetalhesPizza'");
    }

}