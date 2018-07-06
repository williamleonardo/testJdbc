import java.sql.*;

class InsertPrepared {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "P@ssword123");

            PreparedStatement stmt = con.prepareStatement("insert into emp values(?,?,?)");
            stmt.setInt(1, 2);//1 specifies the first parameter in the query
            stmt.setString(2, "Leonardo");
            stmt.setInt(3, 17);

            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}  