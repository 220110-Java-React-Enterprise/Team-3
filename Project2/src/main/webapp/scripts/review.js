// Author: Jeffrey, CJ

// Gets game name for review
async function prepareReview() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    let url = baseURL + "games/" + urlParams.get("game_id");

    let response = await fetch(url)
        .then((response) => response.json());

    document.getElementById("header_review").innerHTML = `<h1>Write a review for ${response.name}</h1>`;
}

// Creates new review for current user
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
            console.log("Error while posting review");
        } else {
            location.href = 'backlog.html?user_id=' + localStorage.getItem("currentUser");
        }
    });
}

function countChars(obj){
    document.getElementById("currentCount").innerHTML = "Character Count: " + obj.value.length + "/1000";
}