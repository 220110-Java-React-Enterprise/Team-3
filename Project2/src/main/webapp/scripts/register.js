async function register() {
    let url = "http://localhost:8080/users";
    let user = {
        username: document.getElementById("register_username").value,
        password: document.getElementById("register_password").value
    }
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(user)
    })
}


