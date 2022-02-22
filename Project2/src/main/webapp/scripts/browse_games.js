async function gamePopulation() {
    let url = "http://localhost:8080/browse_games";

    let response = await fetch(url)
    .then((response) => response.json());

    for(let i = 0; i < response.length; i++) {

        let div = document.getElementById("games_list");
        let gameDiv = document.createElement("div");
        gameDiv.className = "game_item";
        gameDiv.innerHTML += "<img class=\"game_covers\" src=\"" + response[i].backgroundImage + "\">";
        div.appendChild(gameDiv);
    }
}