package dal;


import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;

import metier.Ligue;

import library.MysqlAccess;

public class LigueBdd {
	MysqlAccess acces= new MysqlAccess("ppe_personnel");
	
	// ajouter une ligue
	public Ligue ajoutLigue(String nom) 
	{
		Statement st=acces.getDbConnexion();
		if(st!=null)
		{			
			//requete sql
			String sql=" Insert into personnel_ligue(titreLigue) values ('"+ nom+"')";
			try {
				st.executeUpdate(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acces.closeDbConnexion();
		}
		
		return new Ligue(nom);
	}
	
	//Recupere le dernier Id ajouté
	
	public int lastId()
	{
		String lastid="";
		Statement st=acces.getDbConnexion();
		if(st!=null)
		{
			try {
				lastid=st.executeQuery("select last_insert_id() as last_id from personnel_ligue").getString("last_id");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return Integer.parseInt(lastid);
	}
	
		
	//afficher la liste des ligues
	public ArrayList<Ligue> afficherLigue()
	{
		ArrayList<Ligue> tableauLigues=new ArrayList<Ligue>(); 
		
		Statement st=acces.getDbConnexion();
		ResultSet result=null;
		if(st!=null)
		{
			//requete sql
			String sql="Select * from personnel_ligue";			
			try	{
				result= st.executeQuery(sql);				
				while ( result.next() )
				{
					    int idLigue = result.getInt( "idLigue" );
					    String nomLigue = result.getString( "titreLigue" );
					    tableauLigues.add(new Ligue(idLigue,nomLigue));
					   
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		acces.closeDbConnexion();
		
		return tableauLigues;
	}
	
	//supprimer ligue
	public void supprimeLigue(int id_ligue) 
	{
		Statement st=acces.getDbConnexion();
		
		if(st!=null)
		{			
			//requete sql
			String sql="delete from personnel_ligue where idLigue="+id_ligue;			
			try {
				st.executeUpdate(sql);	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acces.closeDbConnexion();
		}
		
	}
	
	//selectionner une ligue	
	public Ligue selectLigue(int id_ligue) 
	{
		Statement st=acces.getDbConnexion();
		
		if(st!=null)
		{			
			//requete sql
			String sql="select * from personnel_ligue where idLigue='"+id_ligue+"'";			
			try {
				st.executeQuery(sql);	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acces.closeDbConnexion();
		}
		return new Ligue(id_ligue);
		
	}
	
	//modifier administrateur d'une ligue
	public void ModifierAdminLigue(int id_ligue, int id_salariee) 
	{
		Statement st=acces.getDbConnexion();
		
		if(st!=null)
		{			
			//requete sql ( on suppose qu'il y'a une ligne id_salariee dans ligue --A confirmer )
			String sql="update personnel_salarie set statusSalarie =0 where idLigue="+id_ligue+";update personnel_salarie set statusSalarie= 1 where idSalarie="+id_salariee+"";			
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
	public Ligue ModifierNomLigue(int id_ligue, String nom_ligue) 
	{
		Statement st=acces.getDbConnexion();
		
		if(st!=null)
		{			
			//requete sql 
			String sql="update personnel_ligue set titreLigue='"+nom_ligue+"'"+" where idLigue="+id_ligue;			
			try {
				st.executeUpdate(sql);	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acces.closeDbConnexion();
		}
		
		return new Ligue(nom_ligue);
	}
}
