package org.lessons.java.demo.controller;

import org.lessons.java.demo.model.Sale;
import org.lessons.java.demo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleRepository saleRepository;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("sale") Sale formSale, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "sales/create-or-edit";
        }
        saleRepository.save(formSale);
        return "redirect:/pizze";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        model.addAttribute("sale", saleRepository.findById(id).get());
        model.addAttribute("edit", true);
        return "sales/create-or-edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        saleRepository.deleteById(id);
        return "redirect:/pizze";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("sale") Sale formSale, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "sales/create-or-edit";
        }
        saleRepository.save(formSale);
        return "redirect:/pizze/" + formSale.getPizze().getId();
    }
}
