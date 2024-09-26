package org.edu.unifaa.pizzaria.service;

import org.edu.unifaa.pizzaria.model.ModeloPizza;
import org.edu.unifaa.pizzaria.model.excetion.ResourceBadRequestException;
import org.edu.unifaa.pizzaria.model.excetion.ResourceNotFoundException;
import org.edu.unifaa.pizzaria.repository.ModeloPizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ModeloPizzaService {
    
    @Autowired //To pedindo o controle dessa classe para eu utilizar.
    private ModeloPizzaRepository modeloPizzaRepository;

    public ModeloPizza adicionar(ModeloPizza modeloPizza){
        // Aqui eu poderia validar se todos os dados obrigatorios do modeloPizza estão corretos.

        if(modeloPizza.getTamanho().equals("")){
            throw new ResourceBadRequestException("O nome do modelo da Pizza é obrigatorio.");
        }

        modeloPizza.setId(0);
        return modeloPizzaRepository.save(modeloPizza);
    }

    public List<ModeloPizza> obterTodos(){
        return modeloPizzaRepository.findAll();
    }

    public Optional<ModeloPizza> obterPorId(long id){

        Optional<ModeloPizza> modeloPizzaLocalizado = modeloPizzaRepository.findById(id);

        if(modeloPizzaLocalizado.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel encontrar um modelo de Pizza com o id: " + id);
        }

        return modeloPizzaLocalizado;
    }

    public ModeloPizza atualizar(long id, ModeloPizza modeloPizza){

        obterPorId(id);
        modeloPizza.setId(id);

        if(modeloPizza.getTamanho().equals("")){
            throw new ResourceBadRequestException("O nome do modelo de Pizza é obrigatorio.");
        }

        return modeloPizzaRepository.save(modeloPizza);
    }

    public void deletar(long id){
        obterPorId(id);
        modeloPizzaRepository.deleteById(id);
    }

}
