package br.com.serratec.livraria.controller;

import br.com.serratec.livraria.models.Categoria;
import br.com.serratec.livraria.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaRepository repository;

    @RequestMapping("/categorias")
    public List<Categoria> lista () {

        return  repository.findAll();
    }
}
