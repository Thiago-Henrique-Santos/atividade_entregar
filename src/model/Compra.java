/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Paulo
 */
@Entity
@Table(name = "compra", catalog = "db_relatorio_jogos", schema = "")
public class Compra implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcompra")
    private Integer idcompra;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    
    //Muitas compras podem ser feitas por um jogador
    @ManyToOne
    private Jogador jogador;
    //Muitas compras podem ser feitas em uma loja
    @ManyToOne
    private Lojadejogos lojaDeJogos;
    //Muitas compras podem incluir um (o mesmo) jogo
    @ManyToOne
    private Jogo jogo;

    public Compra() {
    }

    public Compra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        Integer oldIdcompra = this.idcompra;
        this.idcompra = idcompra;
        changeSupport.firePropertyChange("idcompra", oldIdcompra, idcompra);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        Date oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        Jogador oldJogador = this.jogador;
        this.jogador = jogador;
        changeSupport.firePropertyChange("jogador", oldJogador, jogador);
    }

    public Lojadejogos getLojaDeJogos() {
        return lojaDeJogos;
    }

    public void setLojaDeJogos(Lojadejogos lojaDeJogos) {
        Lojadejogos oldLojaDeJogos = this.lojaDeJogos;
        this.lojaDeJogos = lojaDeJogos;
        changeSupport.firePropertyChange("lojaDeJogos", oldLojaDeJogos, lojaDeJogos);
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        Jogo oldJogo = this.jogo;
        this.jogo = jogo;
        changeSupport.firePropertyChange("jogo", oldJogo, jogo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompra != null ? idcompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idcompra == null && other.idcompra != null) || (this.idcompra != null && !this.idcompra.equals(other.idcompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Compra[ idcompra=" + idcompra + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
