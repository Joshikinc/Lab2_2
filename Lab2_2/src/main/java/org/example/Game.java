package org.example;

import lombok.Getter;
public class Game {
    @Getter private String name;        //Название игры
    @Getter private String genre;       //Жанр
    @Getter private String platform;    //Платформа
    @Getter private float year;         //Год
    @Getter private float price;        //Цена

    public Game(String name, String genre, String platform, float year, float price) {
        this.name = name;
        this.genre = genre;
        this.platform = platform;
        this.year = year;
        this.price = price;
    }
}