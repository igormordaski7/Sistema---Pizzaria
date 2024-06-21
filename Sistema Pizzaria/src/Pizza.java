import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String nome;
    private Ingredientes massa;
    private Ingredientes molho;
    private List<Ingredientes> recheios;
    private float preco;
    private float tempPreparo;
    private int tamanho; // Novo atributo para tamanho da pizza

    public Pizza(String nome, Ingredientes massa, Ingredientes molho) {
        this.nome = nome;
        this.massa = massa;
        this.molho = molho;
        this.recheios = new ArrayList<>();
        this.tamanho = 1; // Valor inicial padrão para tamanho
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

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
        calcular();
    }

    private void calcular() {
        float multiplicador;
        switch (tamanho) {
            case 1:
                multiplicador = 1.0f;
                break;
            case 2:
                multiplicador = 1.2f;
                break;
            case 3:
                multiplicador = 1.5f;
                break;
            case 4:
                multiplicador = 1.7f;
                break;
            case 5:
                multiplicador = 2.0f;
                break;
            default:
                throw new IllegalArgumentException("Tamanho inválido: " + tamanho);
        }

        preco = multiplicador * (massa.getPreco() + molho.getPreco());
        for (Ingredientes recheio : recheios) {
            preco += multiplicador * recheio.getPreco();
        }

        // Calcular tempo total de preparo da pizza
        tempPreparo = multiplicador * (massa.getTempPreparo() + molho.getTempPreparo());
        for (Ingredientes recheio : recheios) {
            tempPreparo += multiplicador * recheio.getTempPreparo();
        }
    }

    // Declaração das pizzas estáticas
    public static Pizza p1;
    public static Pizza p2;
    public static Pizza p3;
    public static Pizza p4;
    public static Pizza p5;
    public static Pizza p6;
    public static Pizza p7;
    public static Pizza p8;
    public static Pizza p9;
    public static Pizza p10;
    public static Pizza p11;
    public static Pizza p12;
    public static Pizza p13;
    public static Pizza p14;
    public static Pizza p15;
    public static Pizza p16;
    public static Pizza p17;
    public static Pizza p18;
    public static Pizza p19;
    public static Pizza p20;

    static {
        p1 = new Pizza("Calabresa Acebolada", Massa.m1, Molho.m1);
        p1.addRecheio(RecheioSalgado.r5);
        p1.addRecheio(RecheioSalgado.r1);
        p1.addRecheio(RecheioSalgado.r2);

        p2 = new Pizza("Quatro Queijos", Massa.m1, Molho.m1);
        p2.addRecheio(RecheioSalgado.r5);
        p2.addRecheio(RecheioSalgado.r6);
        p2.addRecheio(RecheioSalgado.r7);
        p2.addRecheio(RecheioSalgado.r16);

        p3 = new Pizza("Frango Crocante", Massa.m1, Molho.m1);
        p3.addRecheio(RecheioSalgado.r12);
        p3.addRecheio(RecheioSalgado.r18);

        p4 = new Pizza("Estelar", Massa.m1, Molho.m1);
        p4.addRecheio(RecheioSalgado.r1);
        p4.addRecheio(RecheioSalgado.r2);
        p4.addRecheio(RecheioSalgado.r22);

        p5 = new Pizza("Humita", Massa.m1, Molho.m1);
        p5.addRecheio(RecheioSalgado.r4);
        p5.addRecheio(RecheioSalgado.r8);
        p5.addRecheio(RecheioSalgado.r12);

        p6 = new Pizza("Lombo Catupiry", Massa.m1, Molho.m1);
        p6.addRecheio(RecheioSalgado.r12);
        p6.addRecheio(RecheioSalgado.r17);

        p7 = new Pizza("Americana", Massa.m1, Molho.m1);
        p7.addRecheio(RecheioSalgado.r3);
        p7.addRecheio(RecheioSalgado.r9);
        p7.addRecheio(RecheioSalgado.r15);

        p8 = new Pizza("Imperial", Massa.m1, Molho.m1);
        p8.addRecheio(RecheioSalgado.r3);
        p8.addRecheio(RecheioSalgado.r7);
        p8.addRecheio(RecheioSalgado.r10);
        p8.addRecheio(RecheioSalgado.r12);
        p8.addRecheio(RecheioSalgado.r21);

        p9 = new Pizza("Ceciliana", Massa.m1, Molho.m1);
        p9.addRecheio(RecheioSalgado.r3);
        p9.addRecheio(RecheioSalgado.r20);
        p9.addRecheio(RecheioSalgado.r21);
        p9.addRecheio(RecheioSalgado.r23);

        p10 = new Pizza("Da Casa", Massa.m1, Molho.m1);
        p10.addRecheio(RecheioSalgado.r1);
        p10.addRecheio(RecheioSalgado.r3);
        p10.addRecheio(RecheioSalgado.r4);
        p10.addRecheio(RecheioSalgado.r8);
        p10.addRecheio(RecheioSalgado.r14);
        p10.addRecheio(RecheioSalgado.r21);

        p11 = new Pizza("Vegetariana", Massa.m3, Molho.m5);
        p11.addRecheio(RecheioSalgado.r2);
        p11.addRecheio(RecheioSalgado.r8);
        p11.addRecheio(RecheioSalgado.r30);
        p11.addRecheio(RecheioSalgado.r21);
        p11.addRecheio(RecheioSalgado.r14);
        p11.addRecheio(RecheioSalgado.r22);
        p11.addRecheio(RecheioSalgado.r20);

        p12 = new Pizza("Super Crocante", Massa.m1, Molho.m1);
        p12.addRecheio(RecheioSalgado.r3);
        p12.addRecheio(RecheioSalgado.r6);
        p12.addRecheio(RecheioSalgado.r18);

        p13 = new Pizza("Banana Canela", Massa.m2, Molho.m0);
        p13.addRecheio(RecheioDoce.r5);
        p13.addRecheio(RecheioDoce.r9);

        p14 = new Pizza("Califórnia", Massa.m2, Molho.m0);
        p14.addRecheio(RecheioDoce.r7);
        p14.addRecheio(RecheioDoce.r11);
        p14.addRecheio(RecheioDoce.r12);
        p14.addRecheio(RecheioDoce.r13);
        p14.addRecheio(RecheioDoce.r21);

        p15 = new Pizza("Suspiro", Massa.m2, Molho.m3);
        p15.addRecheio(RecheioDoce.r1);
        p15.addRecheio(RecheioDoce.r2);
        p15.addRecheio(RecheioDoce.r4);
        p15.addRecheio(RecheioDoce.r8);
        p15.addRecheio(RecheioDoce.r20);

        p16 = new Pizza("Morango com Chocolate", Massa.m2, Molho.m3);
        p16.addRecheio(RecheioDoce.r1);
        p16.addRecheio(RecheioDoce.r4);

        p17 = new Pizza("Vegana Doce", Massa.m3, Molho.m0);
        p17.addRecheio(RecheioDoce.r4);
        p17.addRecheio(RecheioDoce.r11);
        p17.addRecheio(RecheioDoce.r9);

        p18 = new Pizza("Ovo Maltine", Massa.m2, Molho.m0);
        p18.addRecheio(RecheioDoce.r4);
        p18.addRecheio(RecheioDoce.r19);

        p19 = new Pizza("Floresta Negra", Massa.m2, Molho.m3);
        p19.addRecheio(RecheioDoce.r2);
        p19.addRecheio(RecheioDoce.r12);
        p19.addRecheio(RecheioDoce.r8);

        p20 = new Pizza("Havaiana", Massa.m1, Molho.m1);
        p20.addRecheio(RecheioSalgado.r2);
        p20.addRecheio(RecheioSalgado.r5);
        p20.addRecheio(RecheioSalgado.r9);
        p20.addRecheio(RecheioSalgado.r11);
        p20.addRecheio(RecheioDoce.r7);

    }

}
