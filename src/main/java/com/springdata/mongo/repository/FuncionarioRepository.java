package com.springdata.mongo.repository;

import com.springdata.mongo.model.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

    //$lte - less than equal
    @Query("{ $and: [ { 'idade': { $gt: ?0} }, { 'idade': { $lte: ?1 } } ] }")
    List<Funcionario> obterFuncionarioRangeIdade(Integer de, Integer ate);

    List<Funcionario> findByNome(String nome);
}
