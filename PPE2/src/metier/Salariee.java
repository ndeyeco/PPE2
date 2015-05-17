package metier;

public class Salariee {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private boolean admin;
	private Ligue ligue;

	public Salariee(String nom, String prenom, String email,
			String password) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		
	}
	
	public Salariee(int id,String nom, String prenom) {
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;		
	}
	
	
	
	
	public Salariee(int id, String nom, String prenom, String email) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;

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

	public Salariee(String nom, String prenom, String email, String password,boolean admin) {
		// TODO Auto-generated constructor stub
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.admin=false;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setprenom(String prenom) {
		this.prenom = prenom;
	}

}
