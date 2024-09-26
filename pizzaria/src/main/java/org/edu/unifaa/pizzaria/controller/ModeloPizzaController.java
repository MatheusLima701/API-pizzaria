package org.edu.unifaa.pizzaria.controller;

import org.edu.unifaa.pizzaria.model.ModeloPizza;
import org.edu.unifaa.pizzaria.service.ModeloPizzaService;
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
@RequestMapping("/api/modelo-pizzas")
public class ModeloPizzaController {
    
    @Autowired
    private ModeloPizzaService modeloPizzaService;

    @GetMapping   
    public ResponseEntity<List<ModeloPizza>> obterTodos(){
        return ResponseEntity.ok(modeloPizzaService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ModeloPizza>> obterPorId(@PathVariable long id){
        return ResponseEntity.ok(modeloPizzaService.obterPorId(id));
    }

    @PostMapping    
    public ResponseEntity<ModeloPizza> adicionar(@RequestBody ModeloPizza modeloPizza){
        var modeloPizzaCriado = modeloPizzaService.adicionar(modeloPizza);
        return new ResponseEntity<>(modeloPizzaCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloPizza> atualizar(@PathVariable long id, @RequestBody ModeloPizza modeloPizza){
        return ResponseEntity.ok(modeloPizzaService.atualizar(id, modeloPizza));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        modeloPizzaService.deletar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // CRUD (GET, POST, PUT e DELETE) // Mais indo ao banco de dados.


}

