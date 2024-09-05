package EBI;

import java.sql.*;

public class Lab1 {

    public static void main(String[] args) {
        try {
            Connection url = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp1","root","root");
            Statement statement = url.createStatement();
            String query = new String("select * from employee");
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                System.out.println("id: " + resultSet.getInt(1) +
                        "\nfirstName: " + resultSet.getString(2) +
                        "\nsalary: " + resultSet.getInt(3) +
                        "\nlastName: " + resultSet.getString(4)
                );

            }

            statement.close();
            url.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
