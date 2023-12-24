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
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import modelo.Departamentos;
import modelo.Departamentos;

/**
 *
 * @author Administrador
 */

@ManagedBean
@SessionScoped
public class departamentoBean implements Serializable {

    private List<SelectItem> selectOneItemsDepartamento;
    private DepartamentoDao departamentoDao;

    public departamentoBean() {
        this.departamentoDao = new DepartamentoDao(); // Dependiendo de tu configuración de DAO, puede que necesites inyectarlo aquí.
    }

    @PostConstruct
    public void init() {
        this.selectOneItemsDepartamento = new ArrayList<>();
        List<Departamentos> departamentos = departamentoDao.listarDepartamentos();
        for (Departamentos depto : departamentos) {
            SelectItem selectItem = new SelectItem(depto.getIddepartamento(), depto.getDescripcion());
            selectOneItemsDepartamento.add(selectItem);
        }
    }

    public List<SelectItem> getSelectOneItemsDepartamento() {
        return selectOneItemsDepartamento;
    }

    // Getter y Setter para departamentoDao si es necesario
}

    
    /*
   
    private List<Departamentos> listaDepartamentos;
    private DepartamentoDao departamentoDao;
    private Departamentos departamento;
    

  
    @PostConstruct
    public void init() {
        departamento = new Departamentos();
        departamentoDao = new DepartamentoDao();
        //listaDepartamentos = departamentoDao.listarDepartamentos();
        listaDepartamentos =departamentoDao.listarDepartamentos();
    }

    public List<Departamentos> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamentos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public Departamentos getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamentos departamento) {
        this.departamento = departamento;
    }
    
  */
    

