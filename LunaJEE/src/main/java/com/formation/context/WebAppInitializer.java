package com.formation.context;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.apache.tiles.extras.complete.CompleteAutoloadTilesListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;



public class WebAppInitializer implements WebApplicationInitializer{

	/**
	 * Configuration du Conteneur Spring dans le fichier de configuration du conteneur Web : approche Java
	 * @return
	 */
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { ConteneurSpring.class };
	}

	/**
	 * Configuration du conteneur Web
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(getRootConfigClasses());

		ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootContext);
		servletContext.addListener(contextLoaderListener);

		FilterRegistration.Dynamic filter = servletContext.addFilter("StrutsDispatcher",
				new StrutsPrepareAndExecuteFilter());
		filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
		
		CompleteAutoloadTilesListener listener = new CompleteAutoloadTilesListener();
		servletContext.addListener(listener);
		
		

	}

	
	
	
	
}
