package ar.edu.davinci.parcial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/test")
    public String test() {
        return "Estoy conectado viteh";
    }


}

