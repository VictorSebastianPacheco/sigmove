/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.UsuarioCorreo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface UsuarioCorreoFacadeLocal {

    void create(UsuarioCorreo usuarioCorreo);

    void edit(UsuarioCorreo usuarioCorreo);

    void remove(UsuarioCorreo usuarioCorreo);

    UsuarioCorreo find(Object id);

    List<UsuarioCorreo> findAll();

    List<UsuarioCorreo> findRange(int[] range);

    int count();
    
}
