package models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class UserTransact implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long transactId;
	
	private double amount;
	private Date transactionDate;
	private String TransactStatut;
	private String User ;
	private String ccNumber;
	
	public Long getTransactId() {
		return transactId;
	}
	public void setTransactId(Long transactId) {
		this.transactId = transactId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	

	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getUser() {
		
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getCcNumber() {		
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public String getTransactStatut() {
		return TransactStatut;
	}
	public void setTransactStatut(String transactStatut) {
		TransactStatut = transactStatut;
	}

	
	 
	 

}
