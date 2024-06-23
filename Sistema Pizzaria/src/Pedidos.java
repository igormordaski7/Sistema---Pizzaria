import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Pedidos {
    private int numeroPedido;
    private List<Bebidas> bebidas;
    private List<Pizza> pizzas;
    private double precoTotal;
    private double tempoPedido;

    public Pedidos() {
        this.numeroPedido = gerarNumeroPedido();
        this.bebidas = new ArrayList<>();
        this.pizzas = new ArrayList<>();
        this.precoTotal = 0;
        this.tempoPedido = 0;
    }

    private int gerarNumeroPedido() {
        // Gerar número de pedido aleatório de 3 dígitos
        Random random = new Random();
        return random.nextInt(900) + 100; // Números de 100 a 999
    }

    public void adicionarPizza(Pizza pizza) {
        pizzas.add(pizza);
        calcularPrecoTotal();
        calcularTempoPedido();
    }

    public void adicionarBebida(Bebidas bebida) {
        bebidas.add(bebida);
        calcularPrecoTotal();
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

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public List<Bebidas> getBebidas() {
        return bebidas;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public double getTempoPedido() {
        return tempoPedido;
    }

    public void setTempoPedido(double tempoPedido) {
        this.tempoPedido = tempoPedido;
    }
}
