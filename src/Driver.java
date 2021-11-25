import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Driver {
    public static void main(String[] args) {
        Connection con = null;
        Statement smt = null;
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:user.db");
            con.setAutoCommit(false);
            System.out.println("Database Open");
            smt = con.createStatement();
            String sql = "DELETE FROM user_information WHERE email = 'kurshed@gmail.com' ";
            smt.executeUpdate(sql);
            smt.close();
            con.commit();
            con.close();
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
