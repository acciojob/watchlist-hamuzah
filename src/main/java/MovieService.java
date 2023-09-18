import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie) {
      String movieadd = movieRepository.addMovie(movie);

      return movieadd;
    }

    public String addDirector(Director director) {
     String directoradd = movieRepository.addDirector(director);

     return directoradd;
    }

    public String addMovieDirectorPair(String movie, String director) {
       String movieDirectorPair = movieRepository.addMovieDirectorPair(movie,director);

       return movieDirectorPair;

    }

    public Movie getMovieByName(String movieName) {
        Movie movie = movieRepository.getMovieByName(movieName);

        return  movie;
    }

    public Director getDirectorByName(String directorName) {
        Director director = movieRepository.getDirectorByName(directorName);

        return director;
    }

    public List<String> getMoviesByDirectorName(String directorname) {
       List<String> lis = movieRepository.getMoviesByDirectorName(directorname);

       return lis;
    }

    public List<String> findAllMovies() {
         List<String>list = movieRepository.findAllMovies();

         return  list;
    }

    public String deleteDirectorByName(String directorName) {
        String deletedirectorname = movieRepository.deleteDirectorByName(directorName);

        return deletedirectorname;
    }

    public String deleteAllDirectors() {
      String deleteAll = movieRepository.deleteAllDirectors();

      return deleteAll;
    }
}