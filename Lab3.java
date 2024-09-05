package EBI;

import java.sql.*;

public class Lab3 {

    public static void main(String[] args) {
        Book book1 = new Book(1, "cleancode", "mohamed", 2024);
        Book book2 = new Book(2, "DSA", "ali", 2020);

        Library lib1 =new Library("EBI" ,12345);

        //lib1.addBook(book1);
        //lib1.addBook(book2);

        //lib1.removeBook(book2);

        //lib1.printAll();
        //lib1.searchByTitle("DSA");
        lib1.searchByAuthor("ali");


    }


}



