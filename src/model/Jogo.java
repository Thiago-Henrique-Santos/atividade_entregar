/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Paulo
 */
@Entity
@Table(name = "jogo", catalog = "db_relatorio_jogos", schema = "")
public class Jogo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjogo")
    private Integer idjogo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "genero")
    private String genero;
    
    //Um jogo pode estar em várias compras
    @OneToMany(mappedBy = "jogo")
    private List<Compra> compras = new ArrayList<>();

    public Jogo() {
    }

    public Jogo(Integer idjogo) {
        this.idjogo = idjogo;
    }

    public Integer getIdjogo() {
        return idjogo;
    }

    public void setIdjogo(Integer idjogo) {
        Integer oldIdjogo = this.idjogo;
        this.idjogo = idjogo;
        changeSupport.firePropertyChange("idjogo", oldIdjogo, idjogo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        String oldGenero = this.genero;
        this.genero = genero;
        changeSupport.firePropertyChange("genero", oldGenero, genero);
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjogo != null ? idjogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jogo)) {
            return false;
        }
        Jogo other = (Jogo) object;
        if ((this.idjogo == null && other.idjogo != null) || (this.idjogo != null && !this.idjogo.equals(other.idjogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
