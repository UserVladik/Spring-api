package org.add.controller;

import org.add.dao.PersonDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class SpringController {

    public  final PersonDAO personDAO;

    public SpringController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("person", personDAO.index());
        return "index";
    }
    
    @GetMapping("/persons")
    public String show(){

        return "show";
    }
    
}
