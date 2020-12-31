package com.springdata.mongo.service.impl;

import com.springdata.mongo.model.Funcionario;
import com.springdata.mongo.repository.FuncionarioRepository;
import com.springdata.mongo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public List<Funcionario> getAll() {
        return repository.findAll();
    }

    @Override
    public Funcionario findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não existe"));
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        Funcionario chefe = repository.findById(funcionario.getChefe().getCodigo())
                .orElseThrow(() -> new IllegalArgumentException("Chefe inexistente"));
        funcionario.setChefe(chefe);
        return repository.save(funcionario);
    }

    @Override
    public List<Funcionario> obterFuncionarioRangeIdade(Integer de, Integer ate) {
        return repository.obterFuncionarioRangeIdade(de, ate);
    }

    @Override
    public List<Funcionario> findByNome(String nome) {
        return repository.findByNome(nome);
    }
}
