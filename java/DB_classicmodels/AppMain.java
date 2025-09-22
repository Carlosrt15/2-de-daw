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
                
                ResultSet pagos = statement.executeQuery("Select * from payments");
                
                System.out.println("Tabla de pagos---------------------");
                
                while(pagos.next() != false) {
                	
                	PagosDTO b = new PagosDTO(
                		pagos.getInt("customerNumber"),	
                		pagos.getString("checkNumber"),	
                		pagos.getDouble("amount"));	
                			
                	System.out.println(b);
                	
                	
                }
    					
    					
    		}
    		
    		
    	} catch (SQLException e) {
    		System.err.println("Error: " +e.getMessage());
    	}
    	
    	
    	
    }
    
    
    
    }
    
    