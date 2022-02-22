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