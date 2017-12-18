// CLASSE GERADA AUTOMATICAMENTE
package br.maybueno.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author MayBueno
 */
@Entity
@Table(name = "planta", catalog = "babiloniaBD", schema = "")
@NamedQueries({
    @NamedQuery(name = "Planta.findAll", query = "SELECT p FROM Planta p")
    , @NamedQuery(name = "Planta.findByIdPlanta", query = "SELECT p FROM Planta p WHERE p.idPlanta = :idPlanta")
    , @NamedQuery(name = "Planta.findByNome", query = "SELECT p FROM Planta p WHERE p.nome = :nome")
    , @NamedQuery(name = "Planta.findByStatus", query = "SELECT p FROM Planta p WHERE p.status = :status")
    , @NamedQuery(name = "Planta.findByTamanhoAtual", query = "SELECT p FROM Planta p WHERE p.tamanhoAtual = :tamanhoAtual")
    , @NamedQuery(name = "Planta.findByIdJardim", query = "SELECT p FROM Planta p WHERE p.idJardim = :idJardim")})
public class Planta implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlanta")
    private Integer idPlanta;
    @Column(name = "nome")
    private String nome;
    @Column(name = "status")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tamanhoAtual")
    private Double tamanhoAtual;
    @Column(name = "idJardim")
    private Integer idJardim;

    public Planta() {
    }

    public Planta(Integer idPlanta) {
        this.idPlanta = idPlanta;
    }

    public Integer getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(Integer idPlanta) {
        Integer oldIdPlanta = this.idPlanta;
        this.idPlanta = idPlanta;
        changeSupport.firePropertyChange("idPlanta", oldIdPlanta, idPlanta);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public Double getTamanhoAtual() {
        return tamanhoAtual;
    }

    public void setTamanhoAtual(Double tamanhoAtual) {
        Double oldTamanhoAtual = this.tamanhoAtual;
        this.tamanhoAtual = tamanhoAtual;
        changeSupport.firePropertyChange("tamanhoAtual", oldTamanhoAtual, tamanhoAtual);
    }

    public Integer getIdJardim() {
        return idJardim;
    }

    public void setIdJardim(Integer idJardim) {
        Integer oldIdJardim = this.idJardim;
        this.idJardim = idJardim;
        changeSupport.firePropertyChange("idJardim", oldIdJardim, idJardim);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanta != null ? idPlanta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planta)) {
            return false;
        }
        Planta other = (Planta) object;
        if ((this.idPlanta == null && other.idPlanta != null) || (this.idPlanta != null && !this.idPlanta.equals(other.idPlanta))) {
            return false;
        }
        return true;
    }

    /*
    @Override
    public String toString() {
        return "br.maybueno.view.Planta[ idPlanta=" + idPlanta + " ]";
    }
*/

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    @Override
    public String toString(){
        return String.valueOf(idPlanta);
    }
    
}
