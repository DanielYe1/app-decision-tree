package com.example.decisiontree.model;

import java.util.List;

public class Rule {
    private String id;
    private String questionId;
    private List<String> valueEquals;
    private String goesTo;

    public Rule(String questionId, List<String> valueEquals, String goesTo) {
        this.questionId = questionId;
        this.valueEquals = valueEquals;
        this.goesTo = goesTo;
    }

    public Rule() {
    }

    public String getId() {
        return id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public List<String> getValueEquals() {
        return valueEquals;
    }

    public String getGoesTo() {
        return goesTo;
    }
}
