package br.com.renan.task_it.controllers;

import java.util.List;

import br.com.renan.task_it.models.Task;
import br.com.renan.task_it.services.TaskService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tasks")
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTask(Task task) {
		taskService.save(task);
		return Response.status(Response.Status.CREATED).entity(task).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Task> getAllTasks() {
		return taskService.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTaskById(@PathParam("id") String id) {
		Task task = taskService.findById(id);
		if (task != null) {
			return Response.ok(task).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateTask(@PathParam("id") String id, Task task) {
		task.setId(id);
		taskService.update(task);
		return Response.ok(task).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteTask(@PathParam("id") String id) {
		taskService.delete(id);
		return Response.noContent().build();
	}

	@GET
	@Path("/teste")
	@Produces(MediaType.APPLICATION_JSON)
	public String hello() {
	    return "Hello";
	}

}
