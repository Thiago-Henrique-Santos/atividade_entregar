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
@Table(name = "lojadejogos", catalog = "db_relatorio_jogos", schema = "")
public class Lojadejogos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlojaDeJogos")
    private Integer idlojaDeJogos;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "endereco")
    private String endereco;
    
    //Uma loja de jogos pode realizar vender vários jogos
    @OneToMany(mappedBy = "lojaDeJogos")
    private List<Compra> compras = new ArrayList<>();

    public Lojadejogos() {
    }

    public Lojadejogos(Integer idlojaDeJogos) {
        this.idlojaDeJogos = idlojaDeJogos;
    }

    public Integer getIdlojaDeJogos() {
        return idlojaDeJogos;
    }

    public void setIdlojaDeJogos(Integer idlojaDeJogos) {
        Integer oldIdlojaDeJogos = this.idlojaDeJogos;
        this.idlojaDeJogos = idlojaDeJogos;
        changeSupport.firePropertyChange("idlojaDeJogos", oldIdlojaDeJogos, idlojaDeJogos);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        String oldCnpj = this.cnpj;
        this.cnpj = cnpj;
        changeSupport.firePropertyChange("cnpj", oldCnpj, cnpj);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
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
        hash += (idlojaDeJogos != null ? idlojaDeJogos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lojadejogos)) {
            return false;
        }
        Lojadejogos other = (Lojadejogos) object;
        if ((this.idlojaDeJogos == null && other.idlojaDeJogos != null) || (this.idlojaDeJogos != null && !this.idlojaDeJogos.equals(other.idlojaDeJogos))) {
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
