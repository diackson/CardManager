package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CreditCard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** L'Id */
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique = true)
	private Long ccNumber;
	
	private String cardType;	
	private String expiryDate;
	private String crypto;
	private double plafond;
	private double minSolde;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USER_ID",nullable = false)
	private User user;
	 

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
        if (!user.getCreditCards().contains(this)) { 
            user.getCreditCards().add(this);
        }
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(Long ccNumber) {
		this.ccNumber = ccNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCrypto() {
		return crypto;
	}
	public void setCrypto(String crypto) {
		this.crypto = crypto;
	}

	public double getPlafond() {
		return plafond;
	}
	public void setPlafond(double plafond) {
		this.plafond = plafond;
	}
	public double getMinSolde() {
		return minSolde;
	}
	public void setMinSolde(double minSolde) {
		this.minSolde = minSolde;
	}
	
	@Override
	public String toString() {
//		return "CreditCard [id=" + id + ", ccNumber=" + ccNumber + ", expiryDate=" + expiryDate + ", crypto=" + crypto
//				+ ", userId=" + user +"]";
		return cardType +"," + ccNumber  ;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
}
