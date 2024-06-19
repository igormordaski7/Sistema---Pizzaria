import java.util.List;
import java.util.Random;

public class Pedidos {
    private int numeroPedido;
    private List<Bebidas> bebidas;
    private List<Pizza> pizzas;
    private float precoTotal;
    private float tempoPedido;

    public Pedidos(List<Bebidas> bebidas, List<Pizza> pizzas) {
        this.numeroPedido = gerarNumeroPedido();
        this.bebidas = bebidas;
        this.pizzas = pizzas;
        calcularPrecoTotal();
        calcularTempoPedido();
    }

    private int gerarNumeroPedido() {
        // Gerar número de pedido aleatório de 3 dígitos
        Random random = new Random();
        return random.nextInt(900) + 100; // Números de 100 a 999
    }

    private void calcularPrecoTotal() {
        precoTotal = 0;

        // Somar preços das bebidas
        for (Bebidas bebida : bebidas) {
            precoTotal += bebida.getPreco();
        }

        // Somar preços das pizzas
        for (Pizza pizza : pizzas) {
            precoTotal += pizza.getPreco();
        }
    }

    private void calcularTempoPedido() {
        tempoPedido = 0;

        // Encontrar o maior tempo de preparo entre as pizzas
        for (Pizza pizza : pizzas) {
            if (pizza.getTempPreparo() > tempoPedido) {
                tempoPedido = pizza.getTempPreparo();
            }
        }
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public List<Bebidas> getBebidas() {
        return bebidas;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public float getTempoPedido() {
        return tempoPedido;
    }

    public void setBebidas(List<Bebidas> bebidas) {
        this.bebidas = bebidas;
        calcularPrecoTotal();
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
        calcularPrecoTotal();
        calcularTempoPedido();
    }
}
