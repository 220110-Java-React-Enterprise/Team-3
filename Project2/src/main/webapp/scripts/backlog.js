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

        if(response[i].rating != null) {
            reviewDiv.innerHTML += "<h5 class=\"review_rating\">" + response[i].rating + "</h5>";
        }

        if(response[i].review != null) {
            reviewDiv.innerHTML += "<p class=\"review_body\">" + response[i].review + "</p>";
        }

        reviewDiv.className = "review_item";
        div.appendChild(reviewDiv);
    }
}

async function updateBio() {
    let input = prompt("Enter your bio:");
    if (!(input == null || input == "")) {
        bio = input;
    }
    // PUT updated user here
}

async function addFriend() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    let url = baseURL + "users/friends/" + localStorage.getItem("currentUser") + "/" + urlParams.get("user_id");

    let response = await fetch(url, {method: 'POST'})
        .then((response) => response.json());
    console.log(response);
}