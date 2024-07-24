function login() {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    fetch('/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email, password })
    })
    .then(response => response.json())
    .then(data => {
        if (data.token) {
            localStorage.setItem('token', data.token); // Guardar el token en localStorage

            // Enviar el token en una solicitud GET a /home para verificar
            fetch('/home', {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + data.token // Añadir el token al header
                }
            })
            .then(homeResponse => {
                if (homeResponse.ok) {
                    window.location.href = '/home'; // Redirigir a /home si la respuesta es OK
                } else {
                    alert('Failed to authorize');
                }
            })
            .catch(error => console.error('Error:', error));
        } else {
            alert('Login failed');
        }
    })
    .catch(error => console.error('Error:', error));
}