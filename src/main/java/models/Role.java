package models;

public enum Role {
	
	/** Le gérant */
	  ADMIN("Administrateur"),
	  /** Les serveurs */
	  CLIENT("client");
	  
	  /** The name. */
	  private String nom;

	  Role(final String nom) {
	    this.nom = nom;
	  }

	  @Override
	  public String toString() {
	    return nom;
	  }

}
