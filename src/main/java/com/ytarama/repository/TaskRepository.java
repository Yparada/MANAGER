package com.ytarama.repository;

import com.ytarama.entity.State;
import com.ytarama.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findByState(State state);
    public Task findById(long id);
}
