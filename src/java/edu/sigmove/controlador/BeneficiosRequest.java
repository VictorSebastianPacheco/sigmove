/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Beneficio;
import edu.sigmove.facade.BeneficioFacadeLocal;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.PrimeFaces;
/**
 *
 * @author victo
 */
@Named(value = "beneficiosRequest")
@RequestScoped
public class BeneficiosRequest implements Serializable{

    @EJB
    BeneficioFacadeLocal BeneficioFacadeLocal;
    
    private Beneficio benfReg = new Beneficio();
    
    public BeneficiosRequest() {
    }
    public void registrarBeneficio() {
        String mensajeRequest="";
        try {
            benfReg.setFecha(new Date());
            BeneficioFacadeLocal.create(benfReg);
          mensajeRequest = "swal('Registro', 'Exitoso !!!!', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:registrarUsuario " +e.getMessage());
            mensajeRequest = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        benfReg = new Beneficio();
    }
    
    public void actualizarMisDatos(){
         String mensajeAlerta = "";
        try {
           BeneficioFacadeLocal.edit(benfReg);
             mensajeAlerta = "swal('Datos actualizados', 'Exitosamente !!!', 'success');";
        } catch (Exception e) {
             mensajeAlerta = "swal('Problemas actualizando', 'sus datos', 'error');";
        }
          PrimeFaces.current().executeScript(mensajeAlerta);
    }

    public Beneficio getBenfReg() {
        return benfReg;
    }

    public void setBenfReg(Beneficio benfReg) {
        this.benfReg = benfReg;
    }
    
}
