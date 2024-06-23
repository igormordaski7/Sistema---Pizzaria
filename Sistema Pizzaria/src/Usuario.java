import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private String senha;
    private List<Pedidos> historicoPedidos;

    public Usuario(String nome, String cpf, String endereco, String email, String telefone, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.historicoPedidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setHistoricoPedidos(List<Pedidos> historicoPedidos) {
        this.historicoPedidos = historicoPedidos;
    }

    public void adicionarPedido(Pedidos pedido) {
        historicoPedidos.add(pedido);
    }

    public List<Pedidos> getHistoricoPedidos() {
        return historicoPedidos;
    }

    public void salvarHistoricoPedidos() {
        String nomeArquivo = "historico_pedidos_" + cpf + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Pedidos pedido : historicoPedidos) {
                writer.println("Número do Pedido: " + pedido.getNumeroPedido());
                writer.println("Preço Total: R$ " + String.format("%.2f", pedido.getPrecoTotal()));
                writer.println("Tempo de Preparo: " + pedido.getTempoPedido() + " minutos");
                writer.println(); // linha em branco para separar os pedidos
            }
            System.out.println("Histórico de pedidos salvo em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar histórico de pedidos: " + e.getMessage());
        }
    }

    public void carregarHistoricoPedidos() {
        String nomeArquivo = "historico_pedidos_" + cpf + ".txt";
        historicoPedidos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("Número do Pedido: ")) {
                    Pedidos pedido = new Pedidos();
                    pedido.setNumeroPedido(Integer.parseInt(linha.substring("Número do Pedido: ".length()).trim()));

                    linha = reader.readLine(); // ler próxima linha
                    if (linha.startsWith("Preço Total: R$ ")) {
                        pedido.setPrecoTotal(Double.parseDouble(linha.substring("Preço Total: R$ ".length()).trim()));
                    }

                    linha = reader.readLine(); // ler próxima linha
                    if (linha.startsWith("Tempo de Preparo: ")) {
                        pedido.setTempoPedido(Integer.parseInt(linha.substring("Tempo de Preparo: ".length()).trim()));
                    }

                    historicoPedidos.add(pedido);
                }
            }
            System.out.println("Histórico de pedidos carregado de " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao carregar histórico de pedidos: " + e.getMessage());
        }
    }

     public void listarHistoricoPedidos() {
        String nomeArquivo = "historico_pedidos_" + cpf + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println("--- Histórico de Pedidos ---");
            for (Pedidos pedido : historicoPedidos) {
                writer.println("\nNúmero do Pedido: " + pedido.getNumeroPedido());
                writer.println("Preço Total: R$ " + String.format("%.2f", pedido.getPrecoTotal()));
                writer.println("Tempo de Preparo: " + pedido.getTempoPedido() + " minutos");
            }
            System.out.println("\nHistórico de pedidos salvo em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar histórico de pedidos: " + e.getMessage());
        }
    }
}
