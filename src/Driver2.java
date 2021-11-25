import java.sql.*;
public class Driver2 {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:user.db");
            con.setAutoCommit(false);
            System.out.println("database created\n");
            st = con.createStatement();
            String sql = "INSERT INTO booklist (name, id, writer) VALUES('java', '456', 'bajlur');";
            st.executeUpdate(sql);
            st.close();
            con.commit();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
