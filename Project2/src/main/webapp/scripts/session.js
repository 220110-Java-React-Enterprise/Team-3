function checkSession() {
    if(localStorage.getItem("currentUser")) {
        document.getElementById("logout").style.visibility = "visible";
        document.getElementById("login").style.visibility = "hidden";
        document.getElementById("register").style.visibility = "hidden";
    } else {
        document.getElementById("logout").style.visibility = "hidden";
        document.getElementById("login").style.visibility = "visible";
        document.getElementById("register").style.visibility = "visible";
    }
}

function logout() {
    localStorage.clear();
    location.href = 'login.html';
}