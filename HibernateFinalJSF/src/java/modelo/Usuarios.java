package modelo;
// Generated 17/12/2023 11:43:03 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name="usuarios"
    ,catalog="hibernatefinaljsf"
)
public class Usuarios implements java.io.Serializable {

     private Integer idusuario;
     private Empleados empleados;
     private String usuario;
     private String clave;

    public Usuarios() {
    }

    public Usuarios(Empleados empleados, String usuario, String clave) {
       this.empleados = empleados;
       this.usuario = usuario;
       this.clave = clave;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idusuario", unique=true, nullable=false)
    public Integer getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="empleadoid", nullable=false)
    public Empleados getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    
    @Column(name="usuario", nullable=false, length=30)
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="clave", nullable=false, length=32)
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }




}


