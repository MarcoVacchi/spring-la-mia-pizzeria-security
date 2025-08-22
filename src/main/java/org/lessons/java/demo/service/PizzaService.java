package org.lessons.java.demo.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.demo.model.Pizzeria;
import org.lessons.java.demo.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzeRepository;

    public List<Pizzeria> findAll() {
        return pizzeRepository.findAll();
    };

    public List<Pizzeria> findByNameContaining(String name) {
        return pizzeRepository.findByNameContainingIgnoreCase(name);
    };

    public Pizzeria getById(Integer id) {

        return pizzeRepository.findById(id).get();
    }

    public Optional<Pizzeria> findById(Integer id) {
        return pizzeRepository.findById(id);
    }

    public Pizzeria create(Pizzeria pizza) {
        return pizzeRepository.save(pizza);
    }

    public Pizzeria update(Pizzeria pizza) {
        return pizzeRepository.save(pizza);
    }

    public void deleteById(Integer id) {
        pizzeRepository.deleteById(id);
    }

}
