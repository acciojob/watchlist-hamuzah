import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository

public class MovieRepository {

    HashMap<String,Movie>moviesDb = new HashMap<>();

    HashMap<String,Director>directorDb = new HashMap<>();

    HashMap<String,List<String>>directormovieDb = new HashMap<>();



    public String addMovie(Movie movie) {
        String val = movie.getName();

        moviesDb.put(val,movie);

        return "movie added successfully";
    }

    public String addDirector(Director director) {
        String val = director.getName();

        directorDb.put(val,director);

        return  "director added successfully";
    }

    public String addMovieDirectorPair(String movie, String director) {
        if(directormovieDb.containsKey(director)){
            List<String>list = directormovieDb.get(director);
            list.add(movie);
            directormovieDb.put(director,list);
        }else{
            List<String>list = new ArrayList<>();
            list.add(movie);
            directormovieDb.put(director,list);

        }
        return "new director movie pair added";

    }

    public Movie getMovieByName(String movieName) {

        return moviesDb.get(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return  directorDb.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorname) {
        List<String>listmovie = directormovieDb.get(directorname);
        return listmovie;
      }

    public List<String> findAllMovies() {
        List<String>list = new ArrayList<>();
        for(String mvr : moviesDb.keySet()){
            list.add(mvr);
        }
        return list;
    }

    public String deleteDirectorByName(String directorName) {
        List<String>moviess = directormovieDb.get(directorName);
        for(String mov: moviess){
            moviesDb.remove(mov);
        }
        directormovieDb.remove(directorName);
        directorDb.remove(directorName);

        return "director deleted";
    }

    public String deleteAllDirectors() {
        for (String s: directorDb.keySet()){
            List<String> movie = directormovieDb.get(s);
            for (String str : movie) {

                moviesDb.remove(str);
            }
            directormovieDb.remove(s);
            directorDb.remove(s);
        }
        return "All directors deleted";
    }
}