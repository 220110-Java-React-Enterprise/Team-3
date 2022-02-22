// Author: Jeffrey
async function loadGame() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    let url = "http://localhost:8080/browse_games/" + urlParams.get("game_id");

    let response = await fetch(url)
        .then((response) => response.json());

    console.log(response);

    let bg = document.getElementById("game_background");
    bg.style.backgroundImage = "url(\"" + response.backgroundImage + "\")";
    bg.style.backgroundSize = "cover";

    document.getElementById("genres").innerHTML = response.genres;

}