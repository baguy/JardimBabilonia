package br.maybueno.dao;

import br.maybueno.model.JardimModel;
import br.maybueno.model.PlantaModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MayBueno
 */
public class PlantaDAO extends DAO<PlantaModel>{
    
    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("BabiloniaPersistencia");
    public EntityManager em = emf.createEntityManager();
    
    
    @Override
    public void persistencia(PlantaModel p){
        
        try{
            JardimModel jm = em.find(JardimModel.class, p.getNomeJardim().getIdJardim());
            jm.adicionarPlanta(p);
            
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();            
        }catch(Exception e){
           e.getMessage();
           System.out.println("Problema na persistência do obj Planta");
        }
            em.clear();
            //em.close();
            //emf.close();
        
    }
    
    public void excluir(JardimModel j, int idP){
    
        try{
            em.getTransaction().begin();
            j.getPlantas().remove(idP);
            //j.removerPlanta(idP);
            //em.remove(p);
            em.getTransaction().commit();
        }catch(Exception e){
           e.getMessage();
           System.out.println("Problema para excluir o obj Planta");
        }
            em.close();
            emf.close();
        
    }
    
    public void alterar(PlantaModel p){
        
        try{            
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();            
        }catch(Exception e){
            e.getMessage();
            System.out.println("Problema ao alterar o obj Planta");
        }
            //em.close();
            //emf.close();
        
    }
    
    
    
    /*
        @SuppressWarnings("unchecked")
	@Override
	public List<Planta> findAll() {
		return entityManager.createQuery("FROM PlantaModel").getResultList();
	}

	@Override
	public PlantaModel getById(Long id) {
		return entityManager.find(PlantaModel.class, id);
	}
        
        @Override
	public boolean removeById(final Long id) {

		boolean result = true;

		try {
			PlantaModel planta = this.getById(id);
			super.remove(planta);
		} catch (Exception ex) {
			ex.printStackTrace();
			result = false;
		}

		return result;
	}
        
        @Override
	public boolean persist(PlantaModel planta) {
		
		boolean result = true;
    	
        try {
        	
            entityManager.getTransaction().begin();
                        
            entityManager.persist(planta);
            
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
        	ex.printStackTrace();
                System.out.println("Erro na persistência -- PlantaDAO");
            entityManager.getTransaction().rollback();
            result = false;
        }
        
        return result;
	}
*/
    
    
}
