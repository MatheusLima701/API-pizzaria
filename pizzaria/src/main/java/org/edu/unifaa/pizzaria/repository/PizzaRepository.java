package org.edu.unifaa.pizzaria.repository;

import org.edu.unifaa.pizzaria.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PizzaRepository extends JpaRepository<Pizza, Long>{
    // Pizza findByNome(String nome);

    // @Query(nativeQuery = true, value = "Select * from xpto")
    // List<Pizza> obterPizzasAtivasComDesconto(double desconto)
}
