package org.lesson.java.spring_la_mia_pizzeria_relazioni.repo;

import org.lesson.java.spring_la_mia_pizzeria_relazioni.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
