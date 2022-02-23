// Author: CJ, Jeffrey
async function loadGame() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    let url = baseURL + "games/" + urlParams.get("game_id");

    let response = await fetch(url)
        .then((response) => response.json());

    let bg = document.getElementById("game_background");
    bg.style.backgroundImage = "linear-gradient(transparent, white 80%), "
        + "url(\"" + response.backgroundImage + "\")";

    if(localStorage.getItem("currentUser") != null) {
        document.getElementById("game_review").innerHTML = "Leave a Review"
        document.getElementById("game_review").href = "review.html?game_id=" + response.gameId;
    } else {
        document.getElementById("game_review").innerHTML = "Login to Write Reviews"
        document.getElementById("game_review").href = "login.html"
    }

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

    url = baseURL + "reviews/game/" + urlParams.get("game_id");
    let reviews = await fetch(url)
        .then((reviews) => reviews.json());

    for(let i = reviews.length - 1; i >= 0; i--) {
        let div = document.getElementById("game_reviews");
        let reviewDiv = document.createElement("div");

        reviewDiv.innerHTML += "<h4 class=\"review_game\">" + reviews[i].gameId.name + "</h4>";

        if(reviews[i].rating != null) {
            reviewDiv.innerHTML += "<h5 class=\"review_rating\">" + reviews[i].rating + " / 100</h5>";
        }

        if(reviews[i].review != null) {
            reviewDiv.innerHTML += "<p class=\"review_body\">" + reviews[i].review + "</p>";
        }

        reviewDiv.className = "review_item";
        div.appendChild(reviewDiv);
    }
}