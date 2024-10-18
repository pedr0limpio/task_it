package br.com.renan.task_it.services;

import java.util.List;

import br.com.renan.task_it.interfaces.TaskRepositoryInterface;
import br.com.renan.task_it.models.Task;

public class TaskService {

	private final TaskRepositoryInterface taskRepository;

	public TaskService(TaskRepositoryInterface taskRepository) {
		this.taskRepository = taskRepository;
	}

	public void save(Task task) {
		// TODO Auto-generated method stub
		
	}

	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Task findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Task task) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
}