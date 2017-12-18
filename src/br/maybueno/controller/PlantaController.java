package br.maybueno.controller;

import br.maybueno.dao.PlantaDAO;
import br.maybueno.model.JardimModel;
import br.maybueno.model.PlantaModel;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author MayBueno
 */

public class PlantaController {
    
    private PlantaDAO dao = new PlantaDAO();
    
    public String cadastrarPlanta(String nome, String tamanhoAtual, String status, JardimModel jardim){
        String result = "";       
        try{
            PlantaModel planta = new PlantaModel();
            planta.setNome(nome);
            planta.setTamanhoAtual(Double.parseDouble(tamanhoAtual));
            planta.setStatus(status);
            planta.setNomeJardim(jardim);
            
            dao.persistencia(planta);
            
        } catch(Exception e){
            result = "Falha no try-catch no cadastro do PlantasController";
        }       
        return result;
    }
    
    public String atualizarPlanta(String nome, String tamanhoAtual, String status, JardimModel jardim, int idP){
        String result = "";
        try{
            PlantaModel planta = new PlantaModel();
            planta = dao.em.find(PlantaModel.class, idP);
            
            planta.setNome(nome);
            planta.setTamanhoAtual(Double.parseDouble(tamanhoAtual));
            planta.setStatus(status);
            planta.setNomeJardim(jardim);
            
            dao.alterar(planta);     
            
        } catch(Exception e){
            result = "Falha no try-catch na atualização do PlantasController";
        }       
        return result;
    }
    
    public String removerPlanta(int idJ, int idP){
        String result = "";
        try{
            PlantaModel planta = new PlantaModel();
            JardimModel jardim = new JardimModel();
            
            jardim = dao.em.find(JardimModel.class, idJ);
            
            System.out.println(idJ +" | "+ idP);
            
            dao.excluir(jardim, idP);     
            
        } catch(Exception e){
            result = "Falha no try-catch na atualização do PlantasController";
        }       
        return result;
    }
    
    public void consultaPlantas(JTextArea txt){
        
        String jpql = "FROM PlantaModel order by idJardim";
        List<PlantaModel> pLista = dao.em.createQuery(jpql).getResultList();
        txt.setText("   Planta   ---   Jardim   ---   Status   \n\n");
        for(PlantaModel i : pLista){
            txt.append("   " + i.getNome() +"  ---  "+ i.getNomeJardim() +"  ---  "+ i.getStatus() +" \n");
        }
        
    }

    
}
