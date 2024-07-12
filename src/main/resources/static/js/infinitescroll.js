let page  = 0;
const movieContainer = document.querySelector('.movie-container');

window.addEventListener('scroll', () => {
    if(window.scrollY + window.innerHeight >= document.documentElement.scrollHeight) {
        loadMoreMovies();
    }
});

function loadMoreMovies(){
    fetch(`/movies?page=${page}`)
        .then(response => response.json())
        .then(data => {
            data.forEach(movie => {
                const movieCard = document.createElement('div');
                movieCard.classList.add('movie-card');

                const movieImage = document.createElement('img');
                movieImage.src = movie.imageurl;
                movieImage.alt = 'Movie Poster';
                movieCard.appendChild(movieImage);

                const movieTitle = document.createElement('h2');
                movieTitle.textContent = movie.title;
                movieCard.appendChild(movieTitle);

                const detailsMovie = document.createElement('a');
                detailsMovie.href = `/details/${movie.id}`;
                detailsMovie.textContent = 'Details';
                movieCard.appendChild(detailsMovie);

                movieContainer.appendChild(movieCard);
            });
        })
        .catch(error => console.error('Error loading more movies:', error));

}