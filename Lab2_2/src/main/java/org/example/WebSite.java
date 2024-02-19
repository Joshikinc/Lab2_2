package org.example;

import lombok.Getter;

public class WebSite {
    @Getter private String name;        //Название сайта
    @Getter private String url;         //URL
    @Getter private String category;    //Категория
    @Getter private float rating;       //Рейтинг
    @Getter private int visitsPerMonth; //Посещения в месяц

    public WebSite(String name, String url, String category, float rating, int visitsPerMonth) {
        this.name = name;
        this.url = url;
        this.category = category;
        this.rating = rating;
        this.visitsPerMonth = visitsPerMonth;
    }
}
