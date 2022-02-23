// @Author Jeffrey
async function prepareReview() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    let url = "http://localhost:8080/games/" + urlParams.get("game_id");

    let response = await fetch(url)
        .then((response) => response.json());

    document.getElementById("header_review").innerHTML = `<h1>Write a review for ${response.name}</h1>`;
}

async function postReview() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    let url = baseURL + "games/" + urlParams.get("game_id");
    let game = await fetch(url)
        .then((response) => response.json());

    url = baseURL + "users/reviews/" + localStorage.getItem("currentUser");

    let review = {
        gameId: game,
        review: document.getElementById("review_text").value,
        rating: document.getElementById("review_rating").value
    }

    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(review)
    })
    .then(function(response) {
        if (!response.ok) {
            console.log("error while posting review");
        } else {
            location.href = 'backlog.html';
        }
    });
}