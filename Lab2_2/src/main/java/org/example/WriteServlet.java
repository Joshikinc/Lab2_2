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
        // Перенаправляем запрос на JSP страницу для отображения формы записи
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/jsp/write.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Путь к файлу для хранения данных
        String pathStr = "E:\\pomoika\\OOP\\2_sem_my\\Lab2_2\\src\\main\\webapp\\jsp\\data.json";
        Path path = Paths.get(pathStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<WebSite> SiteList = new ArrayList<>();
        String jsonArrayString="";
        // Если файл не существует, создаем его
        if(!Files.exists(path)) {
            Files.createFile(path);
        }
        // Считываем содержимое файла в строку
        jsonArrayString = Files.readString(path);
        // Если файл не пустой, десериализуем содержимое в список SiteList
        if(!jsonArrayString.equals("")) {
            Type listOfSite = new TypeToken<ArrayList<WebSite>>() {}.getType();
            SiteList = gson.fromJson(jsonArrayString, listOfSite);
        }
        // Считываем новый объект веб-сайта из запроса и добавляем его в список SiteList
        String data = request.getReader().readLine();
        SiteList.add(gson.fromJson(data, WebSite.class));
        // Сериализуем список SiteList и записываем его обратно в файл
        System.out.println("Sending JSON array: " + SiteList.toString());
        Files.write(path, gson.toJson(SiteList).getBytes());
    }
}
