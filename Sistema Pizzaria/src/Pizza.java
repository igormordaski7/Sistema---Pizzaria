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

        Pizza p3 = new Pizza("Pizza de Frango Crocante", Massa.m1, Molho.m1);
        p3.addRecheio(RecheioSalgado.r12);
        p3.addRecheio(RecheioSalgado.r18);

        
        Pizza p4 = new Pizza("Estelar", Massa.m1, Molho.m1);
        p4.addRecheio(RecheioSalgado.r1);
        p4.addRecheio(RecheioSalgado.r2);
        p4.addRecheio(RecheioSalgado.r22);

        Pizza p5 = new Pizza("Humita", Massa.m1, Molho.m1);
        p5.addRecheio(RecheioSalgado.r4);
        p5.addRecheio(RecheioSalgado.r8);
        p5.addRecheio(RecheioSalgado.r12);

        Pizza p6 = new Pizza("Lombo Catupiry", Massa.m1, Molho.m1);
        p6.addRecheio(RecheioSalgado.r12);
        p6.addRecheio(RecheioSalgado.r17);

        Pizza p7 = new Pizza("Americana", Massa.m1, Molho.m1);
        p7.addRecheio(RecheioSalgado.r3);
        p7.addRecheio(RecheioSalgado.r9);
        p7.addRecheio(RecheioSalgado.r15);

        Pizza p8 = new Pizza("Imperial", Massa.m1, Molho.m1);
        p8.addRecheio(RecheioSalgado.r3);
        p8.addRecheio(RecheioSalgado.r7);
        p8.addRecheio(RecheioSalgado.r10);
        p8.addRecheio(RecheioSalgado.r12);
        p8.addRecheio(RecheioSalgado.r21);

        Pizza p9 = new Pizza("Ceciliana", Massa.m1, Molho.m1);
        p9.addRecheio(RecheioSalgado.r3);
        p9.addRecheio(RecheioSalgado.r20);
        p9.addRecheio(RecheioSalgado.r21);
        p9.addRecheio(RecheioSalgado.r23);


        Pizza p10 = new Pizza("Da Casa", Massa.m1, Molho.m1);
        p10.addRecheio(RecheioSalgado.r1);
        p10.addRecheio(RecheioSalgado.r3);
        p10.addRecheio(RecheioSalgado.r4);
        p10.addRecheio(RecheioSalgado.r8);
        p10.addRecheio(RecheioSalgado.r14);
        p10.addRecheio(RecheioSalgado.r21);

        Pizza p11 = new Pizza("Vegetariana", Massa.m3, Molho.m5);
        p11.addRecheio(RecheioSalgado.r2);
        p11.addRecheio(RecheioSalgado.r8);
        p11.addRecheio(RecheioSalgado.r30);
        p11.addRecheio(RecheioSalgado.r21);
        p11.addRecheio(RecheioSalgado.r14);
        p11.addRecheio(RecheioSalgado.r22);
        p11.addRecheio(RecheioSalgado.r20);

        Pizza p12 = new Pizza("Super Crocante", Massa.m1, Molho.m1);
        p12.addRecheio(RecheioSalgado.r3);
        p12.addRecheio(RecheioSalgado.r6);
        p12.addRecheio(RecheioSalgado.r18);

        Pizza p13 = new Pizza("Banana Canela", Massa.m1, Molho.m6);
        p13.addRecheio(RecheioDoce.r5);
        p13.addRecheio(RecheioDoce.r9);

        Pizza p14 = new Pizza("Califórnia", Massa.m1, Molho.m6);
        p14.addRecheio(RecheioDoce.r7);
        p14.addRecheio(RecheioDoce.r11);
        p14.addRecheio(RecheioDoce.r12);
        p14.addRecheio(RecheioDoce.r13);
        p14.addRecheio(RecheioDoce.r21);

        Pizza p15 = new Pizza("Suspiro", Massa.m1, Molho.m3);
        p15.addRecheio(RecheioDoce.r1);
        p15.addRecheio(RecheioDoce.r2);
        p15.addRecheio(RecheioDoce.r4);
        p15.addRecheio(RecheioDoce.r8);
        p15.addRecheio(RecheioDoce.r20);

        Pizza p16 = new Pizza("Morango com Chocolate", Massa.m1, Molho.m3);
        p16.addRecheio(RecheioDoce.r1);
        p16.addRecheio(RecheioDoce.r4);
        
        Pizza p17 = new Pizza("Vegana Doce", Massa.m3, Molho.m6);
        p17.addRecheio(RecheioDoce.r4);
        p17.addRecheio(RecheioDoce.r4);
        p17.addRecheio(RecheioDoce.r11);
        p17.addRecheio(RecheioDoce.r9);

        Pizza p18 = new Pizza("Ovo Maltine", Massa.m1, Molho.m6);
        p18.addRecheio(RecheioDoce.r4);
        p18.addRecheio(RecheioDoce.r19);

        Pizza p19 = new Pizza("Floresta Negra", Massa.m1, Molho.m6);
        p19.addRecheio(RecheioDoce.r2);
        p19.addRecheio(RecheioDoce.r12);
        p19.addRecheio(RecheioDoce.r8);

        Pizza p20 = new Pizza("Havaiana", Massa.m1, Molho.m1);
        p20.addRecheio(RecheioSalgado.r2);
        p20.addRecheio(RecheioSalgado.r5);
        p20.addRecheio(RecheioSalgado.r9);
        p20.addRecheio(RecheioSalgado.r11);
        p20.addRecheio(RecheioDoce.r7);


        
        


    }
}
