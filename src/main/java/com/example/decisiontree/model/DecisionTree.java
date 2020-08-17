package com.example.decisiontree.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Optional;

@Document(collection = "decisionTree")
public class DecisionTree {
    @Id
    private String id;
    @Indexed(unique=true)
    private String name;
    private List<Node> nodes;
    private List<Rule> rules;

    public DecisionTree(String name, List<Node> nodes, List<Rule> rules) {
        this.name = name;
        this.nodes = nodes;
        this.rules = rules;
    }

    public DecisionTree() {
    }

    public String getName() {
        return name;
    }

    public Optional<Node> getNextNode(String questionId, List<String> answers){
        String nextId = rules.stream().filter(r ->
                r.getQuestionId().equals(questionId))
                .filter(r -> r.getValueEquals().containsAll(answers))
                .findFirst()
                .get()
                .getGoesTo();

        return nodes.stream().filter(n -> n.getId().equals(nextId)).findFirst();
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Rule> getRules() {
        return rules;
    }
}
