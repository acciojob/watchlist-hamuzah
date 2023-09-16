import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

    public void pairMovieDirector(String movieName, String directorName) {
        movieRepository.pairMovieDirector(movieName, directorName);
    }

    public Movie getMovieByName(String movieName) {
        Movie movie = movieRepository.getMovieByName(movieName);
        return movie;
    }

    public Director getDirectorByName(String directorName) {
        return movieRepository.getDirectorByName(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        return movieRepository.getMovieByDirectorName(directorName);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorAndMoviesByName(String directorName) {
        movieRepository.deleteDirectorAndMoviesByName(directorName);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}