// @Author Jeffrey, Trevor
async function loadBacklog() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    let url = baseURL + "users/" + urlParams.get("user_id");

    let response = await fetch(url)
        .then((response) => response.json());

    document.getElementById("header_username").innerHTML += "<h1>" + response.username + "'s Backlog</h1>";

    if(response.userId == localStorage.getItem("currentUser")) {
        document.getElementById("header_options").innerHTML += "<h5><a onclick=\"updateBio()\">Change Bio</a></h5>";
    } else if(localStorage.getItem("currentUser") != null) {
        document.getElementById("header_options").innerHTML += "<h5><a onclick=\"addFriend()\">Add to Friends</a></h5>";
    }

    url = baseURL + "users/reviews/" + urlParams.get("user_id");
    response = await fetch(url)
        .then((response) => response.json());

    for(let i = response.length - 1; i >= 0; i--) {
        let div = document.getElementById("reviews_list");
        let reviewDiv = document.createElement("div");
        let a = document.createElement("a");

        a.href = "view_game.html?game_id=" + response[i].gameId.gameId;
        a.innerHTML += "<h4 class=\"review_game\">" + response[i].gameId.name + "</h4>";

        if(response[i].rating != null) {
            a.innerHTML += "<h5 class=\"review_rating\">" + response[i].rating + " / 100</h5>";
        }

        if(response[i].review != null) {
            a.innerHTML += "<p class=\"review_body\">" + response[i].review + "</p>";
        }

        reviewDiv.className = "review_item";
        reviewDiv.appendChild(a);
        div.appendChild(reviewDiv);
    }
}

async function updateBio() {
    let input = prompt("Enter your bio:");

    let url = baseURL + "users/" + localStorage.getItem("currentUser");

    let user = await fetch(url)
        .then((user) => user.json());

    user.bio = input;

    url = baseURL + "users/"

    await fetch(url, {
        method: 'PUT',
        headers: {
            'Content-type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(user)
    })
}

async function addFriend() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    let url = baseURL + "users/friends/" + localStorage.getItem("currentUser") + "/" + urlParams.get("user_id");

    let response = await fetch(url, {method: 'POST'})
        .then((response) => response.json());
    console.log(response);
}