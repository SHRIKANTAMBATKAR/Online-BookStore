package controller;

import dao.BookDAO;
import model.Book;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

    private BookDAO dao = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null || "adminView".equals(action)) {
            List<Book> list = dao.getAllBooks();
            req.setAttribute("books", list);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

        // USER VIEW
        else if ("userView".equals(action)) {
            List<Book> list = dao.getAvailableBooks();
            req.setAttribute("books", list);
            req.getRequestDispatcher("userBooks.jsp").forward(req, resp);
        }

        // SEARCH
        
        else if ("search".equals(action)) {

            String keyword = req.getParameter("keyword");
            String role = req.getParameter("role"); // admin or user

            List<Book> list;

            if ("user".equals(role)) {
                // USER SEARCH → only available books
                list = dao.searchBooks(keyword, true);
                req.setAttribute("books", list);
                req.getRequestDispatcher("userBooks.jsp").forward(req, resp);
            } else {
                // ADMIN SEARCH → all books
                list = dao.searchBooks(keyword, false);
                req.setAttribute("books", list);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        }
        // EDIT BOOK
        else if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Book book = dao.getBookById(id);
            req.setAttribute("book", book);
            req.getRequestDispatcher("editBook.jsp").forward(req, resp);
        }

        // DELETE BOOK
        // ONLY WORKS IF count = 0
        else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.deleteBook(id);
            resp.sendRedirect("BookServlet");
        }

        // ISSUE BOOK (ADMIN / USER)
        // REDUCE COUNT BY 1
        // AUTO DELETE IF COUNT = 0
        else if ("issue".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.issueBook(id);
            resp.sendRedirect("BookServlet?action=adminView");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String action = req.getParameter("action");

        // ADD BOOK 
        if ("add".equals(action)) {
            dao.addBook(new Book(
                    0,
                    req.getParameter("title"),
                    req.getParameter("author"),
                    Integer.parseInt(req.getParameter("count"))
            ));
        }

        // UPDATE BOOK
        else if ("update".equals(action)) {
            dao.updateBook(new Book(
                    Integer.parseInt(req.getParameter("id")),
                    req.getParameter("title"),
                    req.getParameter("author"),
                    Integer.parseInt(req.getParameter("count"))
            ));
        }

        resp.sendRedirect("BookServlet");
    }
}
