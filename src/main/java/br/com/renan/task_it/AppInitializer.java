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
		// Inicializa o repositório e o serviço
		FileRepository fileRepository = new FileRepository(); // TODO Talvez precise passar um caminho de arquivo aqui
		taskService = new TaskService(fileRepository);

		// Armazena o serviço no contexto
		sce.getServletContext().setAttribute("taskService", taskService);
		System.out.println("Aplicação iniciada e TaskService configurado!");

		// Configura o Jersey
		ServletContext context = sce.getServletContext();
		context.addServlet("JerseyServlet", new ServletContainer(new JerseyConfig()))
			.addMapping("/api/*");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// Libera recursos se necessário. Ex.: Fechar conexão do BD, etc.
		System.out.println("Aplicação parada!");
	}
}
