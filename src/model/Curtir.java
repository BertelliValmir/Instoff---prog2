
package model;

import java.util.ArrayList;

public class Curtir {
    
    private static final ArrayList<Curtir> aCurtirs = new ArrayList<Curtir>();
    
    private int id;
    private int idUsuario;
    private int idPost;

    private Curtir(int id, int idUsuario, int idPost) {
        this.id        = id;
        this.idUsuario = idUsuario;
        this.idPost    = idPost;
    }

    private Curtir(int id) {
        this.id        = id;
        this.idUsuario = -1;
        this.idPost    = -1;
    }
    
    public static Curtir newCurtir(int idUsuario, int idPost) {
        Curtir oCurtir = new Curtir(aCurtirs.size(), idUsuario, idPost);
        aCurtirs.add(oCurtir.getId(), oCurtir);
        
        return oCurtir;
    }
    
    public static Curtir newCurtir() {
        Curtir oCurtir = new Curtir(aCurtirs.size());
        aCurtirs.add(oCurtir.getId(), oCurtir);
        
        return oCurtir;
    }
    
    public static void deletCurtir(int id) {
        aCurtirs.remove(id);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }
}