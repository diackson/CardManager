package controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import services.UserService;
import models.SessionInfo;
import models.User;


@Named
@RequestScoped
public class LoginController {
	
	@Inject
	private UserService userService;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private SessionInfo sessionInfo;
	
	private String login;
	
	private String password;
	
	public String authenticate(){
		final User user = userService.getUserByLogin(login);
	    if (user == null) {
	      facesContext.addMessage(null, new FacesMessage("Nom d'utilisateur Incorrect"));
	    } else {
	      if (user.getPassword().equals(password)) {
	        sessionInfo.setUser(user);
	        return "index";
	      } else {
	        facesContext.addMessage(null, new FacesMessage("Mot de passe Incorrect"));
	      }
	    }
	    return null;			
	}
	
	public String logout(){
		sessionInfo.setUser(null);
	    facesContext.getExternalContext().invalidateSession();
	    return "index";
		
	}

	public FacesContext getFaceContext() {
		return facesContext;
	}

	public void setFaceContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}

	public void setSessionInfo(SessionInfo sessionInfo) {
		this.sessionInfo = sessionInfo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
