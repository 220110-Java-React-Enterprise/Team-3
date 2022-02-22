async function gamePopulation() {
    let url = "http://localhost:8080/browse_games";

    let response = await fetch(url)
        .then((response) => response.json());

    for(let i = 0; i < response.length; i++) {
        let div = document.getElementById("games_list");
        let gameDiv = document.createElement("div");
        let a = document.createElement("a");

        a.href = "view_game.html?game_id=" + response[i].gameId;
        a.innerHTML += "<img class=\"game_covers\" src=\"" + response[i].backgroundImage + "\">";
        a.innerHTML += "<p class=\"game_title\">" + response[i].name + "</p>";

        gameDiv.className = "game_item";
        gameDiv.appendChild(a);
        div.appendChild(gameDiv);
    }
}