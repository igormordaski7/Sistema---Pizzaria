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