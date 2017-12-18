package br.maybueno.controller;

import br.maybueno.dao.JardimDAO;
import br.maybueno.model.JardimModel;

/**
 *
 * @author Baguy
 */
public class JardimController {
    
    private JardimDAO dao = new JardimDAO();
    
        public String cadastrarJardim(String nome, String posicao){
            String result = "";       
            try{
                JardimModel jardim = new JardimModel();
                jardim.setNome(nome);
                jardim.setPosicao(posicao);

                dao.persistencia(jardim);

            } catch(Exception e){
                result = "Falha no try-catch no cadastro do JardimController";
            }       
            return result;
    }
        
    public String atualizarJardim(String nome, String posicao, int idJ){
            
            String result = "";
            try{
                JardimModel jardim = new JardimModel();
                jardim = dao.em.find(JardimModel.class, idJ);

               jardim.setNome(nome);
               jardim.setPosicao(posicao);

                dao.alterar(jardim);     

            } catch(Exception e){
                result = "Falha no try-catch na atualização do JardimController";
            }       
            return result;
            
        }
          
        public String removerJardim(int idJ){
            String result = "";
            try{
                JardimModel jardim = new JardimModel();

                jardim = dao.em.find(JardimModel.class, idJ);

                System.out.println(idJ);

                dao.excluir(jardim);     

            } catch(Exception e){
                result = "Falha no try-catch na atualização do PlantasController";
            }       
            return result;
    }   
        
        public String criarJardimCelestial(String nome, String posicao){
            String result = "";
            
            JardimModel j = new JardimModel();
            j = dao.em.find(JardimModel.class, 1);
            
            if (j == null){
                try{
                    JardimModel jardim = new JardimModel();
                    jardim.setNome(nome);
                    jardim.setPosicao(posicao);

                    dao.persistencia(jardim);

                } catch(Exception e){
                    result = "Falha no try-catch no cadastro do JardimCelestialController";
                }       
            }
            
            return result;
        }
    
}
