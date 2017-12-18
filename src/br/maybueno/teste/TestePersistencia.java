package br.maybueno.teste;

import br.maybueno.dao.PlantaDAO;
import br.maybueno.model.JardimModel;
import br.maybueno.model.PlantaModel;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author MayBueno
 */

public class TestePersistencia {
    
    public static void main(String[] args){
    
    /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BabiloniaPersistencia");
        EntityManager em = emf.createEntityManager();
        
        PlantaModel p = new PlantaModel();
        
        JardimModel jm = em.find(JardimModel.class, 1);
        p.setNome("Fabiana");
        p.setStatus("Feliz");
        p.setTamanhoAtual(8);
        jm.adicionarPlanta(p);
        
    em.getTransaction().begin();
    em.persist(p);
    em.getTransaction().commit();
    em.close();
    emf.close();


        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("BabiloniaPersistencia");
        //EntityManager em = emf.createEntityManager();

        PlantaDAO dao = new PlantaDAO();
        
        JardimModel j = new JardimModel();
        
        j.setNome("Frontal");
        j.setPosicao("Lado da garagem");
        
    dao.em.getTransaction().begin();
    dao.em.persist(j);
    dao.em.getTransaction().commit();
    dao.em.close();
    dao.emf.close();

        */
    
    }
    
}
