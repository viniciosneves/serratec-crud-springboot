package br.com.serratec.livraria.dtos;

import br.com.serratec.livraria.models.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario toModel() {
        Usuario usuario = new Usuario();

        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        String senhaEncriptada = new BCryptPasswordEncoder()
                .encode(this.senha);
        usuario.setSenha(senhaEncriptada);

        return usuario;
    }
}
