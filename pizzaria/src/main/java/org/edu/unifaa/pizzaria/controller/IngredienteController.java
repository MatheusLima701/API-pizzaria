package org.edu.unifaa.pizzaria.controller;

import org.edu.unifaa.pizzaria.model.Ingrediente;
import org.edu.unifaa.pizzaria.service.IngredienteService;
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
@RequestMapping("/api/ingredientes")
public class IngredienteController {
    
    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping   
    public ResponseEntity<List<Ingrediente>> obterTodos(){
        return ResponseEntity.ok(ingredienteService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Ingrediente>> obterPorId(@PathVariable long id){
        return ResponseEntity.ok(ingredienteService.obterPorId(id));
    }

    @PostMapping    
    public ResponseEntity<Ingrediente> adicionar(@RequestBody Ingrediente ingrediente){
        var ingredienteCriado = ingredienteService.adicionar(ingrediente);
        return new ResponseEntity<>(ingredienteCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingrediente> atualizar(@PathVariable long id, @RequestBody Ingrediente ingrediente){
        return ResponseEntity.ok(ingredienteService.atualizar(id, ingrediente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        ingredienteService.deletar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // CRUD (GET, POST, PUT e DELETE) // Mais indo ao banco de dados.


}

