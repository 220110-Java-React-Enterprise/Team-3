// Author: Trevor, Jeffrey
async function getUsers() {
    let url = "http://localhost:8080/users";

    let response = await fetch(url)
    .then((response) => response.json());

    for(let i = response.length - 1; i >= 0; i--) {
        let div = document.getElementById("users_list");
        let userDiv = document.createElement("div");
        let a = document.createElement("a");

        a.href = "backlog.html?user_id=" + response[i].userId;
        a.innerHTML += "<h5 class=\"username\">" + response[i].username + "</h5>";

        if(response[i].bio != null) {
            a.innerHTML += "<p class=\"bio\">" + response[i].bio + "</p>";
        }

        userDiv.className = "user_item";
        userDiv.appendChild(a);
        div.appendChild(userDiv);
    }
}
