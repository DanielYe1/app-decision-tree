package com.example.decisiontree.repository;

import com.example.decisiontree.model.DecisionTree;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DecisionTreeRepository extends MongoRepository<DecisionTree, String> {
    Optional<DecisionTree> findByName(String name);
}
