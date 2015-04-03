package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metier.Salariee;
import library.MysqlAccess;

public class LigueBdd {
	MysqlAccess acces= new MysqlAccess();
	
	// ajouter une ligue
	public void ajoutLigue(String nom) 
	{
		Statement st=acces.getDbConnexion();
		if(st!=null)
		{			
			//requete sql
			String sql=" Insert into ligue(libelle) values ('"+ nom+"')";
			try {
				st.executeUpdate(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acces.closeDbConnexion();
		}
		
	}
	
	//afficher la liste des ligues
	public void afficherLigue()
	{
		Statement st=acces.getDbConnexion();
		ResultSet result=null;
		if(st!=null)
		{
			//requete sql
			String sql="Select * from ligue";			
			try	{
				result= st.executeQuery(sql);				
				while ( result.next() )
				{
					    int idLigue = result.getInt( "id" );
					    String nomLigue = result.getString( "libelle" );	      
					    //Affichage du resultat
					    System.out.print(idLigue);
					    System.out.println(nomLigue);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		acces.closeDbConnexion();
	}
	
	//supprimer ligue
	public void supprimerLigue(int id_ligue) 
	{
		Statement st=acces.getDbConnexion();
		
		if(st!=null)
		{			
			//requete sql
			String sql="delete from ligue where id_ligue='"+id_ligue+"'";			
			try {
				st.executeQuery(sql);	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acces.closeDbConnexion();
		}
		
	}
	
	//selectionner une ligue	
	public void selectLigue(int id_ligue) 
	{
		Statement st=acces.getDbConnexion();
		
		if(st!=null)
		{			
			//requete sql
			String sql="select * from ligue where id_ligue='"+id_ligue+"'";			
			try {
				st.executeQuery(sql);	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acces.closeDbConnexion();
		}
		
	}
	
	//modifier administrateur d'une ligue
	public void ModifierAdminLigue(int id_ligue, int id_salariee) 
	{
		Statement st=acces.getDbConnexion();
		
		if(st!=null)
		{			
			//requete sql ( on suppose qu'il y'a une ligne id_salariee dans ligue --A confirmer )
			String sql="update ligue set id_salariee='"+id_salariee+"'"+" where id_ligue='"+id_ligue+"'";			
			try {
				st.executeQuery(sql);	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acces.closeDbConnexion();
		}
		
	}
	
	
	//modifier le nom d'une ligue
	public void ModifierNomLigue(int id_ligue, String nom_ligue) 
	{
		Statement st=acces.getDbConnexion();
		
		if(st!=null)
		{			
			//requete sql ( on suppose qu'il y'a une ligne id_salariee dans ligue --A confirmer )
			String sql="update ligue set nom_ligue='"+nom_ligue+"'"+" where id_ligue='"+id_ligue+"'";			
			try {
				st.executeQuery(sql);	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acces.closeDbConnexion();
		}
		
	}
}
