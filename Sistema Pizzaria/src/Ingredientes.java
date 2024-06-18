public abstract class Ingredientes {
    private String nome;
    private float preco;
    private float tempPreparo;

    public Ingredientes(String nome, float preco, float tempPreparo) {
        this.nome = nome;
        this.preco = preco;
        this.tempPreparo = tempPreparo;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public float getTempPreparo() {
        return tempPreparo;
    }

    public abstract String getTipo();
}