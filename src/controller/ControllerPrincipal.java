
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Usuario;
import view.Principal;

public class ControllerPrincipal extends ControllerBaseTela {
    
    private final Principal oPrincipal = new Principal();
    private final ControllerCadUsuario oCtrlCadUsuario = new ControllerCadUsuario("Alterar", this);
    private final ControllerBaseTela oTop;
    
    private Usuario oUsuario;
    
    public ControllerPrincipal( ControllerBaseTela oTop) {
        this.oTop = oTop;
        this.initComponents();
    }

    @Override
    protected void initComponents() {
        this.oPrincipal.btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                sair();
            }
        });
        
        this.oPrincipal.btnConf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                initCadastrar();
            }
        });
    }

    @Override
    public void init() {
        this.oPrincipal.lblNomeUsuario.setText(this.oUsuario.getNome() + " " + this.oUsuario.getSobrenome());
        this.oPrincipal.setVisible(true);
    }

    @Override
    protected void clearScreen() {
        
    }
    
    private void sair() {
        this.oUsuario = null;
        this.oPrincipal.setVisible(false);
        this.oTop.init();
    }
    
    public void initCadastrar() {
        this.oPrincipal.setVisible(false);
        
        this.oCtrlCadUsuario.setUsuario(this.oUsuario);
        this.oCtrlCadUsuario.init();
    }
    
    public void setUsuario(Usuario oUsuario) {
        this.oUsuario = oUsuario;
    }
}
