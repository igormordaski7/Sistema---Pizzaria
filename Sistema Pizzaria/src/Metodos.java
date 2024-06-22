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

        private static void exibirCardapio() {
        List<Pizza> pizzas = gerarCPizzas();
        List <Bebidas> bebidas = gerarCBebidas();
        

        System.out.println("\nPizzas disponíveis no cardápio:");
        for (int i = 0; i < pizzas.size(); i++) {
            Pizza p = pizzas.get(i);
            System.out.println((i + 1) + ". " + p.getNome() + " - Preço: R$" + p.getPreco());
        }
        
        System.out.println("\nBebidas disponíveis no cardápio:");
        for (int i = 0; i < bebidas.size(); i++) {
            Bebidas b = bebidas.get(i);
            System.out.println((i + 1) + ". " + b.getNome() + " - Preço: R$" + b.getPreco());

            lerEscolhaPizza(i);
            detalhePizza();
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

    private static void exibirDetalhesPizza(Pizza pizza) {
        System.out.println("\nInformações da pizza '" + pizza.getNome() + "':");
        System.out.println("Descrição: " + pizza.getMassa().getNome() + ", " + pizza.getMolho().getNome());
        System.out.println("Recheios:");
        for (Ingredientes ingrediente : pizza.getRecheios()) {
            System.out.println("- " + ingrediente.getNome());
        }
        System.out.println("Preço: R$" + pizza.getPreco());
        System.out.println("Tempo de preparo: " + pizza.getTempPreparo() + " minutos");
    
    }
    private static int lerEscolhaPizza(int numPizzas) {
        System.out.print("\nEscolha o número da pizza ou digite 0 para voltar: ");
        int escolha = Console.lerInt();
        if (escolha >= 0 && escolha <= numPizzas) {
            return escolha;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        exibirCardapio();
    }

} 