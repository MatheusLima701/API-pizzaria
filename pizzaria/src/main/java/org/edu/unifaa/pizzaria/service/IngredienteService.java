package org.edu.unifaa.pizzaria.service;

import org.edu.unifaa.pizzaria.model.Ingrediente;
import org.edu.unifaa.pizzaria.model.excetion.ResourceBadRequestException;
import org.edu.unifaa.pizzaria.model.excetion.ResourceNotFoundException;
import org.edu.unifaa.pizzaria.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;


@Service
public class IngredienteService {
    
    @Autowired //To pedindo o controle dessa classe para eu utilizar.
    private IngredienteRepository ingredienteRepository;

    public Ingrediente adicionar(Ingrediente ingrediente){
        // Aqui eu poderia validar se todos os dados obrigatorios do ingrediente estão corretos.

        if(ingrediente.getNome().equals("")){
            throw new ResourceBadRequestException("O nome do ingrediente é obrigatorio.");
        }

        ingrediente.setId(0);
        return ingredienteRepository.save(ingrediente);
    }

    public List<Ingrediente> obterTodos(){
        return ingredienteRepository.findAll();
    }

    public Optional<Ingrediente> obterPorId(long id){

        Optional<Ingrediente> ingredienteLocalizado = ingredienteRepository.findById(id);

        if(ingredienteLocalizado.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel encontrar um ingrediente com o id: " + id);
        }

        return ingredienteLocalizado;
    }

    public Ingrediente atualizar(long id, Ingrediente ingrediente){

        obterPorId(id);
        ingrediente.setId(id);

        if(ingrediente.getNome().equals("")){
            throw new ResourceBadRequestException("O nome do ingrediente é obrigatorio.");
        }

        return ingredienteRepository.save(ingrediente);
    }

    public void deletar(long id){
        obterPorId(id);
        ingredienteRepository.deleteById(id);
    }

}
