async function gamePopulation() {
    let url = "http://localhost:8080/browse_games";
<<<<<<< HEAD
=======

>>>>>>> 4e460544d1211adf80bca8655921be5755a773fc
    let response = await fetch(url)
    .then((response) => response.json());

    for(let i = 0; i < response.length; i++) {

    }
}