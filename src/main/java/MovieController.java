import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
     public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String movieadd = movieService.addMovie(movie);

        return new ResponseEntity<>(movieadd, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
     public ResponseEntity<String> addDirector(@RequestBody Director director){
        String directoradd = movieService.addDirector(director);

        return new ResponseEntity<>(directoradd,HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
     public ResponseEntity<String>  addMovieDirectorPair(@RequestParam("movie")String movie,@RequestParam("director")String director){
        String movieDirectorPair = movieService.addMovieDirectorPair(movie,director);

        return new ResponseEntity<>(movieDirectorPair,HttpStatus.CREATED);
    }

    @GetMapping("get-movie-by-name/{name}")
     public ResponseEntity<Movie>getMovieByName(@PathVariable("movie")String movieName){
        Movie movie = movieService.getMovieByName(movieName);

        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("get-director-by-name/{name}")
     public ResponseEntity<Director>getDirectorByName(@PathVariable("director")String directorName){
        Director director = movieService.getDirectorByName(directorName);

        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @GetMapping("get-movies-by-director-name/{director}")
    public  ResponseEntity<List<String>>getMoviesByDirectorName(@PathVariable("director")String director){
        List<String> movie = movieService.getMoviesByDirectorName(director);

        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
       List<String>movielist = movieService.findAllMovies();

       return new ResponseEntity<>(movielist,HttpStatus.CREATED);
    }

    @DeleteMapping("delete-director-by-name")
     public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorname") String directorName){
        String directorremove = movieService.deleteDirectorByName(directorName);

        return new ResponseEntity<>(directorremove,HttpStatus.CREATED);
    }

    @DeleteMapping("delete-all-directors")
      public ResponseEntity<String>deleteAllDirectors(){
        String directordelete = movieService.deleteAllDirectors();

        return new ResponseEntity<>(directordelete,HttpStatus.CREATED);
    }



}