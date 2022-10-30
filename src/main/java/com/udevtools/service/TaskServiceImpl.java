package com.udevtools.service;

import com.udevtools.entity.State;
import com.udevtools.entity.Task;
import com.udevtools.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getByState(State state) {
        return taskRepository.findByState(state);
    }

    @Override
    public Task getById(long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {

        Task taskdb = getById(task.getId());
        if (taskdb != null){
            Task task1 = Task.builder().id(task.getId()).title(task.getTitle()).description(task.getDescription()).state(task.getState()).build();
            return taskRepository.save(task1);
        }
        return null;
    }

    @Override
    public Task deleteTask(Long id) {
        Task taskdb = getById(id);
        if (taskdb != null){
            Task task1 = Task.builder().title(taskdb.getTitle()).description(taskdb.getDescription()).state(taskdb.getState()).build();
            taskRepository.delete(taskdb);
            return taskdb;
        }
        return null;
    }
}
