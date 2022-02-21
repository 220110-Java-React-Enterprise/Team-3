async function gamePopulation() {
    let url = "http://localhost:8080/browse_games";

    let response = await fetch(url)
    .then((response) => response.json())
    .then((games) => {
        return games;
    });
    for(let i = 0; i < response.length; i++) {
        console.log(response[i]);
    }
}