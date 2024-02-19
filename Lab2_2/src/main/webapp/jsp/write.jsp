<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Запись</title>
    <link rel="stylesheet" type="text/css" href="/css/write.css">
    <script src="js/writer.js"></script>
</head>
<body>
<header>
    <nav>
        <ul>
            <li>
                <form action="write">
                    <button type="submit">Запись</button>
                </form>
            </li>
            <li>
                <form action="read">
                    <button type="submit">Чтение</button>
                </form>
            </li>
        </ul>
    </nav>
</header>
<div>
    <form>
        <p>Добавить игру в список</p>
        <input id="name" type="text" placeholder="Название">
        <input id="url" type="text" placeholder="URL">
        <input id="category" type="text" placeholder="Категория">
        <input id="rating" type="number" placeholder="Рейтинг">
        <input id="visitsPerMonth" type="number" placeholder="Посещения в месяц">
        <button onclick="getData()">Добавить</button>
    </form>
</div>
</body>
</html>