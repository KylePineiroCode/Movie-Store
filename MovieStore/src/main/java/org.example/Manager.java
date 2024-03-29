package org.example;


class Manager {
    private MovieStore store;
    //private String Movies;
    public Manager() {
        store = new MovieStore();
    }

    public void addMovie(String title, String leadActorActress, int releaseYear, String genre) {
        Movie movie = new Movie(title, leadActorActress, releaseYear, genre);
        store.addMovie(movie);
    }

    public boolean removeMovie(String title) {
        return store.removeMovie(title);
    }



}
