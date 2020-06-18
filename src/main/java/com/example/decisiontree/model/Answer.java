package com.example.decisiontree.model;

import java.util.List;

public class Answer {
    private String treeName;
    private String questionId;
    private List<String> answers;

    public Answer(String treeName, String questionId, List<String> answers) {
        this.treeName = treeName;
        this.questionId = questionId;
        this.answers = answers;
    }

    public Answer() {
    }

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
