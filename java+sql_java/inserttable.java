import java.sql.*;

public class inserttable {
    public static void main( String args[] ) {
        Connection c=null; 
        Statement s=null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
            s=c.createStatement();
            String sql="INSERT INTO OBECNOSC (ID,IMIE,NAZWISKO,ROLA,PRZEDMIOT,NUMER_ALBUMU,DATA_ZAJEC,CZAS_ZALOGOWANIA,CZAS_WYLOGOWANIA)"+
            "VALUES ('2','Konrad','Łabaziewicz','Uczeń','Programowanie obiektowe',622519,'2023-01-09','13:28:41','14:03:18')";
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