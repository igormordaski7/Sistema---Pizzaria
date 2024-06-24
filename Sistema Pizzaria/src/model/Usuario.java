package model;

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
                writer.println("========== Historico de Pedidos ==========");
                writer.println("Numero do Pedido: " + pedido.getNumeroPedido());
                writer.println("\nPizzas:");
                for (Pizza pizza : pedido.getPizzas()) {
                    writer.println("- " + pizza.getNome());
                }
                writer.println("\nBebidas:");
                for (Bebidas bebida : pedido.getBebidas()) {
                    writer.println("- " + bebida.getNome());
                }
                writer.println("Preco Total: R$ " + String.format("%.2f", pedido.getPrecoTotal()));
                writer.println("Tempo de Preparo: " + pedido.getTempoPedido() + " minutos");
                writer.println("==========================================");
            }

            System.out.println("Pedido finalizado com sucesso! Disponivel para visualização no " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar histórico de pedidos: " + e.getMessage());
        }
    }

    public void carregarHistoricoPedidos() {
        String nomeArquivo = "historico_pedidos_" + nome + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String line;
            historicoPedidos.clear();
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Preço Total:")) {
                    String precoString = line.substring(line.indexOf("R$") + 2).trim();
                    precoString = precoString.replace(",", ".");
                    double preco = Double.parseDouble(precoString);
                    System.out.println("Preço do pedido: " + preco);
                }
            }
        } catch (IOException e) {
        }
    }

    public void listarHistoricoPedidos() {
        if (historicoPedidos.isEmpty()) {
            System.out.println("\nNenhum pedido realizado até o momento.");
        } else {
            System.out.println("\n--- Histórico de Pedidos ---");
            for (Pedidos pedido : historicoPedidos) {
                System.out.println("Número do Pedido: " + pedido.getNumeroPedido());
                System.out.println("Preço Total: R$ " + String.format("%.2f", pedido.getPrecoTotal()));
                System.out.println("Tempo de Preparo: " + pedido.getTempoPedido() + " minutos");
                System.out.println();
            }
        }
    }
}
