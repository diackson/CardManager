package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import models.Role;
import models.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Stateless
public class UserService {

	private final Logger logger = LoggerFactory.getLogger(UserService.class);



	@Inject
	private EntityManager entityManager;

	public Logger getLogger() {
		return logger;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public List<User> getAllUsers() {
		return entityManager.createQuery("select u from User u", User.class).getResultList();
	}


	public List<User> getAllUsers(final Role role) {
		return entityManager.createQuery("select u from User u where u.role = :role", User.class)
				.setParameter("role", role).getResultList();
	}

	public User getUserById(final long userId) {
		return entityManager.find(User.class, userId);
	}


	public User getUserByLogin(final String login) {
		final TypedQuery<User> query = entityManager.createQuery("select u from User u where u.login like :login",
				User.class).setParameter("login", login);
		try {
			return query.getSingleResult();
		} catch (final PersistenceException ex) {
			return null;
		}
	}

	public void saveUser(final User user) {
		entityManager.merge(user);
	}

	  public void deleteUser(final User user) {
		    final User managedUser = getUserByLogin(user.getLogin());
		    if (managedUser != null) {
//		      // we need to delete rating using the user first
//		      entityManager.createQuery("delete from Rating r where r.userId = :userId")
//		          .setParameter("userId", managedUser.getId()).executeUpdate();
		      entityManager.remove(managedUser);
		    } else {
		      logger.warn("Impossible de supprimer un utilisateur inconnu {}", user);
		    }
		  }


}
