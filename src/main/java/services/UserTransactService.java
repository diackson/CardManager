package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import models.UserTransact;


@Stateless
public class UserTransactService {
	
	@Inject
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<UserTransact> getAll(){
		
		return entityManager.createQuery("select uT from UserTransact uT", UserTransact.class).getResultList();
		
	}
//	public CreditCard getCardByNum(final Long num){
//		return entityManager.find(CreditCard.class, num);
//		
//	}
	
	public void saveTransact(final UserTransact userTransact) {
		System.out.println(userTransact.toString());
		entityManager.merge(userTransact);
//		entityManager.persist(creditCard);
	}
	
	public void deleteCard(final UserTransact userTransact) {		
		entityManager.remove(userTransact);
	}
//	public CreditCard getCardById(final String cardId){
//		return entityManager.find(CreditCard.class, cardId);
//		
//	}
//	public List <CreditCard> getCardByUserId(final long userId){
//		return entityManager.createQuery("select distinct c from CreditCard c join c.user u where u.id = :userId", CreditCard.class)
//				.setParameter("userId", userId).getResultList();
//	}
	

}
