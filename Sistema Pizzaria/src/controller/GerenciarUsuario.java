
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class GerenciarUsuario {

    private List<Usuario> usuariosCadastrados;

    public GerenciarUsuario() {
        this.usuariosCadastrados = carregarUsuariosDoArquivo();
    }

    public Usuario realizarLogin(String cpf, String senha) {
        for (Usuario usuario : usuariosCadastrados) {
            if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {

                return usuario;

            }
        }
        return null;
    }

    public void cadastrarUsuario(String nome, String cpf, String endereco, String email, String telefone,
            String senha) {
        Usuario novoUsuario = new Usuario(nome, cpf, endereco, email, telefone, senha);
        usuariosCadastrados.add(novoUsuario);
        salvarUsuarios();
    }

    private List<Usuario> carregarUsuariosDoArquivo() {
        List<Usuario> usuarios = new ArrayList<>();
        String nomeArquivo = "usuarios.txt";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            usuarios = (List<Usuario>) ois.readObject();
            System.out.println("Lista de usuários carregada de " + nomeArquivo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar lista de usuários: " + e.getMessage());
        }

        return usuarios;
    }

    public void salvarUsuarios() {
        String nomeArquivo = "usuarios.txt";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(usuariosCadastrados);
            System.out.println("Lista de usuários salva com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar lista de usuários: " + e.getMessage());
        }
    }

    public List<Usuario> getUsuariosCadastrados() {
        return usuariosCadastrados;
    }
}
