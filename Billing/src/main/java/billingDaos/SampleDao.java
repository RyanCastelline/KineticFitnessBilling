package billingDaos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SampleDao {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kinetic_fitness?autoReconnect=true&useSSL=false",
				"root",	"");
		//jdbc:mysql://:localhost:3306/kinetic_fitness is the url
		//?autoReconnect=true&useSSL=false is used to bypass a warning issued while accessing the DB.
		//"root" is the user and password for the DB.
		//Enter your profile password for the last argument within the double quotes.
		
		//Preparing sql statement to access database, determining each student and total drop-in classes.
		PreparedStatement statement = con.prepareStatement(
				"select client.FIRST_NAME, client.LAST_NAME, (client.CLASSES_TAKEN - membership.classes_per_month) as 'DROPIN_CLASSES'\r\n" + 
				"from client\r\n" + 
				"left join membership on client.MEMBERSHIP_TIER = membership.membership_tier\r\n" + 
				"order by client.LAST_NAME");
		
		//Creates variable to execute query.
		ResultSet result = statement.executeQuery();
		
		System.out.println("The following students have drop-in classes:");
		while(result.next()) {
			if(result.getInt(3) > 0) { //If statement only displays students with positive drop-ins.
				System.out.println("Name: " + result.getString(1) + " " + result.getString(2) + 
						"; Total drop-in classes: " + result.getInt(3));
			}
		}
	}
}
