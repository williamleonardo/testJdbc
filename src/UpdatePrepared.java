import java.sql.*;

class UpdatePrepared {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "P@ssword123");

            PreparedStatement stmt = con.prepareStatement("update emp set name=? where id=?");
            stmt.setString(1, "William Leonardo");
            stmt.setInt(2, 2);

            int i = stmt.executeUpdate();
            System.out.println(i + " records updated");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}  