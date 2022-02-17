function register() {
    const User = {
        username: document.getElementById("register_username").value,
        password: document.getElementById("register_password").value
    };

    const param = {
        headers: {
            "content-type": "application/json; charset=UTF-8"
        },
        body: User,
        method: "POST"
    };

    fetch("http://localhost:8080/users", param)
    .then(data=>{return data.json()})
    .then(res=>{console.log(res)})
    .catch(error=>console.log(error));
}