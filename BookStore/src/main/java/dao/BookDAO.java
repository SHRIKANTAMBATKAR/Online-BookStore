package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookDAO {

    private String url = "jdbc:mysql://localhost:3306/bookstore";
    private String user = "root";
    private String password = "SHRIKANT@2024";

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    // GET BOOKS
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps =
                 con.prepareStatement("SELECT * FROM books");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Book b = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("count")
                );
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ADD BOOK
    public void addBook(Book book) {
        try (Connection con = getConnection();
             PreparedStatement ps =
                 con.prepareStatement(
                     "INSERT INTO books(title, author, count) VALUES (?,?,?)")) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getCount());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public Book getBookById(int id) {
        Book book = null;

        try (Connection con = getConnection();
             PreparedStatement ps =
                 con.prepareStatement("SELECT * FROM books WHERE id=?")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                book = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("count")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
    // UPDATE BOOK
    public void updateBook(Book book) {
        try (Connection con = getConnection();
             PreparedStatement ps =
                 con.prepareStatement(
                     "UPDATE books SET title=?, author=?, count=? WHERE id=?")) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getCount());
            ps.setInt(4, book.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE BOOK
    public void deleteBook(int id) {
        try (Connection con = getConnection();
             PreparedStatement ps =
                 con.prepareStatement("DELETE FROM books WHERE id=?")) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
