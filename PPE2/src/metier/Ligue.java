package metier;

public class Ligue {
	private int id;
	private String nom;	
	
	
	public Ligue(int id, String nom)
	{
		this.id=id;
		this.nom=nom;		
		
	}
	
	public Ligue( String nom)
	{
		this.nom=nom;		
		
	}
	public Ligue( int id)
	{
		this.id=id;			
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
