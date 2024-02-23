let Game = {
    name: "",
    genre: "",
    platform: "",
    year: 0,
    price: 0
}
function getData() {
    Game.name = document.getElementById("name").value;
    Game.genre = document.getElementById("genre").value;
    Game.platform = document.getElementById("platform").value;
    Game.year = document.getElementById("year").value;
    Game.price = document.getElementById("price").value;

    let gameJson = JSON.stringify(Game);
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "write", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function() {
        if (xhr.status === 200) {
            // Действия после успешной отправки данных
            console.log("Данные успешно отправлены на сервер");
            // Обновить список игр
            refreshGameList();
        } else {
            // Обработка ошибок при отправке данных
            console.error("Ошибка при отправке данных на сервер");
        }
    };
    xhr.send(gameJson);
};