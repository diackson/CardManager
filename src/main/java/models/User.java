package models;


import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Classe User pour enregistrer les utilisateurs
 */

@Entity
public class User implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** L'Id */
	@Id
	@GeneratedValue
	private long id;

	/** Le login. */
	@Column(unique = true)
	private String login;

	/** Le nom */
	private String nom;

	/** Le prenom */
	private String prenom;

	/** Le mot de Passe. */
	private String password;

	/** Le role de l'utilisateur. */
	private Role role;
	
//	private String country;	
//	
//	private String bankName;
	
	@OneToMany(mappedBy="user",orphanRemoval = true)
	private List<CreditCard> creditCards ;
	
	
	
    public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public void addCreditCard(CreditCard cc) {
        this.creditCards.add(cc);
        if (cc.getUser() != this) {
            cc.setUser(this);
        }
    }
	

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final User other = (User) obj;
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		return true;
	}

	/**
	 * Methode pour récupérer l'id
	 */
	public long getUserId() {
		return id;
	}

	/**
	 * methode pour récupérer le login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Methode pour récupérer le mot de passe.
	 */
	public String getPassword() {
		return password;
	}

	public Role getRole() {
		return role;
	}


	public void setUserId(final long id) {
		this.id = id;
	}


	public void setLogin(final String login) {
		this.login = login;
	}


	public void setPassword(final String password) {
		this.password = password;
	}

	public void setRole(final Role role) {
		this.role = role;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	

	
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", firstname=" + prenom +", name=" + nom + /*
		 * ", password="
		 * +
		 * password
		 * +
		 */", role=" + role + "]";
	}
}

