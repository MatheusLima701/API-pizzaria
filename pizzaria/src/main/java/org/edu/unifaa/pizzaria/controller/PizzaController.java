package org.edu.unifaa.pizzaria.controller;

import org.edu.unifaa.pizzaria.model.Pizza;
import org.edu.unifaa.pizzaria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    
    @Autowired
    private PizzaService pizzaService;

    @GetMapping   
    public ResponseEntity<List<Pizza>> obterTodos(){
        return ResponseEntity.ok(pizzaService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pizza>> obterPorId(@PathVariable long id){
        return ResponseEntity.ok(pizzaService.obterPorId(id));
    }

    @PostMapping    
    public ResponseEntity<Pizza> adicionar(@RequestBody Pizza pizza){
        var pizzaCriado = pizzaService.adicionar(pizza);
        return new ResponseEntity<>(pizzaCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizza> atualizar(@PathVariable long id, @RequestBody Pizza pizza){
        return ResponseEntity.ok(pizzaService.atualizar(id, pizza));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        pizzaService.deletar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // CRUD (GET, POST, PUT e DELETE) // Mais indo ao banco de dados.


}

