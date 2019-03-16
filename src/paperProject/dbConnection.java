package paperProject;
import java.sql.*;

public class dbConnection {
	/**
	* myConn the connection to database
	*/
	static Connection myConn;
	/**
	* mtStmt the statement
	*/
	static Statement myStmt;
	/**
	 * sets up connection to the database
	 */
	public dbConnection ()	{
		getConnection();
	}
	public void getConnection(){
		try{
			myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SENG300", "root", "password");
			myStmt = myConn.createStatement();
		}
		catch(Exception e){
			System.out.println("Error connection to server1");
		}
		System.out.println("Connected to database");
	}

	public boolean addReviewer(String email, String password, String first, String last) {
		try {
			String query = "INSERT INTO reviewerUnapproved (email, pass, firstName, lastName)"
					+ "VALUES(?, ?, ?, ?)";
			PreparedStatement insert = myConn.prepareStatement(query);
			insert.setString(1, email);
			insert.setString(2, password);
			insert.setString(3, first);
			insert.setString(4, last);
			insert.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean addAuthor(String email, String password, String first, String last) {
		try {
			String query = "INSERT INTO user (email, pass, role, firstName, lastName)"
					+ "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement insert = myConn.prepareStatement(query);
			insert.setString(1, email);
			insert.setString(2, password);
			insert.setString(3, "AUTHOR");
			insert.setString(4, first);
			insert.setString(5, last);
			insert.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//return -1 if username/password not correct
	//return 1 if username found and password matches and is AUTHOR
	//return 2 if username found and password matches and is REVIEWER
	//return 3 if username found and password matches and is ADMIN
	public int validateUser(String email, String password) {
		try {
			PreparedStatement ps1 = myConn.prepareStatement("SELECT * FROM user WHERE email LIKE ? ");	
			ps1.setString(1, email);
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()){
				if(password.equals(rs1.getString("pass"))){//password equals
					if(rs1.getString("role").equals("AUTHOR")){
						return 1;
					}else if(rs1.getString("role").equals("REVIEWER")) {
						return 2;
					}else if(rs1.getString("role").equals("ADMIN")) {
						return 3;
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return -1;
	}
}
