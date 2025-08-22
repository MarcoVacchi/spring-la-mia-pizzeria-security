package org.lessons.java.demo.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pizzeria")

public class Pizzeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "The name mustn't be empty or null or blank, and must be min 5 char")
    private String name;

    @NotBlank(message = "The description mustn't be empty or null or blank, and must be min 10 char")
    @Lob
    private String description;

    @NotBlank(message = "The URLcode mustn't be empty or null or blank")
    private String pick;

    @NotNull
    @DecimalMin(value = "3.00", message = "Il prezzo deve essere almeno di 3 euro")
    private BigDecimal price;

    @NotBlank
    private String symbol;

    // SEZIONE DELLE RELAZIONI;

    @OneToMany(mappedBy = "pizze", cascade = { CascadeType.REMOVE })
    private List<Sale> sales;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "ingredient_pizzeria", joinColumns = @JoinColumn(name = "pizzeria_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients;

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    // FINE SEZIONE DELLE RELAZIONI;

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public List<Sale> getSales() {
        return this.sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPick() {
        return this.pick;
    }

    public void setPick(String pick) {
        this.pick = pick;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.name + this.description + this.pick + this.price + this.symbol;
    }

}
