// Author: Jeffrey
var baseURL = "http://memorypak1-env.eba-h3unf433.us-east-1.elasticbeanstalk.com/";

function checkSession() {
    if(localStorage.getItem("currentUser")) {
        document.getElementById("backlog").style.visibility = "visible";
        document.getElementById("logout").style.visibility = "visible";
        document.getElementById("login").style.visibility = "hidden";
        document.getElementById("register").style.visibility = "hidden";
    } else {
        document.getElementById("backlog").style.visibility = "hidden";
        document.getElementById("logout").style.visibility = "hidden";
        document.getElementById("login").style.visibility = "visible";
        document.getElementById("register").style.visibility = "visible";
    }
}

function logout() {
    localStorage.clear();
    location.href = 'login.html';
}

function backlog() {
    location.href = 'backlog.html?user_id=' + localStorage.getItem("currentUser");
}

function search() {
    location.href = 'search_games.html?query=' + document.getElementById("search_bar").value;
}