package com.example.decisiontree.controller;

import com.example.decisiontree.model.Answer;
import com.example.decisiontree.model.DecisionTree;
import com.example.decisiontree.model.Node;
import com.example.decisiontree.service.DecisionTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DecisionTreeController {

    @Autowired
    DecisionTreeService service;

    @RequestMapping(value = "/node" ,method = RequestMethod.POST)
    public ResponseEntity getNextAnswer(@RequestBody Answer answer) {
        Optional<Node> nextNode = service.getNextNode(answer);
        if (nextNode.isPresent()) {
            return new ResponseEntity(nextNode.get(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity add(@RequestBody DecisionTree decisionTree) {
        DecisionTree added = service.add(decisionTree);
        return new ResponseEntity(decisionTree, HttpStatus.CREATED);
    }

}
