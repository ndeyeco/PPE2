package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library.MysqlAccess;

public class SalarieeBdd
{	
	MysqlAccess acces= new MysqlAccess();		
	
	
	// Ajouter un nouveau salariee
	public  void AjoutSalariee(String nom, String prenom, String email)
	{			
		Statement st=acces.getDbConnexion();		
		if(st!=null)
		{
			//requete sql
			String sql=" Insert into utilisateur(nom,prenom,email, motdepasse) values ('"+ nom+"','"+prenom+"','"+email+"', '')";
			try {
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acces.closeDbConnexion();
		}
	}
	
	// Afficher l'ensemble des salariés d'une ligue donnée
	public void afficherSalariee(int id_ligue) 
	{
		Statement st=acces.getDbConnexion();
		ResultSet result=null;
		int idSalarie = 0;
		String nomSalarie = null;
		String prenomSalarie = null;
		String emailSalarie=null;
		String passwordSalarie=null;		
		if(st!=null)
		{			
			//requete sql
			String sql="Select * from utilisateur where id_ligue='"+id_ligue+"'";			
			try {
				result = st.executeQuery(sql);	
				while ( result.next()) 
				{					
					idSalarie = result.getInt( "id" );					
					nomSalarie = result.getString( "nom" );					
					prenomSalarie = result.getString( "prenom" );					
					emailSalarie = result.getString( "email" );					
					passwordSalarie = result.getString( "motdepasse" );	
				    // Affiche le resultat
				    System.out.println(idSalarie);
				    System.out.println(nomSalarie); 
				    System.out.println(prenomSalarie);
				    System.out.println(emailSalarie);
				    System.out.println(passwordSalarie);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acces.closeDbConnexion();
		}
		
	}
}
