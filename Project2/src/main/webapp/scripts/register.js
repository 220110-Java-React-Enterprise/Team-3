// Author: Jeffrey

// Creates a new user based on given input if username doesn't already exist
async function register() {
    let user_input = document.getElementById("register_username").value;
    let pass_input = document.getElementById("register_password").value;

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

    let url = baseURL + "users";
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
    .then(function(response) {
        if (!response.ok) {
            err.style.visibility = "visible";
            err.innerHTML = "Invalid username or password, or username already exists.";
        } else {
            location.href = 'login.html';
        }
    });
}