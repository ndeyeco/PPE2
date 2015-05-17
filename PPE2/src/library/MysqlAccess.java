package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlAccess {
	
	// info d'acces à la base
	private String url;
	private String user;
	private String password;
	private Connection cn;
	private Statement st;

	public MysqlAccess(String nameBdd) {
		// TODO Auto-generated constructor stub
		this.url="jdbc:mysql://localhost:3306/"+nameBdd;
		this.user="root";
		this.password="";
		this.cn=null;
		this.st=null;
	}
	
	public Statement getDbConnexion()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			cn=DriverManager.getConnection(url, user, password);		
			st= cn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return st;
	}
	
	public void closeDbConnexion()
	{		
	        try {
	            /* Fermeture de la connexion */
	            cn.close();
	        } catch (SQLException ignore) {
	            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
	        }	    
	}

}
