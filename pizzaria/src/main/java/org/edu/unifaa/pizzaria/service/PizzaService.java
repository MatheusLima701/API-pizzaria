package org.edu.unifaa.pizzaria.service;

import org.edu.unifaa.pizzaria.model.Pizza;
import org.edu.unifaa.pizzaria.model.excetion.ResourceBadRequestException;
import org.edu.unifaa.pizzaria.model.excetion.ResourceNotFoundException;
import org.edu.unifaa.pizzaria.repository.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PizzaService {
    
    @Autowired //To pedindo o controle dessa classe para eu utilizar.
    private PizzaRepository pizzaRepository;

    public Pizza adicionar(Pizza pizza){
        // Aqui eu poderia validar se todos os dados obrigatorios do pizza estão corretos.

        if(pizza.getNome().equals("")){
            throw new ResourceBadRequestException("O nome da Pizza é obrigatorio.");
        }

        pizza.setId(0);
        return pizzaRepository.save(pizza);
    }

    public List<Pizza> obterTodos(){
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> obterPorId(long id){

        Optional<Pizza> pizzaLocalizado = pizzaRepository.findById(id);

        if(pizzaLocalizado.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel encontrar um modelo de Pizza com o id: " + id);
        }

        return pizzaLocalizado;
    }

    public Pizza atualizar(long id, Pizza pizza){

        obterPorId(id);
        pizza.setId(id);

        if(pizza.getNome().equals("")){
            throw new ResourceBadRequestException("O nome da Pizza é obrigatorio.");
        }

        return pizzaRepository.save(pizza);
    }

    public void deletar(long id){
        obterPorId(id);
        pizzaRepository.deleteById(id);
    }

}
