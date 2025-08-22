package org.lessons.java.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "sale")

public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pizzeria_id", nullable = false)
    private Pizzeria pizze;

    @NotBlank(message = "This field cannot be empty")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull(message = "The start sale cannot be null")
    private LocalDate startSale;

    @NotNull(message = "The end sale cannot be null")
    private LocalDate endSale;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pizzeria getPizze() {
        return this.pizze;
    }

    public void setPizze(Pizzeria pizze) {
        this.pizze = pizze;
    }

    public LocalDate getStartSale() {
        return this.startSale;
    }

    public void setStartSale(LocalDate startSale) {
        this.startSale = startSale;
    }

    public LocalDate getEndSale() {
        return this.endSale;
    }

    public void setEndSale(LocalDate endSale) {
        this.endSale = endSale;
    }

}
