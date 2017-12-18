package br.maybueno.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author MayBueno
 */

@Entity
@Table(name = "Planta")
public class PlantaModel implements Serializable{
  
  public PlantaModel(){}
  public PlantaModel(String nome, String tamanhoAtual, String status, JardimModel idJardim){
      this.nome = nome;
      this.tamanhoAtual = Double.parseDouble(tamanhoAtual);
      this.status = status;
      this.idJardim = idJardim;      
  }
  
  @Id
  @Column(name = "idPlanta")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idPlanta;

  @Column(name = "nome")
  private String nome;

  @Column(name = "tamanhoAtual")
  private double tamanhoAtual;

  @Column(name = "status")
  private String status;
  
  // JARDIM
  @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
  @JoinColumn( name = "idJardim", referencedColumnName = "idJardim" )
  @ForeignKey( name = "fk_jardim" )
  public JardimModel idJardim;
  
    public JardimModel getNomeJardim() {
        return idJardim;
    }

    public void setNomeJardim(JardimModel idJardim) {
        this.idJardim = idJardim;
    }
  
  /*
  @Column(name = "dataPlantio", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date dataPlantio;
  
  // COR
  @OneToMany( mappedBy = "planta",
              targetEntity = Cor.class,
              cascade = CascadeType.ALL, 
              fetch = FetchType.LAZY )
  private final List<Cor> cores = new ArrayList<Cor>();

  // TIPO
  @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
  @JoinColumn( name = "idTipo", referencedColumnName = "idTipo" )
  public Tipo idTipo;
  
  // GETTERS AND SETTERS
  
    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        this.idTipo = idTipo;
    }

    public List<Cor> getCores() {
        return cores;
    }
    
    public void addCores(Cor cor){
      cor.setPlanta(this);
      this.cores.add(cor);
    }
  
      public Date getDataPlantio() {
        return dataPlantio;
    }

    public void setDataPlantio(Date dataPlantio) {
        this.dataPlantio = dataPlantio;
    }
  
*/
  
    public Integer getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(Integer idPlanta) {
        this.idPlanta = idPlanta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTamanhoAtual() {
        return tamanhoAtual;
    }

    public void setTamanhoAtual(double tamanhoAtual) {
        this.tamanhoAtual = tamanhoAtual;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.idPlanta);
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
        final PlantaModel other = (PlantaModel) obj;
        if (!Objects.equals(this.idPlanta, other.idPlanta)) {
            return false;
        }
        return true;
    }

    public String toString(){
        return String.valueOf(idPlanta);
    }
    
    
}
