import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class AppMain {

    public static void main(String[] args) {
    	
    	
    	try (Connection c = ConexionDB.getConnection();
    	
    	Statement statement = c.createStatement();
    	
    	ResultSet clientes = statement.executeQuery("SELECT * FROM customers")) {
    		
    		while(clientes.next() != false) {
    			ClienteDTO a = new ClienteDTO(
                        clientes.getString("customerName"),
                        clientes.getString("phone"),
                        clientes.getString("city"));
                
                System.out.println(a);
    					
    					
    		}
    		
    		
    	} catch (SQLException e) {
    		System.err.println("Error: " +e.getMessage());
    	}
    	
    	
    	
    }
    
    
    
    }
    
    