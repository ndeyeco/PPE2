package metier;

public class Salariee {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private boolean admin;
	private Ligue ligue;

	public Salariee(int id, String nom, String prenom, String email,
			String password, boolean admin) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.admin = admin;

	}

	public Salariee(int id, String nom, String prenom, String email,
			String password, boolean admin, Ligue ligue) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.admin = admin;
		this.ligue = ligue;

	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getprenom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setprenom(String prenom) {
		this.prenom = prenom;
	}

}
