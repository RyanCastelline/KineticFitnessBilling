package billingDaos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SampleDao {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kinetic_fitness?autoReconnect=true&useSSL=false",
				"root",	"Caste-dude1");
		//jdbc:mysql://:localhost:3306/kinetic_fitness is the url
		//"root" is the user and password for the DB.
		
		//Preparing sql statement to access database.
		PreparedStatement statement = con.prepareStatement("select * from client");
		
		//Creates variable to execute query.
		ResultSet result = statement.executeQuery();
		
		while(result.next()) {
			System.out.println("Client #: " + result.getString(1) + " Last name: " + result.getString(2) + 
					" First name: " + result.getString(3));
		}
	}
}
