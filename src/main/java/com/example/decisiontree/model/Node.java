package com.example.decisiontree.model;

import java.util.List;

public class Node {
    private String id;
    private String type;
    private String text;
    private List<String> possibleValues;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public List<String> getPossibleValues() {
        return possibleValues;
    }
}
