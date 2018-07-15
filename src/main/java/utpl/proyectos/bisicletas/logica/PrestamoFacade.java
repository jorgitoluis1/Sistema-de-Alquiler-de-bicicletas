/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utpl.proyectos.bisicletas.logica;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utpl.proyectos.bisicletas.entidades.Prestamo;

/**
 *
 * @author Sistemas
 */
@Stateless
public class PrestamoFacade extends AbstractFacade<Prestamo> {

    @PersistenceContext(unitName = "utpl.proyectos_Bisicletas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestamoFacade() {
        super(Prestamo.class);
    }
    
}
