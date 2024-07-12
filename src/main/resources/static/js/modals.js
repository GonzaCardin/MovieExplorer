document.addEventListener('DOMContentLoaded', () => {
    const addMovieModal = document.getElementById('addMovieModal');
    const addMovieButton = document.getElementById('addMovieBtn');
    const closeAddModal = addMovieModal.querySelector('.close');

    const editMovieModal = document.getElementById('editMovieModal');
    const closeEditModal = editMovieModal.querySelector('.close');

    addMovieButton.addEventListener('click', () => {
        addMovieModal.style.display = 'block';
    });

    closeAddModal.addEventListener('click', () => {
        addMovieModal.style.display = 'none';
    });

    document.querySelector('.edit-button').forEach(button => {
        button.addEventListener('click', () => {
            const movieTitle = button.dataset.title;
            const movieWebsite = button.dataset.website;
            const movieImageUrl = button.dataset.imageurl;
            const movieGenres = button.dataset.genres;

            document.getElementById('editTitleInput').value = movieTitle;
            document.getElementById('editWebsiteInput').value = movieWebsite;
            document.getElementById('editImageUrlInput').value = movieImageUrl;
            document.getElementById('editGenresInput').value = movieGenres;

            editMovieModal.style.display = 'block';
        });
    });

    closeEditModal.addEventListener('click', () => {
        editMovieModal.style.display = 'none';
    });

    document.getElementById('addMovieForm').addEventListener('submit', (event) => {
        event.preventDefault();
        const title = document.getElementById('addTitleInput').value;
        const website = document.getElementById('addWebsiteInput').value;
        const imageUrl = document.getElementById('addImageUrlInput').value;
        const genres = document.getElementById('addGenresInput').value;

        const movieInfo = {
            title,
            website,
            imageUrl,
            genresNames: genres.map((genre) => genre.trim())
        };
        fetch('/movies/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(movieInfo)
        })
            .then(response => {
                if (response.ok) {
                    location.reload();
                } else {
                    console.error('Error adding movie');
                }
            });
    });

    document.getElementById('editMovieForm').addEventListener('submit', (event) => {
        event.preventDefault();
        const title = document.getElementById('editTitleInput').value;
        const website = document.getElementById('editWebsiteInput').value;
        const imageUrl = document.getElementById('editImageUrlInput').value;
        const genres = document.getElementById('editGenresInput').value;

        const movieInfo = {
            title,
            website,
            imageUrl,
            genresNames: genres.map((genre) => genre.trim())
        };
        fetch('movies/update/${id}', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(movieInfo)
        })
            .then(response => {
                if (response.ok) {
                    location.reload();
                } else {
                    console.error('Error editing movie');
                }
            });
    });

    document.querySelectorAll('.delete-button').forEach(button => {
        button.addEventListener('click', () => {
            const id = button.dataset.id;
            fetch('movies/delete/${id}', {
                method: 'DELETE'
            })
                .then(response => {
                    if (response.ok) {
                        location.reload();
                    } else {
                        console.error('Error deleting movi');
                    }
                });
        });
    });

    window.addEventListener('click', (event) => {
        if (event.target === addMovieModal) {
            addMovieModal.style.display = 'none';
        }
        if (event.target === editMovieModal) {
            editMovieModal.style.display = 'none';
        }
    });
});