package org.lessons.java.demo.repository;

import java.util.List;

import org.lessons.java.demo.model.Pizzeria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizzeria, Integer> {
    public List<Pizzeria> findByNameContainingIgnoreCase(String name);
}
