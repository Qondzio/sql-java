import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class selecttable {
    public static void main( String args[] ) {
        Connection c=null; 
        Statement s=null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
            s=c.createStatement();
            String sql="SELECT * FROM OBECNOSC";
            ResultSet r=s.executeQuery(sql);
            
            while(r.next())
            {
                int id=r.getInt("ID");
                String imie=r.getString("IMIE");
                String nazwisko=r.getString("NAZWISKO");
                String rola=r.getString("ROLA");
                String przedmiot=r.getString("PRZEDMIOT");
                int nr_albumu=r.getInt("NUMER_ALBUMU");
                String data_zajec=r.getString("DATA_ZAJEC");
                String czas_zalogowania=r.getString("CZAS_ZALOGOWANIA");
                String czas_wylogowania=r.getString("CZAS_WYLOGOWANIA");


                SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
                Date date1=format.parse(czas_wylogowania);
                Date date2=format.parse(czas_zalogowania);
                long difference = date1.getTime()-date2.getTime();
                long hours=(difference/1000)/60/60%24;
                long minutes = (difference / 1000) / 60 % 60;
                long seconds = (difference / 1000) % 60;
                                
                
                System.out.println("ID= "+id);
                System.out.println("Imie= "+imie);
                System.out.println("Nazwisko= "+nazwisko);
                System.out.println("Rola= "+rola);
                System.out.println("Przedmiot= "+przedmiot);
                System.out.println("Nr_albumu= "+nr_albumu);
                System.out.println("Data_zajec= "+data_zajec);
                System.out.println("Czas_zalogowania= "+czas_zalogowania);
                System.out.println("Czas_wylogowania= "+czas_wylogowania);
                System.out.format("Czas spędzony na zajęciach= "+"%02d:%02d:%02d", hours, minutes, seconds);
                System.out.println("");
                System.out.println("--------------------------------------------");

            }
            r.close();
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
    

