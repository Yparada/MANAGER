package com.ytarama.repository;

import com.ytarama.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
    public State findById(long id);
    public State findByName(String name);
}
