let xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE) {
        if (xhr.status === 200) {
            let jsonStr = xhr.responseText;
            let jsonObj = JSON.parse(jsonStr);
            let table_body = document.getElementById("table_body");
            table_body.innerHTML = ""; // Очистить содержимое таблицы перед заполнением

            for (let element of jsonObj) {
                let row = document.createElement("tr");
                for (let value of Object.values(element)) {
                    let cell = document.createElement("td");
                    cell.textContent = value;
                    row.appendChild(cell);
                }
                table_body.appendChild(row);
            }
        } else {
            console.error("Ошибка при получении данных:", xhr.status);
        }
    }
};

xhr.open("POST", "read", true);
xhr.setRequestHeader("Content-type", "application/json");
xhr.send("1");
