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
	
	
	
}
