package services;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import models.CreditCard;


@Stateless
public class CardService {
	
	@Inject
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<CreditCard> getAllCard(){
		
		return entityManager.createQuery("select c from CreditCard c", CreditCard.class).getResultList();
		
	}
	public CreditCard getCardByNum(final Long num){
		return entityManager.find(CreditCard.class, num);
		
	}
	
	public void saveCard(final CreditCard creditCard) {
		System.out.println(creditCard.toString());
		entityManager.merge(creditCard);
//		entityManager.persist(creditCard);
	}
	
	public void deleteCard(final CreditCard creditCard) {		
		entityManager.remove(creditCard);
	}
	public CreditCard getCardById(final String cardId){
		return entityManager.find(CreditCard.class, cardId);
		
	}
	public List <CreditCard> getCardByUserId(final long userId){
		return entityManager.createQuery("select distinct c from CreditCard c join c.user u where u.id = :userId", CreditCard.class)
				.setParameter("userId", userId).getResultList();
	}
	

}
