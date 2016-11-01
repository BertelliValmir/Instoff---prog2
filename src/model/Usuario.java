
package model;

import java.util.ArrayList;

public class Usuario {
    
    private static final ArrayList<Usuario> aUsuarios = new ArrayList<Usuario>();
    
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String login;
    private String senha;

    private Usuario(int id, String nome, String sobrenome, String email, String telefone, String login, String senha) {
        this.id        = id;
        this.nome      = nome;
        this.sobrenome = sobrenome;
        this.email     = email;
        this.telefone  = telefone;
        this.login     = login;
        this.senha     = senha;
    }

    private Usuario(int id) {
        this.id        = id;
        this.nome      = "";
        this.sobrenome = "";
        this.email     = "";
        this.telefone  = "";
        this.login     = "";
        this.senha     = "";
    }
    
    public static Usuario newUsuario(String nome, String sobrenome, String email, String telefone, String login, String senha) {
        Usuario oUsuario = new Usuario(aUsuarios.size(), nome, sobrenome, email, telefone, login, senha);
        aUsuarios.add(oUsuario);
        
        return oUsuario;
    }
    
    public static Usuario newUsuario() {
        Usuario oUsuario = new Usuario(aUsuarios.size());
        aUsuarios.add(oUsuario.getId(), oUsuario);
        
        return oUsuario;
    }
    
    public static Usuario getUsuario(int id) {
        return aUsuarios.get(id);
    }
    
    public static void deletUsuario(int id) {
        aUsuarios.remove(id);
    }
    
    public static Usuario getUsuarioFromLoginSenha(String login, String senha) {
        for (Usuario oUsuario : aUsuarios) {
            if (oUsuario.getLogin().equalsIgnoreCase(login) && oUsuario.getSenha().equalsIgnoreCase(senha)) {
                return oUsuario;
            }
        }
        
        return null;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
