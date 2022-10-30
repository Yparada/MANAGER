package com.udevtools.service;

import com.udevtools.entity.State;
import com.udevtools.entity.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getByState(State state);
    public Task getById(long id);
    public Task createTask(Task task);
    public Task updateTask(Task task);
    public Task deleteTask(Long id);
    public List<Task> getAllTask ();
}
