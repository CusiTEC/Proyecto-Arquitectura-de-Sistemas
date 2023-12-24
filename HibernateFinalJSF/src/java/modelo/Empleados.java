package modelo;
// Generated 17/12/2023 11:43:03 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Empleados generated by hbm2java
 */
@Entity
@Table(name="empleados"
    ,catalog="hibernatefinaljsf"
)
public class Empleados  implements java.io.Serializable {


     private Integer idempleado;
     private Departamentos departamentos;
     private String nombres;
     private String apellidos;
     private String email;
     private String rol;
     private Date fechaEntrada;

     private Departamentos departamentoSeleccionado; 
     
    public Empleados() {
        this.departamentos = new Departamentos();
    }

	
    public Empleados(Departamentos departamentos, String nombres, String apellidos, String email, String rol, Date fechaEntrada) {
        this.departamentos = departamentos;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.rol = rol;
        this.fechaEntrada = fechaEntrada;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idempleado", unique=true, nullable=false)
    public Integer getIdempleado() {
        return this.idempleado;
    }
    
    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="departamento_id")
    public Departamentos getDepartamentos() {
        return this.departamentos;
    }
    
    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    
    @Column(name="nombres", nullable=false, length=50)
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    
    @Column(name="apellidos", nullable=false, length=50)
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    @Column(name="email", nullable=false, length=100)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="rol", nullable=false, length=50)
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_entrada", length=10)
    public Date getFechaEntrada() {
        return this.fechaEntrada;
    }
    
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    

    // Getters y Setters para el nuevo atributo departamentoSeleccionado
    public Departamentos getDepartamentoSeleccionado() {
        return departamentoSeleccionado;
    }

    public void setDepartamentoSeleccionado(Departamentos departamentoSeleccionado) {
        this.departamentoSeleccionado = departamentoSeleccionado;
    }

}

