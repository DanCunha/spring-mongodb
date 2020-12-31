package com.springdata.mongo.controller;

import com.springdata.mongo.model.Funcionario;
import com.springdata.mongo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<Funcionario> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Funcionario findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Funcionario save(@RequestBody Funcionario funcionario) {
        return service.save(funcionario);
    }

    @GetMapping("/range")
    public List<Funcionario> obterFuncionarioRangeIdade(@RequestParam("de") Integer de,
                                                        @RequestParam("ate") Integer ate) {
        return service.obterFuncionarioRangeIdade(de, ate);
    }

    @GetMapping("/nome")
    public List<Funcionario> findByNome(@RequestParam("nome") String nome) {
        return service.findByNome(nome);
    }
}
