package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/read")
public class ReadServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/jsp/read.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathStr = "E:\\pomoika\\OOP\\2_sem_my\\Lab2_2\\src\\main\\webapp\\jsp\\data.json";
        Path path = Paths.get(pathStr);
        response.setContentType("application/json");
        String jsonArrayString = Files.readString(path);
        System.out.println(Files.exists(path));
        if(Files.exists(path)) {
            jsonArrayString = Files.readString(path);
        }
        PrintWriter out = response.getWriter();
        out.print(jsonArrayString);
        out.close();
    }
}