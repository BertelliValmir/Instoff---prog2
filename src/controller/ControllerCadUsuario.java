
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Usuario;
import view.CadUsuario;

public final class ControllerCadUsuario extends ControllerBaseTela {
    
    private final CadUsuario oCadUsuario = new CadUsuario();
    private final ControllerBaseTela oTop;
    
    private Usuario oUsuario;
    
    public ControllerCadUsuario(String WindowName, ControllerBaseTela oTop) {
        this.oCadUsuario.setTitle(WindowName);
        this.oTop = oTop;
        this.initComponents();
    }

    @Override
    protected void initComponents() {
        this.oCadUsuario.btnConcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                addUsuario();
            }
        });
        
        this.oCadUsuario.btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                backToTop();
            }
        });
        
        this.oCadUsuario.btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                deletUsuario();
            }
        });
    }
    
    @Override
    public void init() {
        if (this.oUsuario == null) {
            this.oCadUsuario.btnExcluir.hide();
        } else {
            this.oCadUsuario.btnExcluir.show();
        }
        
        this.oCadUsuario.setVisible(true);
    }
    
    private void backToTop() {
        this.oCadUsuario.setVisible(false);
        this.clearScreen();
        this.oTop.init();
    }
    
    public void setUsuario(Usuario oUsuario) {
        this.oUsuario = oUsuario;
        this.loadScreen();
    }
    
    protected void clearScreen() {
        this.oCadUsuario.txtNome.setText("");
        this.oCadUsuario.txtSobrenome.setText("");
        this.oCadUsuario.txtEmail.setText("");
        this.oCadUsuario.txtTelefone.setText("");
        this.oCadUsuario.txtLogin.setText("");
        this.oCadUsuario.pswSenha.setText("");
    }
    
    private void addUsuario() {
        if (!this.validaCampos()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            String mensagem = "Usuário Alterado com sucesso!";
            
            if (this.oUsuario == null) {
                mensagem = "Usuário Cadastrado com sucesso!";
                this.oUsuario = Usuario.newUsuario();
            }

            this.loadDataScreen();
            this.oUsuario = null;
            
            JOptionPane.showMessageDialog(null, mensagem);
            
            this.backToTop();
        }
    }
    
    private void deletUsuario() {
        
    }
    
    private void loadDataScreen() {
        this.oUsuario.setNome(this.oCadUsuario.txtNome.getText());
        this.oUsuario.setSobrenome(this.oCadUsuario.txtSobrenome.getText());
        this.oUsuario.setEmail(this.oCadUsuario.txtEmail.getText());
        this.oUsuario.setTelefone(this.oCadUsuario.txtTelefone.getText());
        this.oUsuario.setLogin(this.oCadUsuario.txtLogin.getText());
        this.oUsuario.setSenha(this.oCadUsuario.pswSenha.getText());
    }
    
    private void loadScreen() {
        this.oCadUsuario.txtNome.setText(this.oUsuario.getNome());
        this.oCadUsuario.txtSobrenome.setText(this.oUsuario.getSobrenome());
        this.oCadUsuario.txtEmail.setText(this.oUsuario.getEmail());
        this.oCadUsuario.txtTelefone.setText(this.oUsuario.getTelefone());
        this.oCadUsuario.txtLogin.setText(this.oUsuario.getLogin());
        this.oCadUsuario.pswSenha.setText(this.oUsuario.getSenha());
    }
    
    private boolean validaCampos() {
        boolean valido = !this.oCadUsuario.txtNome.getText().trim().equals("");
        valido = valido && !this.oCadUsuario.txtSobrenome.getText().trim().equals("");
        valido = valido && !this.oCadUsuario.txtEmail.getText().trim().equals("");
        valido = valido && !this.oCadUsuario.txtTelefone.getText().trim().equals("");
        valido = valido && !this.oCadUsuario.txtLogin.getText().trim().equals("");
        valido = valido && !this.oCadUsuario.pswSenha.getText().trim().equals("");
        
        return valido;
    }
}
