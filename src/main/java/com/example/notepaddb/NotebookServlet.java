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

@WebServlet("/notebooks")
public class NotebookServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Notebooks"))
        {
            ResultSet resultSet = stmt.executeQuery();
            request.setAttribute("notebooks", resultSet);
            request.getRequestDispatcher("notebooks.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            throw new ServletException("Error retrieving notebooks", e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String manufacturerName = request.getParameter("manufacturerName");
        String notebookName = request.getParameter("notebookName");
        int pageCount = Integer.parseInt(request.getParameter("pageCount"));
        String coverType = request.getParameter("coverType");
        String manufacturerCountry = request.getParameter("manufacturerCountry");
        String pageStyle = request.getParameter("pageStyle");
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(
                     "INSERT INTO Notebooks (manufacturer_name, notebook_name, page_count, cover_type, manufacturer_country, page_style) VALUES (?, ?, ?, ?, ?, ?)"))
        {

            stmt.setString(1, manufacturerName);
            stmt.setString(2, notebookName);
            stmt.setInt(3, pageCount);
            stmt.setString(4, coverType);
            stmt.setString(5, manufacturerCountry);
            stmt.setString(6, pageStyle);
            stmt.executeUpdate();
        }
        catch (Exception e)
        {
            throw new IOException("Error saving notebook", e);
        }
        response.sendRedirect("notebooks");
    }
}