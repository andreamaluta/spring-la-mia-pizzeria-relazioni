package org.lesson.java.spring_la_mia_pizzeria_relazioni.controllers;

import java.util.List;

import org.lesson.java.spring_la_mia_pizzeria_relazioni.model.Offering;
import org.lesson.java.spring_la_mia_pizzeria_relazioni.model.Pizza;
import org.lesson.java.spring_la_mia_pizzeria_relazioni.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/pizzas")
public class BookController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping
    public String index(Model model) {
        List<Pizza> result = repository.findAll();
        model.addAttribute("list", result);

        return "/pizzas/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("pizza", repository.findById(id).get());

        return "/pizzas/show";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("pizza", new Pizza());

        return "/pizzas/create";
    }

    @PostMapping("/create")
    public String Store(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "/pizzas/create";
        }

        repository.save(formPizza);

        return "redirect:/pizzas";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        model.addAttribute("pizza", repository.findById(id).get());

        return "/pizzas/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("pizza") Pizza forPizza, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "/pizzas/edit";
        }

        repository.save(forPizza);

        return "redirect:/pizzas";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        repository.deleteById(id);

        return "redirect:/pizzas";
    }

    @GetMapping("/offers/{id}")
    public String offer(@PathVariable Integer id, Model model) {

        Offering offering = new Offering();
        offering.setPizza(repository.findById(id).get());

        model.addAttribute("offering", offering);

        return "offerings/create";
    }

}
