import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: rkessler
 * Date: 03.01.14
 * Time: 13:49
 * To change this template use File | Settings | File Templates.
 */
public class SqlWrapper {

	private Connection connection;

	public SqlWrapper(){

	}

	public void open(){
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite::memory:");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}


	public void setup(){
		try {
			Statement stmt = connection.createStatement();
			String sql = "CREATE TABLE COMPANY " +
					"(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
					" NAME           TEXT    NOT NULL)";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Table created successfully");
		} catch(Exception e){
			System.out.print("Error in Setup");
		}
	}


	public boolean insert(String name){
		try {
			Statement stmt = connection.createStatement();
			String sql = "INSERT INTO COMPANY (NAME) VALUES ('" + name + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			return true;
		}catch (Exception e){
			System.out.println("Error in insert");
			return false;
		}
	}

	public String show(int limit){
		try{
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM COMPANY LIMIT " + limit + ";";
			ResultSet rs = stmt.executeQuery(sql);
			StringBuilder sb = new StringBuilder();
			while(rs.next()){
				int id = rs.getInt("id");
				String  name = rs.getString("name");
				sb.append(id + ": " + name + "\n");
			}
			rs.close();
			stmt.close();
			return sb.toString();
		} catch (Exception e){
			System.out.println("Error in show!");
			return "Error";
		}
	}
}
