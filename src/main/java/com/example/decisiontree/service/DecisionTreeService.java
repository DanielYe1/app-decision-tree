package com.example.decisiontree.service;

import com.example.decisiontree.model.Answer;
import com.example.decisiontree.model.DecisionTree;
import com.example.decisiontree.model.Node;
import com.example.decisiontree.model.Rule;
import com.example.decisiontree.repository.DecisionTreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DecisionTreeService {

    @Autowired
    DecisionTreeRepository repository;

    public Optional<Node> getNextNode(Answer answer) {
        Optional<DecisionTree> tree = repository.findByName(answer.getTreeName());

        if (tree.isPresent()) {
            DecisionTree decisionTree = tree.get();

            return decisionTree.getNextNode(answer.getQuestionId(), answer.getAnswers());
        }
        return Optional.empty();
    }

    public DecisionTree add(DecisionTree tree){
        return repository.insert(tree);
    }

    public Boolean delete(String name){
        return repository.deleteByName(name) == 1L;
    }
}
