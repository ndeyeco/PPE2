package console;
import java.io.IOException;

import dal.LigueBdd;
import dal.SalarieeBdd;

public class ConsoleDeNdeye {

	public static void main(String[] args)
	{
		
		SalarieeBdd requeteSalariee=new SalarieeBdd();
		try{
			/*requeteSalariee.AjoutSalariee("Coundoul", "Mariama", "zeyma@gmail.com");
			System.out.println("Enregistrement reussie");
			*/
			requeteSalariee.afficherSalariee(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		
		
		
		/*
		LigueBdd requeteLigue=new LigueBdd();
		try {
			requeteLigue.afficherLigue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}
