package libraryManagementNew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class DBConnection {
	public static void main(String[] args) {
		Connection con = null;
		String mySqlUrl = "jdbc:mysql://localhost:3306/library?useSSL=false";
		String user = "root";
		String password = "root";
		System.out.println("Connecting...");
		try {
			con = DriverManager.getConnection(mySqlUrl, user, password);
			if (con != null) {
			Statement stmnt = con.createStatement();
			stmnt.execute("USE library;");
			
			//importToBookTable(con);
			//importToAuthorsTable(con);
			//importToBookAuthors(con);
			//importToBorrowers(con);
			/*
			 * methods used to insert data into database, run once after the database is created
			 * in mysql
			 */
			con.close();
			System.out.println("Database Connected!");
				 
			}
		} catch (SQLException ex) {
			System.out.println("Database not connected");
		}
	}
	private static void importToBookTable(Connection con){

        String fileName = "books.csv";
        int batchSize = 30;
        int count = 0;
        try{
        String insertQuery ="Insert into Book (ISBN,TITLE,COVER,PUBLISHER,PAGES) values (?,?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(insertQuery);
        BufferedReader bookFileReader = new BufferedReader(new FileReader(fileName));
        bookFileReader.readLine(); 
        String eachLine;
       
        while ((eachLine = bookFileReader.readLine()) != null) {
            String[] data = eachLine.split("\t");
            String ISBN = data[0];
            String TITLE = data[2];
            String AUTHRO = data[3];
            String COVER = data[4];
            String PUBLISHER = data[5];
            String pages = data[6];
            int pagesInt = Integer.parseInt(pages); 
          
            statement.setString(1, ISBN);
            statement.setString(2, TITLE);
            statement.setString(3, COVER);
            statement.setString(4,PUBLISHER);
            statement.setInt(5, pagesInt);
            statement.addBatch();

            if (count % batchSize == 0) {
                statement.executeBatch();
            }
        }

        bookFileReader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getStackTrace()+"failed to insert data into BOOK");
        }
	}
	private static void importToAuthorsTable(Connection con0){

        String fileName = "books.csv";
        int batchSize = 30;
        int count = 0;
        try{
        String insertQuery ="Insert into Authors (AUTHRO) values (?)";
        PreparedStatement statement = con0.prepareStatement(insertQuery);
        BufferedReader bookFileReader = new BufferedReader(new FileReader(fileName));
        bookFileReader.readLine(); 
        String eachLine;
       
        while ((eachLine = bookFileReader.readLine()) != null) {
            String[] data = eachLine.split("\t");
            String AUTHRO = data[3];
            statement.setString(1, AUTHRO);
            statement.addBatch();

            if (count % batchSize == 0) {
                statement.executeBatch();
            }
        }

        bookFileReader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getStackTrace()+"failed to insert data into AUTHOR");
        }
	}
	private static void importToBookAuthors(Connection con1) {


        String fileName = "books.csv";
        int batchSize = 30;
        int count = 0;
        try{
        String insertQuery ="Insert into BOOK_AUTHORS (ISBN) values (?)";
        PreparedStatement statement = con1.prepareStatement(insertQuery);
        BufferedReader bookFileReader = new BufferedReader(new FileReader(fileName));
        bookFileReader.readLine(); 
        String eachLine;
       
        while ((eachLine = bookFileReader.readLine()) != null) {
            String[] data = eachLine.split("\t");
            String ISBN = data[0];
            statement.setString(1, ISBN);
            statement.addBatch();

            if (count % batchSize == 0) {
                statement.executeBatch();
            }
        }

        bookFileReader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getStackTrace()+"failed to insert data into BOOK_AUTHOR");
        }
	
	}
	private static void importToBorrowers(Connection con2) {
		String fileName = "borrowers.csv";
        int batchSize = 30;

        try{
        String insertQueryBorrower ="Insert into BORROWER (Card_NO,SSN,FIRST_NAME,LAST_NAME,EMAIL,ADDRESS,CITY,STATE, Phone) values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statementBor = con2.prepareStatement(insertQueryBorrower);
        BufferedReader borrowerFileReader = new BufferedReader(new FileReader(fileName));
        borrowerFileReader.readLine(); 
        String eachBorLine;
        int count1 = 0;

        while ((eachBorLine = borrowerFileReader.readLine()) != null) {
            String[] data = eachBorLine.split(",");
            String Card_NO = data[0];
            String SSN = data[1];
            String FIRST_NAME = data[2];
            String LAST_NAME = data[3];
            String EMAIL = data[4];
            String ADDRESS = data[5];
            String CITY = data[6];
            String STATE = data[7];
            String Phone = data[8];

          
            statementBor.setString(1, Card_NO);
            statementBor.setString(2, SSN);
            statementBor.setString(3, FIRST_NAME);
            statementBor.setString(4, LAST_NAME);
            statementBor.setString(5,EMAIL);
            statementBor.setString(6,ADDRESS);
            statementBor.setString(7,CITY);
            statementBor.setString(8,STATE);
            statementBor.setString(9,Phone);

            statementBor.addBatch();

            if (count1 % batchSize == 0) {
                statementBor.executeBatch();
            }
        }

        borrowerFileReader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getStackTrace()+" failed to insert borrower data");
        }
	}
	
	static Connection commomConnection = null;
    public static Connection connect(){
            String databaseName = "";
        	String mySqlUrl;
        	String user;
        	String password;
            System.out.println("Starting...\n");

            try {
    			databaseName = "library";
            	mySqlUrl = "jdbc:mysql://localhost:3306/library?useSSL=false";
            	user = "root"; 
            	password = "root";    
            	commomConnection = DriverManager.getConnection(mySqlUrl,user,password);
                Statement stmt = commomConnection.createStatement();
                stmt.execute("USE library;"); 
                 System.out.println("connected to mySql!");
            }
            catch(Exception ex) {
                System.out.println("Cannot connect");
                System.out.println(ex.getMessage());
            }
            return commomConnection;

    }

}
