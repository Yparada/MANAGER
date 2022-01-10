package com.ytarama.service;

import com.ytarama.entity.State;
import com.ytarama.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService{

    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<State> getAllState() {
        return stateRepository.findAll();
    }

    @Override
    public State findStateById(Long id) {
        return stateRepository.findById(id).orElse(null);
    }

    @Override
    public State findStateByName(String name) {
        return stateRepository.findByName(name);
    }

    @Override
    public State createState(State state) {
        State statedb = stateRepository.findByName(state.getName());

        if (statedb != null){
            return null;
        }
        return stateRepository.save(state);
    }

    @Override
    public State updateState(State state) {
        State statedb = stateRepository.findById(state.getId()).orElse(null);
        if (statedb == null){
            return null;
        }
        return stateRepository.save(state);
    }

    @Override
    public State deleteState(Long id) {
        State statedb = stateRepository.findById(id).orElse(null);
        if (statedb == null){
            return null;
        }
        stateRepository.delete(statedb);
        return statedb;
    }
}
