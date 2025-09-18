package org.lesson.java.spring_la_mia_pizzeria_relazioni.controllers;

import org.lesson.java.spring_la_mia_pizzeria_relazioni.model.Offering;
import org.lesson.java.spring_la_mia_pizzeria_relazioni.model.Pizza;
import org.lesson.java.spring_la_mia_pizzeria_relazioni.repo.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferRepository repository;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("offering") Offering formOffering, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "/offerings/create";
        }

        repository.save(formOffering);

        return "redirect:/pizzas";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        model.addAttribute("offering", repository.findById(id).get());

        return "/offerings/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("offering") Offering formOffering,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "/offerings/edit";
        }

        formOffering.setId(id);
        repository.save(formOffering);

        return "redirect:/pizzas";
    }

}
