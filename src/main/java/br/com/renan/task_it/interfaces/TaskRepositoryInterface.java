package br.com.renan.task_it.interfaces;

import java.util.List;

import br.com.renan.task_it.models.Task;

public interface TaskRepositoryInterface {
		void save(Task task);
	    Task findById(String id);
	    List<Task> findAll();
	    void update(Task task);
	    void delete(String id);
}
