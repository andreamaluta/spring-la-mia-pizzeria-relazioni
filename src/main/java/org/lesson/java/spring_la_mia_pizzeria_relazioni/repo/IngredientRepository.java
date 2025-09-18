package org.lesson.java.spring_la_mia_pizzeria_relazioni.repo;

import org.lesson.java.spring_la_mia_pizzeria_relazioni.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

}
