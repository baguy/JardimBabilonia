package br.maybueno.teste;

import br.maybueno.model.PlantaModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Baguy
 */
public class TesteAlterar {
    
        public static void main(String[] args){
    
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BabiloniaPersistencia");
        EntityManager em = emf.createEntityManager();
        
        PlantaModel p = em.find(PlantaModel.class, 1);
        
        p.setNome("Argentina");
            
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
        
        }
    
}
