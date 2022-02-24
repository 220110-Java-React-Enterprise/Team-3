// Author: CJ, Jeffrey

var page;

// Gets all games and displays them in groups of 20
async function gamePopulation() {
    let url = baseURL + "games";

    let response = await fetch(url)
        .then((response) => response.json());

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    page = urlParams.get("page");
    if(page == null) {
        page = 1;
    }

    if(page == 1) {
        document.getElementById("prev_btn").style.visibility = "hidden";
    } else if(page * 20 >= response.length) {
        document.getElementById("next_btn").style.visibility = "hidden";
    }

    for(let i = (page - 1) * 20; i < response.length && i < page * 20; i++) {
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

function nextPage() {
    location.href = 'browse_games.html?page=' + (Number(page) + 1);
}

function prevPage() {
    location.href = 'browse_games.html?page=' + (Number(page) - 1);
}