package br.maybueno.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Baguy
 */
public abstract class DAO<E> {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BabiloniaPersistencia");
    private EntityManager em = emf.createEntityManager();
    
    public void persistencia(E obj){
       try{
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            em.close();
            emf.close();
       }catch(Exception e){
           e.getMessage();
           System.out.println("Problema na persistência do obj");
       }
    }
    
    
    
    /*
    	protected EntityManager entityManager;
	 
    public DAO() {
        entityManager = getEntityManager();
    }
 
    private EntityManager getEntityManager() {
        
    	EntityManagerFactory factory = 
        		Persistence.createEntityManagerFactory("BabiloniaPersistencia");
    	
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
 
        return entityManager;
    }
 
    public abstract List<E> findAll();
 
    public boolean persist(E object) {
    	
    	boolean result = true;
    	
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(object);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
        	ex.printStackTrace();
            entityManager.getTransaction().rollback();
            result = false;
        }
        
        return result;
    }
 
    public boolean merge(E object) {
    	
    	boolean result = true;
    	
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(object);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            result = false;
        }
        
        return result;
    }
 
    public boolean remove(E object) {
    	
    	boolean result = true;
    	
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(object);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            result = false;
        }
        
        return result;
    }

	public abstract E getById(final Long id);
    
    public abstract boolean removeById(final Long id);
    */

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
