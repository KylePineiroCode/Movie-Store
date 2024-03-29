package org.example;

import java.util.ArrayList;
class MovieStore {
    private ArrayList<Movie> movies;

    public MovieStore() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public boolean removeMovie(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                movies.remove(movie);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<Movie> searchMovies(String query) {
        ArrayList<Movie> results = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().contains(query) || movie.getLeadActorActress().contains(query) || movie.getGenre().contains(query)) {
                results.add(movie);
            }
        }
        return results;
    }
}
