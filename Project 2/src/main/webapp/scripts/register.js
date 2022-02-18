async function register() {
    let user = {
        username: document.getElementById("register_username").value,
        password: document.getElementById("register_password").value
    };

    console.log(JSON.stringify(user));
      let response = await fetch("http://localhost:8080/users", {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(user)
      });
      try {
        let result = await response.json();
        alert(result.message);
      } catch (error) {
        console.error(error);
      }
};


