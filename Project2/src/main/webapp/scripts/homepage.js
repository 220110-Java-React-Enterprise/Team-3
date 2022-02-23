// Author: Jeffrey
async function populateCarousel() {
    let url = baseURL + "games";

    let response = await fetch(url)
        .then((response) => response.json());

    let rnd = Math.floor(Math.random() * response.length);
    document.getElementById("game_one").href = "view_game.html?game_id=" + response[rnd].gameId;
    document.getElementById("game_one_img").src = response[rnd].backgroundImage;
    document.getElementById("game_one_img").alt = response[rnd].name;
    document.getElementById("game_one_title").innerHTML = response[rnd].name;

    rnd = Math.floor(Math.random() * response.length);
    document.getElementById("game_two").href = "view_game.html?game_id=" + response[rnd].gameId;
    document.getElementById("game_two_img").src = response[rnd].backgroundImage;
    document.getElementById("game_two_img").alt = response[rnd].name;
    document.getElementById("game_two_title").innerHTML = response[rnd].name;

    rnd = Math.floor(Math.random() * response.length);
    document.getElementById("game_three").href = "view_game.html?game_id=" + response[rnd].gameId;
    document.getElementById("game_three_img").src = response[rnd].backgroundImage;
    document.getElementById("game_three_img").alt = response[rnd].name;
    document.getElementById("game_three_title").innerHTML = response[rnd].name;
}

async function loadReviews() {
    let url = baseURL + "reviews";

    let response = await fetch(url)
        .then((response) => response.json());

    for(let i = response.length - 1; i >= 0 && i >= response.length - 10; i--) {
        let div = document.getElementById("recent_reviews_column");
        let reviewDiv = document.createElement("div");

        reviewDiv.innerHTML += "<h4 class=\"review_game\">" + response[i].gameId.name + "</h4>";

        if(response[i].rating != null) {
            reviewDiv.innerHTML += "<h5 class=\"review_rating\">" + response[i].rating + " / 100</h5>";
        }

        if(response[i].review != null) {
            reviewDiv.innerHTML += "<p class=\"review_body\">" + response[i].review + "</p>";
        }

        reviewDiv.className = "review_item";
        div.appendChild(reviewDiv);
    }
}

async function loadFriends() {
    if(localStorage.getItem("currentUser")) {
        document.getElementById("friends_column").style.visibility = "visible";

        let url = baseURL + "users/friends/" + localStorage.getItem("currentUser");

        let response = await fetch(url)
            .then((response) => response.json());

        for(let i = 0; i < response.length; i++) {
            let div = document.getElementById("friends_column");
            let friendDiv = document.createElement("div");
            let a = document.createElement("a");

            a.href = "backlog.html?user_id=" + response[i].userId;
            a.innerHTML += "<h5>" + response[i].username + "</h5>";
            a.innerHTML += "<p>" + response[i].bio + "</p>";

            friendDiv.className = "friend_item";
            friendDiv.appendChild(a);
            div.appendChild(friendDiv);
        }

    } else {
        document.getElementById("friends_column").style.visibility = "hidden";
    }
}