package org.lessons.java.demo.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @NotBlank(message = "The field name of ingredient cannot be empty")
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private List<Pizzeria> pizze;

    public Integer getId() {
        return this.id;
    }

    public List<Pizzeria> getPizze() {
        return this.pizze;
    }

    public void setPizze(List<Pizzeria> pizze) {
        this.pizze = pizze;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
