
package model;

import java.util.ArrayList;

public class Post {
    
    private static final ArrayList<Post> aPosts = new ArrayList<Post>();
    
    private int id;
    private int idUsuario;
    private String conteudo;

    private Post(int id, int idUsuario, String conteudo) {
        this.id        = id;
        this.idUsuario = idUsuario;
        this.conteudo  = conteudo;
    }
    
    private Post(int id) {
        this.id = id;
        this.idUsuario = -1;
        this.conteudo = "";
    }
    
    public static Post newPost(int idUsuario, String conteudo) {
        Post oPost = new Post(aPosts.size(), idUsuario, conteudo);
        aPosts.add(oPost.getId(), oPost);
        
        return oPost;
    }
    
    public static Post newPost() {
        Post oPost = new Post(aPosts.size());
        aPosts.add(oPost.getId(), oPost);
        
        return oPost;
    }
    
    public static void deletPost(int id) {
        aPosts.remove(id);
    }
    
    public static Post getPost(int id) {
        return aPosts.get(id);
    }
    
    public static ArrayList<Post> getPostsUsuario(int idUsuario) {
        ArrayList<Post> aReturn = new ArrayList<Post>();
        
        for (Post oPost : aPosts) {
            if (oPost.getIdUsuario()== idUsuario) {
                aReturn.add(oPost);
            }
        }
        
        return aReturn;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}