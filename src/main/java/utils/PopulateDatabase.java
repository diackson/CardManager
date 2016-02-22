package utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import models.CreditCard;
import models.Role;
import models.User;


@Startup
@Singleton
public class PopulateDatabase {

	@Inject
	private EntityManager entityManager;	




	@PostConstruct
	void init(){

		entityManager.persist(newUser("Admin", "Admin", "admin", Role.ADMIN));
		entityManager.persist(newUser("diackson", "diackson", "diackson", Role.CLIENT));
				

	}
	private User newUser(final String login, final String nom, final String password, final Role role) {
		final User user = new User();
		user.setLogin(login);
		user.setNom(nom);
		user.setPassword(password);
		user.setRole(role);
		return user;
	}
//	private CreditCard newCarte(final String ccNumber,final String cardType,final String expiryDate,final String crypto,final double plafond,
//			final double minSolde){
//		final CreditCard creditCard =new CreditCard();
//		creditCard.setCcNumber(ccNumber);
//		creditCard.setCardType(cardType);
//		creditCard.setExpiryDate(expiryDate);
//		creditCard.setCrypto(crypto);
//		creditCard.setMinSolde(minSolde);
//		creditCard.setPlafond(plafond);
//		
//		return creditCard;
//	}

//	
//	private Clients newClients(final String country,final String bankName){
//		
//		final Clients client =new Clients();
//		
//		client.setCountry(country);
//		client.setBankName(bankName);
//		
//		return client;
//	}

}
