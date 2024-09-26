package org.edu.unifaa.pizzaria.repository;

import org.edu.unifaa.pizzaria.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{
    
}
