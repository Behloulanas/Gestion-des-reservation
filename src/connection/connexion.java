package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connexion {
	private final static String url = "jdbc:mysql://localhost:3306/mini-projet?useUnicode=true"
            + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
	private final static String username = "root";
	private final static String password = "";
	private static Connection con;
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con  = DriverManager.getConnection(url, username, password);
            System.out.println(con);
        } catch (ClassNotFoundException e1) {
            System.out.println("Erreur de pilote");
            e1.printStackTrace();
        } catch (SQLException e2) {
            System.out.println("Erreur de connexion");
            e2.printStackTrace();
        }
    }

    	public static Connection getCon() {
        return con;
    }
	public static void setCon(Connection con) {
		connexion.con = con;
	}



}
