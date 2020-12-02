/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")
    , @NamedQuery(name = "Compra.findByIdcompra", query = "SELECT c FROM Compra c WHERE c.idcompra = :idcompra")
    , @NamedQuery(name = "Compra.findByData", query = "SELECT c FROM Compra c WHERE c.data = :data")
    , @NamedQuery(name = "Compra.findByHora", query = "SELECT c FROM Compra c WHERE c.hora = :hora")
    , @NamedQuery(name = "Compra.findByJogadorIdjogador", query = "SELECT c FROM Compra c WHERE c.jogadorIdjogador = :jogadorIdjogador")
    , @NamedQuery(name = "Compra.findByLojaDeJogosidlojaDeJogos", query = "SELECT c FROM Compra c WHERE c.lojaDeJogosidlojaDeJogos = :lojaDeJogosidlojaDeJogos")
    , @NamedQuery(name = "Compra.findByJogoIdjogo", query = "SELECT c FROM Compra c WHERE c.jogoIdjogo = :jogoIdjogo")})
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
    @Column(name = "jogador_idjogador")
    private Integer jogadorIdjogador;
    @Column(name = "lojaDeJogos_idlojaDeJogos")
    private Integer lojaDeJogosidlojaDeJogos;
    @Column(name = "jogo_idjogo")
    private Integer jogoIdjogo;

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

    public Integer getJogadorIdjogador() {
        return jogadorIdjogador;
    }

    public void setJogadorIdjogador(Integer jogadorIdjogador) {
        Integer oldJogadorIdjogador = this.jogadorIdjogador;
        this.jogadorIdjogador = jogadorIdjogador;
        changeSupport.firePropertyChange("jogadorIdjogador", oldJogadorIdjogador, jogadorIdjogador);
    }

    public Integer getLojaDeJogosidlojaDeJogos() {
        return lojaDeJogosidlojaDeJogos;
    }

    public void setLojaDeJogosidlojaDeJogos(Integer lojaDeJogosidlojaDeJogos) {
        Integer oldLojaDeJogosidlojaDeJogos = this.lojaDeJogosidlojaDeJogos;
        this.lojaDeJogosidlojaDeJogos = lojaDeJogosidlojaDeJogos;
        changeSupport.firePropertyChange("lojaDeJogosidlojaDeJogos", oldLojaDeJogosidlojaDeJogos, lojaDeJogosidlojaDeJogos);
    }

    public Integer getJogoIdjogo() {
        return jogoIdjogo;
    }

    public void setJogoIdjogo(Integer jogoIdjogo) {
        Integer oldJogoIdjogo = this.jogoIdjogo;
        this.jogoIdjogo = jogoIdjogo;
        changeSupport.firePropertyChange("jogoIdjogo", oldJogoIdjogo, jogoIdjogo);
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
