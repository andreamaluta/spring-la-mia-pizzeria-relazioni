package org.lesson.java.spring_la_mia_pizzeria_relazioni.repo;

import org.lesson.java.spring_la_mia_pizzeria_relazioni.model.Offering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offering, Integer> {

}
