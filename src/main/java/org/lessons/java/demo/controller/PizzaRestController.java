package org.lessons.java.demo.controller;

import java.util.List;
import java.util.Optional;

import org.lessons.java.demo.model.Pizzeria;
import org.lessons.java.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pizze/api")
public class PizzaRestController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public List<Pizzeria> index() {
        List<Pizzeria> pizze = pizzaService.findAll();
        return pizze;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizzeria> show(@PathVariable Integer id) {
        Optional<Pizzeria> pizzaSelected = pizzaService.findById(id);
        if (pizzaSelected.isEmpty()) {
            return new ResponseEntity<Pizzeria>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Pizzeria>(pizzaSelected.get(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Pizzeria> store(@RequestBody Pizzeria pizza) {
        return new ResponseEntity<Pizzeria>(pizzaService.create(pizza), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizzeria> update(@RequestBody Pizzeria pizza, @PathVariable Integer id) {
        if (pizzaService.findById(id).isEmpty()) {
            return new ResponseEntity<Pizzeria>(HttpStatus.NOT_FOUND);
        }
        pizza.setId(id);
        return new ResponseEntity<Pizzeria>(pizzaService.update(pizza), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pizzeria> delete(@PathVariable Integer id) {
        if (pizzaService.findById(id).isEmpty()) {
            return new ResponseEntity<Pizzeria>(HttpStatus.NOT_FOUND);
        }
        pizzaService.deleteById(id);
        return new ResponseEntity<Pizzeria>(HttpStatus.OK);
    }
}
