package com.springdata.mongo.service;

import com.springdata.mongo.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    List<Funcionario> getAll();
    Funcionario findById(String id);
    Funcionario save(Funcionario funcionario);
    List<Funcionario> obterFuncionarioRangeIdade(Integer de, Integer ate);
    List<Funcionario> findByNome(String nome);
}
