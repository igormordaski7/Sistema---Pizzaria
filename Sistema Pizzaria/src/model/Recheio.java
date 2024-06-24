package model;

public abstract class Recheio extends Ingredientes {
    public Recheio(String nome, float preco, float tempPreparo) {
        super(nome, preco, tempPreparo);
    }

    @Override
    public String getTipo() {
        return "Recheio";
    }

    public abstract String getSubTipo();
}