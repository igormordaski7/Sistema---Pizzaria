public class Usuario {
    
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private String senha;

    public Usuario(String nome, String cpf, String endereco, String email, String telefone, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
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

    public String toString() {
        return "Nome: " + nome + "\n" +
               "CPF: " + cpf + "\n" +
               "Endereço: " + endereco + "\n" +
               "Email: " + email + "\n" +
               "Telefone: " + telefone + "\n" +
               "Senha: " + senha;
    }
}
