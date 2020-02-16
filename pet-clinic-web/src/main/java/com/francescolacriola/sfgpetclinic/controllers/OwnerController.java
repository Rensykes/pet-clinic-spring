package com.francescolacriola.sfgpetclinic.controllers;

import com.francescolacriola.sfgpetclinic.model.Owner;
import com.francescolacriola.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model){


        List<Owner> aList =  ownerService.findAll().stream().collect(Collectors.toList());

        model.addAttribute("owners", aList);

        List<Owner> sortedList = aList.stream()
                .sorted(Comparator.comparing(Owner::getFirstName))
                .collect(Collectors.toList());

        model.addAttribute("owners", sortedList);

        //model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }
}
