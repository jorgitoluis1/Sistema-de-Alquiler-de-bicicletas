/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utpl.proyectos.bisicletas.controlador;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import utpl.proyectos.bisicletas.entidades.Usuario;
import utpl.proyectos.bisicletas.logica.UsuarioFacade;

/**
 *
 * @author Percho
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private String username;
    private String password;
    private Usuario usuario;
    @EJB
    private UsuarioFacade loginFacade;

    public LoginController() {

    }

    public void login() {
        this.usuario = this.loginFacade.login(username, password);
        if (usuario != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("admin.html");
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            FacesMessage msg = new FacesMessage("Login error!", "Su usuario o password son incorrectos");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void logout() {
        this.usuario = null;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.html");
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}
