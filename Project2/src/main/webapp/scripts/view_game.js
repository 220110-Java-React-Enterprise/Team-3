// Author: CJ, Jeffrey
async function loadGame() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    let url = "http://localhost:8080/browse_games/" + urlParams.get("game_id");

    let response = await fetch(url)
        .then((response) => response.json());

    let bg = document.getElementById("game_background");
    bg.style.backgroundImage = "linear-gradient(transparent, white 80%), "
        + "url(\"" + response.backgroundImage + "\")";

    document.getElementById("game_review").href = "review.html?game_id=" + response.gameId;

    document.getElementById("game_title").innerHTML = response.name;
    document.getElementById("game_rating").innerHTML = response.rating + " / 100";
    document.getElementById("game_platforms").innerHTML = response.platforms;
    document.getElementById("game_genres").innerHTML = response.genres;
    document.getElementById("game_esrb").innerHTML = response.esrbRating;
    document.getElementById("game_release").innerHTML = response.released;

    let screenshots = document.getElementById("game_screenshots");
    let screenshot_urls = response.screenshots.split(", ");

    for(let i = 0; i < screenshot_urls.length; i++) {
        let img = document.createElement("img");
        img.src = screenshot_urls[i];
        img.className = "game_screenshot";
        screenshots.append(img);
    }
}