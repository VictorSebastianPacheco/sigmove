/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author victo
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "sigmovefase4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario loginUsuario(String usuarioIn , String contraseñaIn){
        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.contraseña = :contraseñaIn");
            q.setParameter("usuario",usuarioIn );
            q.setParameter("contraseñaIn",contraseñaIn );
            return (Usuario) q.getSingleResult();            
        } catch (Exception e) {
        return  new Usuario();
        }
    }
}
