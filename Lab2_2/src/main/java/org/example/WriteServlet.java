package org.example;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/write")
public class WriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/jsp/write.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathStr = "E:\\pomoika\\OOP\\2_sem_my\\Lab2_2\\src\\main\\webapp\\jsp\\data.json";
        Path path = Paths.get(pathStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Game> GameList = new ArrayList<>();
        String jsonArrayString="";
        if(!Files.exists(path)) {
            Files.createFile(path);
        }
        jsonArrayString = Files.readString(path);
        if(!jsonArrayString.equals("")) {
            Type listOfGame = new TypeToken<ArrayList<Game>>() {}.getType();
            GameList = gson.fromJson(jsonArrayString, listOfGame);
        }
        String data = request.getReader().readLine();
        GameList.add(gson.fromJson(data, Game.class));
        Files.write(path, gson.toJson(GameList).getBytes());
    }
}