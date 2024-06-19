public class Massa extends Ingredientes {
    private boolean essencial;

    public Massa(String nome, float preco, float tempPreparo) {
        super(nome, preco, tempPreparo);
        this.essencial = true; // Atributo essencial com valor verdadeiro
    }

    @Override
    public String getTipo() {
        return "Massa";
    }

    public boolean essencial() {
        return essencial;
    }

    public static Massa m1 = new Massa("Tradicional", 10.00f, 15);
    public static Massa m2 = new Massa("Doce", 12.00f, 20);
    public static Massa m3 = new Massa("Vegana", 15.00f, 25);
}