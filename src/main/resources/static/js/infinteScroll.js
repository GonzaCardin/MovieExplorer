document.addEventListener('DOMContentLoaded', function () {
    let page = 1;
    const movieList = document.getElementById('movieList');

    window.addEventListener('scroll', function () {
        if (this.window.innerHeight + this.window.scrollY >= this.document.body.offsetHeight) {
            page++;
            fetchMoreMovies(page);
        };
    });
    function fetchMoreMovies(page) {
        fetch(`/movies?page=${page}`)
            .then(resp => resp.json())
            .then(data => {
                data.forEach(movie => {
                    const movieDiv = document.createElement('div');
                    movieDiv.classList.add('col-12');
                    movieDiv.innerHTML = `
                        <div class="card mb-3">
                            <div class="card-body">
                                <h4 class="card-title">${movie.title}</h4>
                                <a href="/movies/details/${movie.id}" class="btn btn-primary">Details</a>
                                <a href="/movies/update/${movie.id}" class="btn btn-warning">Edit</a>
                                <a href="/movies/delete/${movie.id}" class="btn btn-danger">Delete</a>
                            </div>
                        </div>
                    `;
                    movieList.appendChild(movieDiv);
                });
            });
    }
});

