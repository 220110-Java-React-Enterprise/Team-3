// Author: Jeffrey
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