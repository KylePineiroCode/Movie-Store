package org.example;

class Movie {
    private String title;
    private String leadActorActress;
    private int releaseYear;
    private String genre;

    public Movie(String title, String leadActorActress, int releaseYear, String genre) {
        this.title = title;
        this.leadActorActress = leadActorActress;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }
    public String getTitle()
    {
        return this.title;
    }
    public String getLeadActorActress()
    {
        return this.leadActorActress;
    }
    public int getYear()
    {
        return this.releaseYear;
    }
    public String getGenre()
    {
        return this.genre;
    }


    public String toString() {
        return "Title: " + title + ", Lead Actor/Actress: " + leadActorActress + ", Year: " + releaseYear + ", Genre: " + genre;
    }
}
