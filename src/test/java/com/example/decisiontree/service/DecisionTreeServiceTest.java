package com.example.decisiontree.service;

import com.example.decisiontree.model.Answer;
import com.example.decisiontree.model.DecisionTree;
import com.example.decisiontree.model.Node;
import com.example.decisiontree.model.Rule;
import com.example.decisiontree.repository.DecisionTreeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DecisionTreeServiceTest {

    @Mock
    DecisionTreeRepository repository;

    @InjectMocks
    DecisionTreeService service;

    @Test
    public void deveria_encaminhar_resposta_certa() {
        Node initialNode = new Node("q0", "question", "questao1", Collections.singletonList("sim"));
        Node finalNode = new Node("d1", "answer", "resposta1", null);
        List<Node> nodes = asList(initialNode, finalNode);
        Rule rule = new Rule("q0", Collections.singletonList("sim"), "d1");

        DecisionTree tree = new DecisionTree("foo", nodes, Collections.singletonList(rule));

        Answer answer = new Answer("foo", "q0", Collections.singletonList("sim"));
        Node answerNode = new Node("d1", "answer", "resposta1", null);

        when(repository.findByName("foo")).thenReturn(Optional.of(tree));

        assertThat(service.getNextNode(answer), equalTo(Optional.of(finalNode)));
    }
}