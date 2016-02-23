package controllers;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;



import models.CreditCard;
import models.Role;
import models.SessionInfo;
import models.UserTransact;
import services.UserTransactService;




@Named
@SessionScoped
public class UserTransactManagementController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 0;

	@Inject
	private FacesContext facesContext;

	@Inject
	private UserTransactService transactService;
	
	@Inject 
	private SessionInfo sessionInfo;

	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}

	private UserTransact managedTransaction ;



	public UserTransact getManagedTransaction() {
		return managedTransaction;
	}
	

	public String doNewTransact() {	
		System.out.println(managedTransaction.toString());

//		CreditCard cc = new CreditCard();
//
//		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//
//		managedTransaction.setUser(sessionInfo.getUser().getNom());
//		managedTransaction.setCcNumber(Long.toString(cc.getCcNumber()));
//		managedTransaction.setTransactionDate(date);
//		if((managedTransaction.getAmount() > cc.getPlafond()) || (managedTransaction.getAmount()) < cc.getMinSolde()){
//			managedTransaction.setTransactStatut("FAILED");
//		}else{
//			managedTransaction.setTransactStatut("OK");
//		}
//		transactService.saveTransact(managedTransaction);

		return "cardmanagement";

	}
	public String doSaveTransact(final boolean save) {
		if (save) {
			CreditCard cc = new CreditCard();
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			managedTransaction.setUser(sessionInfo.getUser().getNom());
			managedTransaction.setCcNumber(Long.toString(cc.getCcNumber()));
			managedTransaction.setTransactionDate(date);
			if((managedTransaction.getAmount() > cc.getPlafond()) || (managedTransaction.getAmount() < cc.getMinSolde())){
				managedTransaction.setTransactStatut("FAILED");
			}else{
				managedTransaction.setTransactStatut("OK");
			}
			transactService.saveTransact(managedTransaction);
			
			facesContext.addMessage("Transaction Effectuee ", new FacesMessage("Transaction sauvegardee "));

		}



		managedTransaction = null;
		return "addTransactiun";
	}
		@Produces
		@Named
		@RequestScoped
		public List<UserTransact> getAllTransact(){
			if(sessionInfo.getUser().getRole() == Role.CLIENT){
				return Collections.emptyList();
			}else{
				return transactService.getAll();
			}
		}
			

	public String prepareNewTransaction() {
		managedTransaction = new UserTransact(); 
		return "addTransaction";
	}




}
