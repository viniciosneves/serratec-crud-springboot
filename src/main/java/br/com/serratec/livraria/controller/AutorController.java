package br.com.serratec.livraria.controller;

import br.com.serratec.livraria.models.Autor;
import br.com.serratec.livraria.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @RequestMapping("/autores")
    public List<Autor> lista () {

        return  repository.findAll();
    }
}
