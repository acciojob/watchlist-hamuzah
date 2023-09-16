import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String, Movie> movieHashMap = new HashMap<>();

    HashMap<String, Director> directorHashMap = new HashMap<>();

    HashMap<String, List<Movie>> directorMovieList = new HashMap<>();
    // director Name -> Movies


    public void addMovie(Movie movie){
        String movieName = movie.getName();

        movieHashMap.put(movieName,movie);
    }

    public void addDirector(Director director){
        String directorName = director.getName();
        List<Movie> movieList = new ArrayList<>();
        directorMovieList.put(directorName,movieList);
        directorHashMap.put(directorName,director);
    }

    public void pairMovieDirector(String movieName,String directorName){
        Movie movie = movieHashMap.get(movieName);
        Director director = directorHashMap.get(directorName);

        List<Movie> movieList = directorMovieList.get(directorName);

        movieList.add(movie);

        directorMovieList.put(directorName,movieList);
    }

    public Movie getMovieByName(String movieName){
        Movie movie = movieHashMap.get(movieName);
        return movie;
    }

    public Director getDirectorByName(String directorName){
        return directorHashMap.get(directorName);
    }

    public List<String> getMovieByDirectorName(String directorName){
        List<Movie> movieList =  directorMovieList.get(directorName);
        List<String> movieNameList = new ArrayList<>();

        for(Movie movie : movieList){
            movieNameList.add(movie.getName());
        }

        return movieNameList;
    }

    public List<String > findAllMovies(){
        List<String > list = new ArrayList<>();

        for(String movie : movieHashMap.keySet()){
            list.add(movie);
        }
        return list;
    }

    public void deleteDirectorAndMoviesByName(String directorName){
        Director director = directorHashMap.get(directorName);

        List<Movie> list = directorMovieList.get(directorName);

        for(Movie movie:list){
            movieHashMap.remove(movie.getName());
        }

        directorMovieList.remove(directorName);

        directorHashMap.remove(directorName);

    }

    public void deleteAllDirectors(){

        for(List<Movie> movieList : directorMovieList.values()){
            for(Movie movie : movieList){
                movieHashMap.remove(movie.getName());
            }
        }

        directorMovieList = new HashMap<>();
        directorHashMap = new HashMap<>();
    }
}