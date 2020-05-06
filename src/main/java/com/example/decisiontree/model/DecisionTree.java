package com.example.decisiontree.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "decisionTree")
public class DecisionTree {
    @Id
    private String id;
    @Indexed(unique=true)
    private String name;
    private List<Node> nodes;
    private List<Rule> rules;

    public String getName() {
        return name;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Rule> getRules() {
        return rules;
    }
}
