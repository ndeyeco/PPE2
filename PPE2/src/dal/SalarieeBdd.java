package dal;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.MysqlAccess;
import metier.Salariee;

public class SalarieeBdd
{	
	MysqlAccess acces= new MysqlAccess("ppe_personnel");
			
	
	
	// Ajouter un nouveau salariee
	public  void AjoutSalariee(String nom, String prenom, String email, String pass,int id )
	{			
		Statement st=acces.getDbConnexion();		
		if(st!=null)
		{
			//requete sql
			String sql=" Insert into personnel_salarie(nomSalarie,prenomSalarie,emailSalarie,mdpSalarie,idLigue,statusSalarie) values ('"+ nom+"','"+prenom+"','"+email+"', '"+pass+"',"+id+",0)";			
			try {
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acces.closeDbConnexion();
		}
	}
	
	
	
	// Affiche admin d'une ligue donnee
		public  String GetAdmin(int idLigue)
		{	
			ResultSet result=null;
			String nomSalariee="A DETERMINER";
			String prenomSalariee="";
			
			Statement st=acces.getDbConnexion();
			
			if(st!=null)
			{
				//requete sql
				String sql="select nomSalarie, prenomSalarie from personnel_salarie where statusSalarie=1 and idLigue="+idLigue;			
				try {
					result=st.executeQuery(sql);
					while (result.next()) 
					{				
						nomSalariee = result.getString( "nomSalarie" );
						prenomSalariee = result.getString( "prenomSalarie" );
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				acces.closeDbConnexion();
			}
			return nomSalariee+" "+prenomSalariee;
		}
		
	
	// Modifier Admin d'une ligue
	public  void ModifierAdmin(int idLigue,int idSalariee )
	{			
		Statement st=acces.getDbConnexion();		
		if(st!=null)
		{
			//requete sql
			
			String sql1="UPDATE personnel_salarie set statusSalarie=0 WHERE idLigue="+idLigue+" AND statusSalarie=1";
			String sql2=" Update personnel_salarie set statusSalarie=1 where idLigue="+idLigue+" and idSalarie="+idSalariee;
			try {
				st.executeUpdate(sql1);
				st.executeUpdate(sql2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acces.closeDbConnexion();
		}
	}
	
	//modifier les infos d'un salariee
		public void ModifierInfoSalariee(int id, String nom,String prenom,String email,String pass) 
		{
			Statement st=acces.getDbConnexion();
			
			if(st!=null)
			{			
				//requete sql
				String sql="update personnel_salarie set nomSalarie='"+nom+"',prenomSalarie='"+prenom+"',emailSalarie='"+email+"',mdpSalarie='"+pass+"'where idSalarie="+id+"";			
				try {
					st.executeUpdate(sql);	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				acces.closeDbConnexion();
			}
			
		}
		
		//Modifier Infos du Super-Admin
		public void ModifierInfoSuperAdmin(String email, String newPass, String ancienPass) 
		{
			Statement st=acces.getDbConnexion();
			
			if(st!=null)
			{			
				//requete sql
				String sql="update personnel_superadmin set email='"+email+"',mdp=md5('"+newPass+"') where idSalarie=1 and mdp=md5('"+ancienPass+"')";			
				try {
					st.executeUpdate(sql);	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				acces.closeDbConnexion();
			}
			
		}
	
	// Afficher l'ensemble des salariés d'une ligue donnée
	public ArrayList<Salariee> afficherSalariee(int id_ligue) 
	{
		Statement st=acces.getDbConnexion();
		ResultSet result=null;
		
		ArrayList<Salariee> tableauSalariee=new ArrayList<Salariee>(); 
		int id = 0;
		String nom = "";
		String prenom = "";		
		Salariee salariee;		
		if(st!=null)
		{			
			//requete sql
			String sql="Select idSalarie,nomSalarie,prenomSalarie from personnel_salarie where idLigue="+id_ligue;			
			try {
				result = st.executeQuery(sql);	
				while (result.next()) 
				{					
					id = result.getInt( "idSalarie" );					
					nom = result.getString( "nomSalarie" );					
					prenom = result.getString( "prenomSalarie" );				
					
				    salariee=new Salariee(id,nom,prenom);
					tableauSalariee.add(salariee);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			acces.closeDbConnexion();
		}
		return tableauSalariee;
	}
	
	

	//supprimer un salariee
	public void supprimerSalariee(int id_salariee) 
	{
		Statement st=acces.getDbConnexion();
		
		if(st!=null)
		{			
			//requete sql
			String sql="delete from personnel_salarie where idSalarie='"+id_salariee+"'";			
			try {
				st.executeUpdate(sql);	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acces.closeDbConnexion();
		}
		
	}



	public int testIdentifiant(String pass) {
		// TODO Auto-generated method stub
		Statement st=acces.getDbConnexion();
		ResultSet result=null;
		
		int id = 0;
			
		if(st!=null)
		{			
			//requete sql
					
			try {
				String sql="Select id from personnel_superadmin where mdp=md5('"+pass+"')";	
				result = st.executeQuery(sql);	
				if (result.next()) 
				{					
					id = result.getInt("id");
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			acces.closeDbConnexion();
		}
		
		return id;
	}

	
	
	

}
