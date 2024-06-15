public class Bebidas {
    // Atributos da classe
    private String nome;
    private float preco;

    // Construtor da classe
    public Bebidas(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Métodos para obter os valores dos atributos
    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    // Método para exibir as informações das bebidas
    public void exibirInfo() {
        System.out.println("Nome: " + nome + ", Preço: R$" + preco);
    }

    // Método principal para executar o código
    public static void main(String[] args) {
        // Criando os objetos da classe Bebidas
        Bebidas bebida1 = new Bebidas("coca 2L", 10.00f);
        Bebidas bebida2 = new Bebidas("guarana antartica 2L", 10.00f);
        Bebidas bebida3 = new Bebidas("fanta 2L", 10.00f);
        Bebidas bebida4 = new Bebidas("cini 2L", 8.00f);
        Bebidas bebida5 = new Bebidas("guarana kuat 2L", 8.00f);
        Bebidas bebida6 = new Bebidas("coca 600mL", 7.00f);
        Bebidas bebida7 = new Bebidas("guarana antartica 600mL", 7.00f);
    }
}
