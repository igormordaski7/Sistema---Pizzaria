package model;

public class Bebidas {
    private String nome;
    private float preco;

    public Bebidas(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public static Bebidas b1 = new Bebidas("Coca 2L", 10.00f);
    public static Bebidas b2 = new Bebidas("Guarana antartica 2L", 10.00f);
    public static Bebidas b3 = new Bebidas("Fanta Laranja 2L", 10.00f);
    public static Bebidas b4 = new Bebidas("Fanta Uva 2L", 10.00f);
    public static Bebidas b5 = new Bebidas("Cini 2L", 8.00f);
    public static Bebidas b6 = new Bebidas("Guarana Kuat 2L", 8.00f);
    public static Bebidas b7 = new Bebidas("Sprite 2L", 7.50f);
    public static Bebidas b8 = new Bebidas("Chá Matte Limão 1.5L", 8.00f);
    public static Bebidas b9 = new Bebidas("Chá Matte Pêssego 1.5L", 8.00f);
    public static Bebidas b10 = new Bebidas("Suco Prats de Laranja 900mL", 7.50f);
    public static Bebidas b11 = new Bebidas("Suco Prats de Uva 900ml", 7.50f);
    public static Bebidas b12 = new Bebidas("Coca 600mL", 7.00f);
    public static Bebidas b13 = new Bebidas("Guarana Antartica 600mL", 7.00f);
    public static Bebidas b14 = new Bebidas("Água com gás 500mL", 5.00f);
    public static Bebidas b15 = new Bebidas("Água Mineral 500mL", 4.50f);
}
