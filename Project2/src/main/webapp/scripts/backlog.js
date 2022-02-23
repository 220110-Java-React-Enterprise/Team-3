async function loadBacklog() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    let url = "http://localhost:8080/users/" + urlParams.get("user_id");

    let response = await fetch(url)
        .then((response) => response.json());

    document.getElementById("header_username").innerHTML += "<h1>" + response.username + "'s Backlog</h1>";

    if(response.userId == localStorage.getItem("currentUser")) {
        document.getElementById("header_options").innerHTML += "<h5>Change Bio</h5>";
    } else {
        document.getElementById("header_options").innerHTML += "<h5>Add to Friends</h5>";
    }

    url = "http://localhost:8080/users/reviews/" + urlParams.get("user_id");
    response = await fetch(url)
        .then((response) => response.json());

    console.log(response);
}