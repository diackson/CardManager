package models;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;



@Named
@SessionScoped
public class SessionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 0;
	
	  @Inject
	  FacesContext facesContext;


	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
		
	    facesContext.getExternalContext().getSessionMap().put("loggedin", user == null ? false : true);

	}

	@Override
	  public String toString() {
	    return "SessionInfo [user=" + user + "]";
	  }

}
