package br.maybueno.dao;

import br.maybueno.model.JardimModel;
import br.maybueno.model.PlantaModel;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author MayBueno
 */
public class JardimDAO extends DAO<JardimModel>{

    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("BabiloniaPersistencia");
    public EntityManager em = emf.createEntityManager();
    
    
    @Override
    public void persistencia(JardimModel j){
        
        try{           
            em.getTransaction().begin();
            em.persist(j);
            em.getTransaction().commit();            
        }catch(Exception e){
           e.getMessage();
           System.out.println("Problema na persistência do obj Jardim");
        }
           // em.close();
           // emf.close();
        
    }
    
    public void excluir(JardimModel j){
    
        try{
            em.getTransaction().begin();
            //j.getPlantas().remove(idJ);
            //j.removerPlanta(idP);
            em.remove(j);
            em.getTransaction().commit();
        }catch(Exception e){
           e.getMessage();
           System.out.println("Problema para excluir o obj");
        }
           // em.close();
           // emf.close();
        
    }
    
    public void alterar(JardimModel p){
        
        try{            
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();            
        }catch(Exception e){
            e.getMessage();
            System.out.println("Problema ao alterar o obj Jardim");
        }
           // em.close();
           // emf.close();
        
    }
    

    
    /*
    	@SuppressWarnings("unchecked")
	@Override
	public List<Jardim> findAll() {
		return entityManager.createQuery("FROM JardimModel").getResultList();
	}

	@Override
	public JardimModel getById(Long id) {
		return entityManager.find(JardimModel.class, id);
	}
        
        @Override
	public boolean removeById(final Long id) {

		boolean result = true;

		try {
			JardimModel jardim = this.getById(id);
			super.remove(jardim);
		} catch (Exception ex) {
			ex.printStackTrace();
			result = false;
		}

		return result;
	}
        
        @SuppressWarnings("unchecked")
	public List<Jardim> findByInterval(Date startIncluded, Date endIncluded) {
		
		Query query = 
			entityManager.createQuery(
				"FROM Order o WHERE o.date BETWEEN :startDate AND :endDate");

		query.setParameter("startDate", startIncluded);
		
		query.setParameter("endDate", endIncluded);
		
		return query.getResultList();
	}
        
        @Override
	public boolean persist(JardimModel jardim) {
		
		boolean result = true;
    	
        try {
        	
            entityManager.getTransaction().begin();
                        
            entityManager.persist(jardim);
            
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
        	ex.printStackTrace();
            entityManager.getTransaction().rollback();
            result = false;
        }
        
        return result;
	}
*/    

}
