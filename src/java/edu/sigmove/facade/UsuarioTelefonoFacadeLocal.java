/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.UsuarioTelefono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface UsuarioTelefonoFacadeLocal {

    void create(UsuarioTelefono usuarioTelefono);

    void edit(UsuarioTelefono usuarioTelefono);

    void remove(UsuarioTelefono usuarioTelefono);

    UsuarioTelefono find(Object id);

    List<UsuarioTelefono> findAll();

    List<UsuarioTelefono> findRange(int[] range);

    int count();
    
}
