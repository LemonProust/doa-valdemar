import java.sql.*;

public class H2Example {

    public static void main(String[] args) {
        try {
            String jdbcURL = "jdbc:h2:mem:test";

            Connection connection;
            connection = DriverManager.getConnection(jdbcURL);

            System.out.println("Connected to H2 in-memory database.");

            String sql = "Create table students (ID int primary key, name varchar(50))";

            Statement statement = connection.createStatement();

            statement.execute(sql);

            System.out.println("Created table students.");

            sql = "Insert into students (ID, name) values (1, 'Nam Ha Minh')";

            int rows = statement.executeUpdate(sql);

            if (rows > 0) {
                System.out.println("Inserted a new row.");
            }

            sql = "SELECT * FROM students;";
            ResultSet set = statement.executeQuery(sql);


           while(set.next()){
               System.out.println(set.getString(2));
           }


            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
