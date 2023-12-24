/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.DepartamentoDao;
import dao.EmpleadoDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Departamentos;
import modelo.Empleados;

@ManagedBean
@SessionScoped
public class empleadoBean implements Serializable{

    private static final long serialVersionUID = 1L;
    
    
    private List<Empleados> listaEmpleados;
    private EmpleadoDao empleadoDao;
    private Empleados empleado;
    private List<Empleados> empleadosPorNombre;
    private String nombre;
    private Departamentos idDepartamentoSeleccionado;


    @PostConstruct
    public void init() {
        empleado = new Empleados();
        empleadoDao = new EmpleadoDao();
        listaEmpleados = new ArrayList<Empleados>();
        //listaEmpleados = empleadoDao.listarEmpleados();
        //listaEmpleados =empleadoDao.listarEmpleados2();
    }

    public List<Empleados> getListaEmpleados() {
        
        this.listaEmpleados = empleadoDao.listarEmpleados2();
        return listaEmpleados;  
    }

    public void setListaEmpleados(List<Empleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public Empleados getEmpleados() {
        return empleado;
    }

    public void setEmpleados(Empleados empleado) {
        this.empleado = empleado;
    }
    

    public void limpiarEmpleados() {
        empleado = new Empleados();
    }

    public Departamentos getIdDepartamentoSeleccionado() {
        return idDepartamentoSeleccionado;
    }

    public void setIdDepartamentoSeleccionado(Departamentos idDepartamentoSeleccionado) {
        this.idDepartamentoSeleccionado = idDepartamentoSeleccionado;
    }

    
    
    ///
    

    public void buscarEmpleadosPorNombre() {
        EmpleadoDao empleadoDAO = new EmpleadoDao();
        empleadosPorNombre = empleadoDAO.findByEmpleados(nombre);
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public List<Empleados> getEmpleadosPorNombre() {
        return empleadosPorNombre;
    }

    public void setEmpleadosPorNombre(List<Empleados> empleadosPorNombre) {
        this.empleadosPorNombre = empleadosPorNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public void listarMangas2() {  
            empleadosPorNombre = empleadoDao.listarEmpleados2();
     
    }
    
   /*public void agregarEmpleado() {
    EmpleadoDao empDao = new EmpleadoDao();
    empDao.agregar(this.empleado);
    limpiarEmpleados();
   }
    */
     
  /*  public void agregarEmpleados() {
    EmpleadoDao emp = new EmpleadoDao();
    emp.agregar(empleado);
    limpiarEmpleados();
    listaEmpleados = emp.listarEmpleados2();
}*/
     
    public void modificarEmpleados() {
        EmpleadoDao emp = new EmpleadoDao();
        emp.modificar(empleado);
        limpiarEmpleados();
    } 
        
    public void agregarEmpleados() {
        EmpleadoDao emp = new EmpleadoDao();
        emp.agregar(empleado);
        listaEmpleados = emp.listarEmpleados2();
    }
    
    public void eliminarEmpleados() {
        EmpleadoDao emp = new EmpleadoDao();
        emp.eliminar(empleado);
        limpiarEmpleados();
        listaEmpleados = emp.listarEmpleados2();
    }

}
