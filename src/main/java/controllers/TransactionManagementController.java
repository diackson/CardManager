package controllers;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.catalina.Manager;

import models.CreditCard;
import models.Role;
import models.SessionInfo;
import models.UserTransact;
import services.CardService;




@Named
@SessionScoped
public class TransactionManagementController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 0;

	@Inject 
	private SessionInfo sessionInfo;

	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}
	
	private UserTransact managedTransaction ;
	@Inject
	private FacesContext facesContext;

//	@Inject
//	private CardService cardService;
//
//	private CreditCard managedCard;
//
//	public CreditCard getManagedCard() {
//		return managedCard;
//	}
//
//	public String doDeleteCard(final boolean delete) {
//		if (delete) {
//			cardService.deleteCard(managedCard);
//		}
//		managedCard = null;
//		return "cartemanagement";
//	}
//	public String doNewCard() {
//		
//		if (cardService.getCardByNum(managedCard.getCcNumber()) != null) {
//			facesContext.addMessage("La Carte de credit existe dejà", new FacesMessage("La Carte de credit existe"));
//			return null;
//		} else {
//			managedCard.setUser(sessionInfo.getUser());
//			cardService.saveCard(managedCard);
//
//			return "cardmanagement";
//		}
//	}
//	public String doSaveCard(final boolean save) {
//		if (save) {
//			managedCard.setUser(sessionInfo.getUser());
//			cardService.saveCard(managedCard);
//			facesContext.addMessage("Carte de Credit Ajoutee", new FacesMessage("La Carte a ete ajoutee "));
//		}
//		
//		
//		
//		managedCard = null;
//		return "cardmanagement";
//	}
//	@Produces
//	@Named
//	@RequestScoped
//	public List<CreditCard> getAllCard(){
//		if(sessionInfo.getUser().getRole() == Role.ADMIN){
//			return Collections.emptyList();
//		}else{
//			return cardService.getCardByUserId(sessionInfo.getUser().getUserId());	
////			return cardService.getAllCard();
//		}
//		
//	}
//	public String getUserName(){
//		return sessionInfo.getUser().getNom();
//	}
//	public String prepareDeleteCard(final CreditCard creditCard) {
//		managedCard = creditCard;
//		return "deletecard";
//	}
//
//
//	public String prepareEditCard(final CreditCard creditCard) {
//		managedCard = creditCard;
//		return "editcard";
//	}

	public String prepareNewTransaction() {
		managedTransaction = new UserTransact(); 
		return "addTransaction";
	}




}
