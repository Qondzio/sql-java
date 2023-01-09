import java.sql.*;  

public class createtable {
    public static void main( String args[] ) {
        Connection c=null; 
        Statement s=null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
            s=c.createStatement();
            String sql="CREATE TABLE OBECNOSC"+
            "(ID INT IDENTITY(1,1) PRIMARY KEY,"+
            "IMIE TEXT NOT NULL,"+
            "NAZWISKO TEXT NOT NULL,"+
            "ROLA TEXT NOT NULL,"+
            "PRZEDMIOT TEXT NOT NULL,"+
            "NUMER_ALBUMU INT(10) NOT NULL,"+
            "DATA_ZAJEC DATE NOT NULL,"+
            "CZAS_ZALOGOWANIA TIME NOT NULL,"+
            "CZAS_WYLOGOWANIA TIME NOT NULL,"+
            "CZAS_SPEDZONY_NA_SESJI TIME)";
            s.executeUpdate(sql);
            c.close();
            s.close();
        }
        catch (Exception e)
        {
            System.out.println("ERROR");
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("SQL statement finished");
    }
}    