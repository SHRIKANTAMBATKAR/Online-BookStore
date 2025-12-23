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

    // GET ALL BOOKS 
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps =
                     con.prepareStatement("SELECT * FROM books");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("count")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // GET AVAILABLE BOOKS 
    public List<Book> getAvailableBooks() {
        List<Book> list = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps =
                     con.prepareStatement("SELECT * FROM books WHERE count > 0");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("count")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // SEARCH BOOKS
    public List<Book> searchBooks(String keyword, boolean onlyAvailable) {
        List<Book> list = new ArrayList<>();

        String sql = "SELECT * FROM books WHERE (title LIKE ? OR author LIKE ?)";
        if (onlyAvailable) {
            sql += " AND count > 0";
        }

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String key = "%" + keyword + "%";
            ps.setString(1, key);
            ps.setString(2, key);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("count")
                ));
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

    // GET BOOK BY ID
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
    // DELETE BOOK (ONLY IF COUNT = 0)
    public void deleteBook(int id) {
        try (Connection con = getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             "DELETE FROM books WHERE id=? AND count = 0")) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ISSUE BOOK (AUTO DELETE)
    public void issueBook(int id) {
        try (Connection con = getConnection()) {

            // Reduce count
            PreparedStatement ps1 =
                    con.prepareStatement(
                            "UPDATE books SET count = count - 1 WHERE id=? AND count > 0");
            ps1.setInt(1, id);
            ps1.executeUpdate();

            // Auto delete if count becomes 0
            PreparedStatement ps2 =
                    con.prepareStatement(
                            "DELETE FROM books WHERE id=? AND count <= 0");
            ps2.setInt(1, id);
            ps2.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
