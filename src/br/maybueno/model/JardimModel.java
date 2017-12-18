package br.maybueno.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author MayBueno
 */

@Entity
@Table(name = "jardim")
public class JardimModel implements Serializable{

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJardim;
    @Column
    private String nome;
    @Column
    private String posicao; // local da casa
    
    //@Column
    //private String linkFoto;

    public JardimModel(){}
    
    public JardimModel(Integer idJardim, String nome, String posicao) {
        this.idJardim = idJardim;
        this.nome = nome;
        this.posicao = posicao;
    }
    
    // Plantas
    @OneToMany( mappedBy = "idJardim",
              targetEntity = PlantaModel.class,
              cascade = CascadeType.ALL, 
              fetch = FetchType.LAZY,
              orphanRemoval = true )
    private final List<PlantaModel> plantas = new ArrayList<PlantaModel>();

    public List<PlantaModel> getPlantas() {
        return plantas;
    }
    
    public void adicionarPlanta(PlantaModel obj){
        obj.setNomeJardim(this);
        this.plantas.add(obj);
    }
    
    public void removerPlanta(int index){
        this.plantas.remove(index);
    }
    
    // GETTERS & SETTERS

    public Integer getIdJardim() {
        return idJardim;
    }

    public void setIdJardim(Integer idJardim) {
        Integer oldIdJardim = this.idJardim;
        this.idJardim = idJardim;
        changeSupport.firePropertyChange("idJardim", oldIdJardim, idJardim);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        String oldPosicao = this.posicao;
        this.posicao = posicao;
        changeSupport.firePropertyChange("posicao", oldPosicao, posicao);
    }
    


    /*
    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        String oldLinkFoto = this.linkFoto;
        this.linkFoto = linkFoto;
        changeSupport.firePropertyChange("linkFoto", oldLinkFoto, linkFoto);
    }
*/

    
    @Override
    public String toString(){
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JardimModel other = (JardimModel) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
