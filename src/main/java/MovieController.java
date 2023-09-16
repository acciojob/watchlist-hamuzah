import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity("Movie Successfully added!", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity("Director has been successfully added",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){
        movieService.pairMovieDirector(movieName,directorName);
        return new ResponseEntity("Movie-Director Pair Successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String movieName){
        Movie movie = movieService.getMovieByName(movieName);
        return new ResponseEntity(movie,HttpStatus.FOUND);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String directorName){
        Director director = movieService.getDirectorByName(directorName);
        return new ResponseEntity(director,HttpStatus.FOUND);
    }

    @GetMapping("get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String directorName){
        List<String> listOfMovies = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity(listOfMovies,HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> list = movieService.findAllMovies();
        return new ResponseEntity(list,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String directorName){
        movieService.deleteDirectorAndMoviesByName(directorName);
        return new ResponseEntity("Director and his Movies are deleted from records!",HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity("All Directors and Movies are deleted!", HttpStatus.ACCEPTED);
    }

}