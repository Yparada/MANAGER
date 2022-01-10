package com.ytarama.service;

import com.ytarama.entity.State;

import java.util.List;

public interface StateService {
    public List<State> getAllState();
    public State findStateById(Long id);
    public State findStateByName(String name);
    public State createState(State state);
    public State updateState(State state);
    public State deleteState(Long id);
}
