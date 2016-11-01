
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Usuario;
import view.Login;

public final class ControllerLogin extends ControllerBaseTela {
    
    private final Login oLogin = new Login();
    private final ControllerCadUsuario oCtrlCadUsuario = new ControllerCadUsuario("Cadastro", this);
    private final ControllerPrincipal oCtrlPrincipal = new ControllerPrincipal(this);
    
    public ControllerLogin() {
        initComponents();
    }
    
    @Override
    protected void initComponents() {
        this.oLogin.btnLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                validaLogin();
            }
        });
        
        this.oLogin.btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                initCadastrar();
            }
        });
    }
    
    @Override
    public void init() {
        this.oLogin.setVisible(true);
    }

    @Override
    protected void clearScreen() {
        this.oLogin.txtLogin.setText("");
        this.oLogin.pswSenha.setText("");
        this.oLogin.lblMenssagem.setText("");
    }

    public void initCadastrar() {
        this.oLogin.setVisible(false);
        this.clearScreen();
        
        this.oCtrlCadUsuario.init();
    }
    
    private void validaLogin() {
        String login = oLogin.txtLogin.getText();
        String senha = oLogin.pswSenha.getText();
        
        Usuario oUsuario = Usuario.getUsuarioFromLoginSenha(login, senha);
        
        if (oUsuario instanceof Usuario) {
            this.oCtrlPrincipal.setUsuario(oUsuario);
            this.oCtrlPrincipal.init();
            this.clearScreen();
            
            this.oLogin.setVisible(false);
        } else {
            this.oLogin.lblMenssagem.setText("Login ou Senha incorretos");
        }
    }
}
