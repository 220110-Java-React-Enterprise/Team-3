async function login() {
    let user_input = document.getElementById("login_username").value;
    let pass_input = document.getElementById("login_password").value;

    let err = document.getElementById("error_message");
    if (user_input == "") {
        err.style.visibility = "visible";
        err.innerHTML = "Please enter a username.";
        return false;
    } else if(pass_input == "") {
        err.style.visibility = "visible";
        err.innerHTML = "Please enter a password.";
        return false;
    } else {
        err.style.visibility = "hidden";
    }

    let url = "http://localhost:8080/users/login";
    let user = {
        username: user_input,
        password: pass_input
    }

    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(user)
    })
    .then((response) => {
        return response.json();
    });
    if(response.userId != null) {
        localStorage.setItem("currentUser", response.userId);
        location.href = 'index.html';
    } else {
        err.style.visibility = "visible";
        err.innerHTML = "Invalid credentials.";
    }
}