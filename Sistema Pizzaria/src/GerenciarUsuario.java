import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciarUsuario {

    private static Map<String, Usuario> usuarios = new HashMap<>();
    private static Map<String, List<Pedidos>> historicoPedidos = new HashMap<>();

    public static boolean cadastrarUsuario(String nome, String cpf, String endereco, String email, String telefone,
            String senha) {

        if (usuarios.containsKey(cpf)) {
            return false; // Usuário já cadastrado
        }

        Usuario usuario = new Usuario(nome, cpf, endereco, email, telefone, senha);
        usuarios.put(cpf, usuario);
        historicoPedidos.put(cpf, new ArrayList<>());
        return true;
    }

    public static Usuario login(String cpf, String senha) {
        Usuario usuario = usuarios.get(cpf);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }

    public static void adicionarPedidoAoHistorico(String cpf, Pedidos pedido) {
        List<Pedidos> pedidos = historicoPedidos.get(cpf);
        if (pedidos != null) {
            pedidos.add(pedido);
        }
    }

    public static List<Pedidos> getHistoricoPedidos(String cpf) {
        return historicoPedidos.getOrDefault(cpf, new ArrayList<>());
    }
}