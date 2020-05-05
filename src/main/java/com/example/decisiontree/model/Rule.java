package com.example.decisiontree.model;

import java.util.List;

public class Rule {
    private String id;
    private String questionId;
    private List<String> valueEquals;
    private String goesTo;

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
