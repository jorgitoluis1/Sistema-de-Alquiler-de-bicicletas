/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utpl.proyectos.bisicletas.logica;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utpl.proyectos.bisicletas.entidades.Usuario;

/**
 *
 * @author Sistemas
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "utpl.proyectos_Bisicletas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario login(String username,String password){
        Query q=getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.nick=:user AND u.password=:password");
        q.setParameter("user", username);
        q.setParameter("password", password);
        List<Usuario> lista=q.getResultList();
        if(lista.size()>0){
            return lista.get(0);
        }else{
            return null;
        }
    }
    
}
