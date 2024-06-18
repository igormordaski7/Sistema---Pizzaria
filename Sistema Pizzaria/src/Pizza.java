import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String nome;
    private Ingredientes massa;
    private Ingredientes molho;
    private List<Ingredientes> recheios;
    private float preco;
    private float tempPreparo;

    public Pizza(String nome, Ingredientes massa, Ingredientes molho) {
        this.nome = nome;
        this.massa = massa;
        this.molho = molho;
        this.recheios = new ArrayList<>();
        calcular();
    }

    public void addRecheio(Ingredientes recheio) {
        recheios.add(recheio);
        calcular();
    }

    public String getNome() {
        return nome;
    }

    public Ingredientes getMassa() {
        return massa;
    }

    public Ingredientes getMolho() {
        return molho;
    }

    public List<Ingredientes> getRecheios() {
        return recheios;
    }

    public float getPreco() {
        return preco;
    }

    public float getTempPreparo() {
        return tempPreparo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMassa(Ingredientes massa) {
        this.massa = massa;
        calcular();
    }

    public void setMolho(Ingredientes molho) {
        this.molho = molho;
        calcular();
    }

    public void setRecheios(List<Ingredientes> recheios) {
        this.recheios = recheios;
        calcular();
    }

    private void calcular() {
        // Calcular preço total da pizza
        preco = massa.getPreco() + molho.getPreco();
        for (Ingredientes recheio : recheios) {
            preco += recheio.getPreco();
        }

        // Calcular tempo total de preparo da pizza
        tempPreparo = massa.getTempPreparo() + molho.getTempPreparo();
        for (Ingredientes recheio : recheios) {
            tempPreparo += recheio.getTempPreparo();
        }
    }

    public static void Pizzas() {

        Pizza p1 = new Pizza("Pizza de Calabresa Acebolada", Massa.m1, Molho.m1);
        p1.addRecheio(RecheioSalgado.r5);
        p1.addRecheio(RecheioSalgado.r1);
        p1.addRecheio(RecheioSalgado.r2);

        Pizza p2 = new Pizza("Pizza de Quatro Queijos", Massa.m1, Molho.m1);
        p2.addRecheio(RecheioSalgado.r5);
        p2.addRecheio(RecheioSalgado.r6);
        p2.addRecheio(RecheioSalgado.r7);
        p2.addRecheio(RecheioSalgado.r16);

    }
}
