package org.edu.unifaa.pizzaria.model;

import java.util.ArrayList;
import java.util.List;

import org.edu.unifaa.pizzaria.model.Enum.ETipoPizza;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPizza")
    private long id;

    @Column(nullable = false, unique = true)
    private String nome; 

    @ManyToMany
    @JoinTable(
        name = "pizza_modelo",
        joinColumns = @JoinColumn(name = "idPizza"),
        inverseJoinColumns = @JoinColumn(name = "idModeloPizza")
    )
    private List<ModeloPizza> modelos; 
    
    @ManyToMany
    @JoinTable(
        name = "pizza_ingredientes",
        joinColumns = @JoinColumn(name = "idPizza"),
        inverseJoinColumns = @JoinColumn(name = "idIngrediente")
    )
    private List<Ingrediente> ingredientes;

    @Column(nullable = false)
    private ETipoPizza tipo;

    @Column(nullable = false)
    private boolean ativa;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "idCupomDesconto")
    private CupomDesconto cupomDesconto;

    public CupomDesconto getCupomDesconto() {
        return cupomDesconto;
    }

    public void setCupomDesconto(CupomDesconto cupomDesconto) {
        this.cupomDesconto = cupomDesconto;
    }

    public Pizza(String nome, ETipoPizza tipo, boolean ativa, String observacao) {
        this.nome = nome;
        this.tipo = tipo;
        this.ativa = ativa;
        this.observacao = observacao;

        this.modelos = new ArrayList<ModeloPizza>();
        this.ingredientes = new ArrayList<Ingrediente>();
    }

    public Pizza(String nome, List<ModeloPizza> modelos, List<Ingrediente> ingredientes, ETipoPizza tipo, boolean ativa,
            String observacao) {
        this.nome = nome;
        this.modelos = modelos;
        this.ingredientes = ingredientes;
        this.tipo = tipo;
        this.ativa = ativa;
        this.observacao = observacao;
    }

    public Pizza() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<ModeloPizza> getModelos() {
        return modelos;
    }
    public void setModelos(List<ModeloPizza> modelos) {
        this.modelos = modelos;
    }
    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    public ETipoPizza getTipo() {
        return tipo;
    }
    public void setTipo(ETipoPizza tipo) {
        this.tipo = tipo;
    }
    public boolean isAtiva() {
        return ativa;
    }
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    
}
