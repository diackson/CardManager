package controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import services.UserService;
import models.SessionInfo;
import models.User;

@Named
@SessionScoped
public class UserManagementController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 0;

	@Inject
	private SessionInfo sessionInfo;

	@Inject 
	UserService userService;

	@Inject
	private FacesContext facesContext;

	private User managedUser;

	public User getManagedUser() {
		return managedUser;
	}

	public String doNewUser() {
		if (userService.getUserByLogin(managedUser.getLogin()) != null) {
			facesContext.addMessage("L'utilisateur existe dejà", new FacesMessage("Le Login existe"));
			return null;
		} else {
			userService.saveUser(managedUser);
			return "usermanagement";
		}
	}

	public String doDeleteUser(final boolean delete) {
		if (delete) {
			userService.deleteUser(managedUser);
		}
		managedUser = null;
		return "usermanagement";
	}

	public String doSaveUser(final boolean save) {
		if (save) {
			userService.saveUser(managedUser);
			if (sessionInfo.getUser().getLogin().equals(managedUser.getLogin())) {

				sessionInfo.setUser(userService.getUserByLogin(managedUser.getLogin()));
			}
		}
		managedUser = null;
		return "usermanagement";
	}
	@Produces
	@Named
	@RequestScoped
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	public String prepareDeleteUser(final User user) {
		managedUser = user;
		return "deleteuser";
	}


	public String prepareEditUser(final User user) {
		managedUser = user;
		return "edituser";
	}

	public String prepareNewUser() {
		managedUser = new User();
		return "newuser";
	}

}
