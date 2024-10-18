package br.com.renan.task_it;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import org.glassfish.jersey.servlet.ServletContainer;

import br.com.renan.task_it.configs.JerseyConfig;
import br.com.renan.task_it.repositories.FileRepository;
import br.com.renan.task_it.services.TaskService;

@WebListener
public class AppInitializer implements ServletContextListener {

	private TaskService taskService;

	public void contextInitialized(ServletContextEvent sce) {
		// Inicializa o reposit�rio e o servi�o
		FileRepository fileRepository = new FileRepository(); // TODO Talvez precise passar um caminho de arquivo aqui
		taskService = new TaskService(fileRepository);

		// Armazena o servi�o no contexto
		sce.getServletContext().setAttribute("taskService", taskService);
		System.out.println("Aplica��o iniciada e TaskService configurado!");

		// Configura o Jersey
		ServletContext context = sce.getServletContext();
		context.addServlet("JerseyServlet", new ServletContainer(new JerseyConfig()))
			.addMapping("/api/*");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// Libera recursos se necess�rio. Ex.: Fechar conex�o do BD, etc.
		System.out.println("Aplica��o parada!");
	}
}
