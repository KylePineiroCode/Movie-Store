package org.example;

import java.util.ArrayList;
class Customer {
    private MovieStore store;

    public Customer() {
        store = new MovieStore();
    }

    public ArrayList<Movie> getMovies() {
        return store.getMovies();
    }

    public ArrayList<Movie> searchMovies(String query) {
        return store.searchMovies(query);
    }

}
