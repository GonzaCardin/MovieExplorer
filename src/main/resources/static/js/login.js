function login(){
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    fetch('/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            email,
            password
        })
    })
        .then(response => {
            if (response.ok) {
                window.location.href = '/home';
            } else {
                alert('Login failed');
            }
        })
}