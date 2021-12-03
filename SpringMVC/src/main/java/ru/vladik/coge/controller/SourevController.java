package ru.vladik.coge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SourevController {
    
    @GetMapping("Hello")
    public String SourevHello(@RequestParam(value = "name", required = false)String name,
                              @RequestParam(value = "user", required = false)String user,
                              Model model){
        model.addAttribute("messege",name + user);

        return "Sourev/Hello";
    } 
    @GetMapping("GoogBye")
    public String SourevGoogBye(){
        return "Sourev/GoogBye";
    }
    @GetMapping("Exit")
    public String SourevExit(){
        return "Sourev/Exit";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a") int a,
                             @RequestParam(value = "b") int b,
                             @RequestParam(value = "action") String action,
                             Model model) {

        double number;

        switch (action) {
            case "*":
                number = a * b;
                break;
            case "/":
                number = a / (double) b;
                break;
            case "-":
                number = a - b;
                break;
            case "+":
                number = a + b;
                break;
            default:
                number = 0;
                break;
        }

        model.addAttribute("calculator", number);

        return "Sourev/Calculator";
    }
}
