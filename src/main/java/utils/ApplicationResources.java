package utils;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@DataSourceDefinition(name = "java:app/jdbc/cardmanager", className = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource",
user = "cardmanager", password = "cardmanager", databaseName = "cardmanager", serverName = "localhost", portNumber = 3306)
public class ApplicationResources {
	
	  public static final String FACES_REDIRECT = "?faces-redirect=true";
	  
	  @Produces
	  @PersistenceContext
	  private EntityManager em;
	  
	  
	  
	  @Produces
	  @RequestScoped
	  public FacesContext getFacesContext() {
	    return FacesContext.getCurrentInstance();
	  }

	
	

}
