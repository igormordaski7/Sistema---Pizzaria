import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciarUsuario {

    public static void salvarUsuarios(List<Usuario> usuarios) {
        String nomeArquivo = "usuarios.txt";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(usuarios);
            System.out.println("Lista de usuários salva com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar lista de usuários: " + e.getMessage());
        }
    }

    public static List<Usuario> carregarUsuarios() {
        String nomeArquivo = "usuarios.txt";
        List<Usuario> usuarios = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            usuarios = (List<Usuario>) ois.readObject();
            System.out.println("Lista de usuários carregada de " + nomeArquivo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar lista de usuários: " + e.getMessage());
        }

        return usuarios;
    }
}
