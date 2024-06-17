public class Bebidas {
    private String nome;
    private float preco;

    public Bebidas(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Métodos getter
    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    // Criação dos objetos base de bebidas
    public static Bebidas b1 = new Bebidas("coca 2L", 10.00f);
    public static Bebidas b2 = new Bebidas("guarana antartica 2L", 10.00f);
    public static Bebidas b3 = new Bebidas("fanta 2L", 10.00f);
    public static Bebidas b4 = new Bebidas("cini 2L", 8.00f);
    public static Bebidas b5 = new Bebidas("guarana kuat 2L", 8.00f);
    public static Bebidas b6 = new Bebidas("coca 600mL", 7.00f);
    public static Bebidas b7 = new Bebidas("guarana antartica 600mL", 7.00f);
}
