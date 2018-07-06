import java.sql.*;

class Batch {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "P@ssword123");

            PreparedStatement stmt = con.prepareStatement("insert into emp values(?,?,?)");
            stmt.setInt(1, 3);//1 specifies the first parameter in the query
            stmt.setString(2, "William");
            stmt.setInt(3, 17);
            stmt.addBatch();

            stmt.setInt(1, 4);
            stmt.setString(2, "Leonardo");
            stmt.setInt(3, 17);
            stmt.addBatch();

            var result = stmt.executeBatch();
            System.out.println(result.length + " records inserted");
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}  