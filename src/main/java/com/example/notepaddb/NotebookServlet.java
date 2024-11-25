package com.example.notepaddb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/notebooks")
public class NotebookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try (Connection connection = DatabaseUtil.getConnection()) {
            switch (action) {
                case "addNotebook":
                    request.getRequestDispatcher("addNotebook.jsp").forward(request, response);
                    break;
                case "updateNotebook":
                    request.getRequestDispatcher("updateNotebook.jsp").forward(request, response);
                    break;
                case "deleteNotebook":
                    request.getRequestDispatcher("deleteNotebook.jsp").forward(request, response);
                    break;
                default:
                    displayNotebooks(connection, request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException("Error processing action: " + action, e);
        }
    }

    private void displayNotebooks(Connection connection, HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try (Connection connection = DatabaseUtil.getConnection()) {
            switch (action) {
                case "addNotebook":
                    addNotebook(connection, request, response);
                    break;
                case "updateNotebook":
                    updateNotebook(connection, request, response);
                    break;
                case "deleteNotebook":
                    deleteNotebook(connection, request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException("Error processing action: " + action, e);
        }
    }

    private void addNotebook(Connection connection, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        String manufacturerName = request.getParameter("manufacturer_name");
        String notebookName = request.getParameter("notebook_name");
        int pageCount = Integer.parseInt(request.getParameter("page_count"));
        String coverType = request.getParameter("cover_type");
        String manufacturerCountry = request.getParameter("manufacturer_country");
        String pageStyle = request.getParameter("page_style");

        String sql = "INSERT INTO Notebooks (manufacturer_name, notebook_name, page_count, cover_type, manufacturer_country, page_style) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, manufacturerName);
            stmt.setString(2, notebookName);
            stmt.setInt(3, pageCount);
            stmt.setString(4, coverType);
            stmt.setString(5, manufacturerCountry);
            stmt.setString(6, pageStyle);
            stmt.executeUpdate();
        }
        response.sendRedirect("/notebooks");
    }

    private void updateNotebook(Connection connection, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String manufacturerName = request.getParameter("manufacturer_name");
        String notebookName = request.getParameter("notebook_name");
        int pageCount = Integer.parseInt(request.getParameter("page_count"));
        String coverType = request.getParameter("cover_type");
        String manufacturerCountry = request.getParameter("manufacturer_country");
        String pageStyle = request.getParameter("page_style");

        String sql = "UPDATE Notebooks SET manufacturer_name = ?, notebook_name = ?, page_count = ?, cover_type = ?, manufacturer_country = ?, page_style = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, manufacturerName);
            stmt.setString(2, notebookName);
            stmt.setInt(3, pageCount);
            stmt.setString(4, coverType);
            stmt.setString(5, manufacturerCountry);
            stmt.setString(6, pageStyle);
            stmt.setInt(7, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/notebooks");
    }

    private void deleteNotebook(Connection connection, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String sql = "DELETE FROM Notebooks WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        response.sendRedirect("/notebooks");
    }
}

