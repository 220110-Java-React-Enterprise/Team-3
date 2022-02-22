async function getUsers() {
    let url = "http://localhost:8080/users";

    let response = await fetch(url)
    .then((response) => response.json());

    for(let i = 0; i < response.length; i++) {
        console.log(response[i]);
    }
}