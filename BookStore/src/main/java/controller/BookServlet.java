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

    BookDAO dao = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {
            List<Book> list = dao.getAllBooks();
            req.setAttribute("books", list);
            req.getRequestDispatcher("index.jsp").forward(req, resp);

        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Book book = dao.getBookById(id);
            req.setAttribute("book", book);
            req.getRequestDispatcher("editBook.jsp").forward(req, resp);

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.deleteBook(id);
            resp.sendRedirect("BookServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String action = req.getParameter("action");

        if ("add".equals(action)) {
            dao.addBook(new Book(
                    0,
                    req.getParameter("title"),
                    req.getParameter("author"),
                    Integer.parseInt(req.getParameter("count"))
            ));
        }

        if ("update".equals(action)) {
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
