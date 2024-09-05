package EBI;

import java.sql.*;

public  class Library {
    private String name;
    private int phone;

    public Library(String name, int phone) {
        this.name = name;
        this.phone = phone;

    }


    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

   public void setPhone(int phone) {
        this.phone = phone;
    }

    public static void addBook (Book book ) {
        // query:INSERT INTO `library` (`id`, `title`, `author`, `publication_year`) VALUES ('1', 'cleancode', 'mohamed', '2024');
        int id = book.getId();
        String title = book.getTitle();
        String author = book.getAuthor();
        int publicationYear = book.getPublicationYear();

        String url = "jdbc:mysql://localhost:3306/emp1";
        String user = "root";
        String password = "root";

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            String query = new String("INSERT INTO `library` (`id`, `title`, `author`, `publication_year`) VALUES (?, ?, ?, ?)");

            PreparedStatement statement = con.prepareStatement(query);

            statement.setInt(1, id);
            statement.setString(2, title);
            statement.setString(3, author);
            statement.setInt(4, publicationYear);

            // Execute the query
            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            statement.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("An SQL exception occurred.");
            e.printStackTrace();
        }


    }

    public static void removeBook (Book book ) {
        // query:DELETE FROM `library` WHERE (`id` = '50');
        int id = book.getId();

        String url = "jdbc:mysql://localhost:3306/emp1";
        String user = "root";
        String password = "root";

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            String query = new String("DELETE FROM `library` WHERE `id` = ? ");

            PreparedStatement statement = con.prepareStatement(query);

            statement.setInt(1, id);

            // Execute the query
            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            statement.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("An SQL exception occurred.");
            e.printStackTrace();
        }


    }

    public static void printAll () {
        // query:SELECT * FROM library;
        String url = "jdbc:mysql://localhost:3306/emp1";
        String user = "root";
        String password = "root";

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            String query = new String("SELECT * FROM library;");

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                System.out.println("\nid: " + resultSet.getInt(1) +
                        "\ntitle: " + resultSet.getString(2) +
                        "\nauthor: " + resultSet.getString(3) +
                        "\npublication Year: " + resultSet.getInt(4)
                );

            }

            statement.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("An SQL exception occurred.");
            e.printStackTrace();
        }


    }

    public static void searchByTitle (String bookTitle) {
        // query:SELECT * FROM library Where (title =bookTitle );
        String url = "jdbc:mysql://localhost:3306/emp1";
        String user = "root";
        String password = "root";

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            String query = new String("SELECT * FROM library Where (title = ?)");

            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, bookTitle);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                System.out.println("\nid: " + resultSet.getInt(1) +
                        "\ntitle: " + resultSet.getString(2) +
                        "\nauthor: " + resultSet.getString(3) +
                        "\npublication Year: " + resultSet.getInt(4)
                );

            }

            statement.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("An SQL exception occurred.");
            e.printStackTrace();
        }


    }

    public static void searchByAuthor (String bookAuthor) {
        // query:SELECT * FROM library Where (author = bookAuthor );
        String url = "jdbc:mysql://localhost:3306/emp1";
        String user = "root";
        String password = "root";

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            String query = new String("SELECT * FROM library Where (author = ?)");

            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, bookAuthor);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                System.out.println("\nid: " + resultSet.getInt(1) +
                        "\ntitle: " + resultSet.getString(2) +
                        "\nauthor: " + resultSet.getString(3) +
                        "\npublication Year: " + resultSet.getInt(4)
                );

            }

            statement.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("An SQL exception occurred.");
            e.printStackTrace();
        }


    }

}
