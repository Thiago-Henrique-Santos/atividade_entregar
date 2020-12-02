/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
@Table(name = "jogador", catalog = "db_relatorio_jogos", schema = "")
public class Jogador implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjogador")
    private Integer idjogador;
    @Column(name = "nome")
    private String nome;
    @Column(name = "idade")
    private Integer idade;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "endereco")
    private String endereco;
    
    //Um jogador pode fazer várias compras
    @OneToMany(mappedBy = "jogador")
    private List<Compra> compras = new ArrayList<>();

    public Jogador() {
    }

    public Jogador(Integer idjogador) {
        this.idjogador = idjogador;
    }

    public Integer getIdjogador() {
        return idjogador;
    }

    public void setIdjogador(Integer idjogador) {
        Integer oldIdjogador = this.idjogador;
        this.idjogador = idjogador;
        changeSupport.firePropertyChange("idjogador", oldIdjogador, idjogador);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        Integer oldIdade = this.idade;
        this.idade = idade;
        changeSupport.firePropertyChange("idade", oldIdade, idade);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
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
        hash += (idjogador != null ? idjogador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jogador)) {
            return false;
        }
        Jogador other = (Jogador) object;
        if ((this.idjogador == null && other.idjogador != null) || (this.idjogador != null && !this.idjogador.equals(other.idjogador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Jogador[ idjogador=" + idjogador + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
