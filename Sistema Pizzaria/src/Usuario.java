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

    public void salvarHistoricoPedidos(String caminhoArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminhoArquivo))) {
            for (Pedidos pedido : historicoPedidos) {
                writer.println("Número do Pedido: " + pedido.getNumeroPedido());
                writer.println("Preço Total: R$ " + String.format("%.2f", pedido.getPrecoTotal()));
                writer.println("Tempo de Preparo: " + pedido.getTempoPedido() + " minutos");
                writer.println(); // linha em branco para separar os pedidos
            }
            System.out.println("Histórico de pedidos salvo em " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar histórico de pedidos: " + e.getMessage());
        }
    }

    public void carregarHistoricoPedidos(String cpf) {
        String nomeArquivo = "historico_pedidos_" + cpf + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Preço Total:")) {
                    // Extrair o preço do histórico de pedidos
                    String precoString = line.substring(line.indexOf("R$") + 2).trim();

                    // Substituir vírgula por ponto (caso necessário)
                    precoString = precoString.replace(",", ".");

                    // Converter para double
                    double preco = Double.parseDouble(precoString);

                    // Aqui você pode usar o preço como necessário no seu sistema
                    System.out.println("Preço do pedido: " + preco);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar histórico de pedidos: " + e.getMessage());
        }
    }

    public void listarHistoricoPedidos() {
        if (historicoPedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado até o momento.");
        } else {
            System.out.println("\n--- Histórico de Pedidos ---");
            for (Pedidos pedido : historicoPedidos) {
                System.out.println("Número do Pedido: " + pedido.getNumeroPedido());
                System.out.println("Preço Total: R$ " + String.format("%.2f", pedido.getPrecoTotal()));
                System.out.println("Tempo de Preparo: " + pedido.getTempoPedido() + " minutos");
                System.out.println(); // linha em branco para separar os pedidos
            }
        }
    }
}
