/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UsuarioDao;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import modelo.Usuarios;


@ManagedBean
@SessionScoped
public class loginBean implements Serializable{

    private Usuarios usuario = new Usuarios();
    private UsuarioDao usuarioDao;

    public Usuarios getUsuarios() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
     public loginBean() {
        this.usuarioDao = new UsuarioDao();
        if (this.usuario == null) {
            this.usuario = new Usuarios();
        }
    }
    
    public void login() {
    FacesMessage message;
    boolean loggedIn = false;

    this.usuario = this.usuarioDao.login(this.usuario);

    if (this.usuario != null) {
        loggedIn = true;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsuario());

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("manga.xhtml");
    } else {
        loggedIn = false;
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Usuario y/o Clave es incorrecto.");

        // Reiniciar el objeto Usuario para permitir otro intento
        this.usuario = new Usuarios();
    }

    FacesContext.getCurrentInstance().addMessage(null, message);
}

    public void logout() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();

        try {
            ec.redirect(ec.getRequestContextPath() + "/faces/login.xhtml?faces-redirect=true");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
