package com.example.decisiontree.model;

import java.util.List;

public class Answer {
    private String treeName;
    private String questionId;
    private List<String> answers;

    public String getTreeName() {
        return treeName;
    }

    public String getQuestionId() {
        return questionId;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
