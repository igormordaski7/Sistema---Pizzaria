public class Molho extends Ingredientes {
    private boolean essencial;

    public Molho(String nome, float preco, float tempPreparo) {
        super(nome, preco, tempPreparo);
        this.essencial = true; // Atributo essencial com valor verdadeiro
    }

    @Override
    public String getTipo() {
        return "Molho";
    }

    public boolean isEssencial() {
        return essencial;
    }

    public static Molho m0 = new Molho("Sem Molho", 0.00f, 0);
    public static Molho m1 = new Molho("Tomate", 3.00f, 3);
    public static Molho m2 = new Molho("barbecue", 3.00f, 3);
    public static Molho m3 = new Molho("Chocolate", 4.00f, 2);
    public static Molho m4 = new Molho("Chocolate-branco", 4.00f, 2);
    public static Molho m5 = new Molho("Vegano", 5.00f, 2);

}