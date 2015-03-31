package metier;

public class Ligue {
	private int id;
	private String nom;
	private Salariee admin;
	
	
	public Ligue(int id, String nom, Salariee admin)
	{
		this.id=id;
		this.nom=nom;
		this.admin=admin;
		
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	

	public void setNom(String nom)
	{
		this.nom=nom;
	}
	
	
	//Ajouter une nouvelle ligue
	
	//Supprimer ligue
		
	//Afficher la liste des ligues
	
}
