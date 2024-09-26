package org.edu.unifaa.pizzaria.repository;

import org.edu.unifaa.pizzaria.model.Ingrediente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository 
public class IngredienteRepository_old {
    // Aqui vai ser depois onde eu me comunico com o banco de dados.
    private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    private long ultimoId = 0;
    

    public Ingrediente adicionar(Ingrediente ingrediente){

        ultimoId++;
        ingrediente.setId(ultimoId);
        ingredientes.add(ingrediente);

        return ingrediente;
    }

    public List<Ingrediente> obterTodos(){
        return ingredientes;
    }

    public Ingrediente obterPorId(long id){

        for (Ingrediente ingrediente : ingredientes) {
            
            if(ingrediente.getId() == id){
                return ingrediente;
            }            
        }

        return new Ingrediente();
    }



}
