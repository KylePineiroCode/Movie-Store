package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        String yN;
        String managerPassword="Broncos541$";
        Manager movieManager = new Manager();
        Customer customer = new Customer();
        ArrayList<Movie> storeManager = new ArrayList<Movie>();
        storeManager.add(new Movie("Titanic", "Kate Winslet", 1997, "Romance"));
        storeManager.add(new Movie("A Walk to Remember", "Shane West", 2002, "Romance"));
        storeManager.add(new Movie("Walk the Line", "Joaquin Phoenix", 2005, "Romance"));
        storeManager.add(new Movie("Star Wars", "Mark Hamill", 1977, "Sci-Fi"));
        storeManager.add(new Movie("Rocky", "Syllvester Stallone", 1976, "Action"));
        storeManager.add(new Movie("Terminator", "Arnold Schwarzenegger", 1984, "Action"));
        storeManager.add(new Movie("Speed", "Keanu Reeves", 1994, "Action"));
        storeManager.add(new Movie("Grown Ups", "Adam Sandler", 2009, "Comedy"));
        storeManager.add(new Movie("Billy Madison", "Adam Sandler", 1995, "Comedy"));
        storeManager.add(new Movie("Fatherhood", "Kevin Hard", 2021, "Comedy"));
        storeManager.add(new Movie("The Deliberate Stranger", "Timothy Gibbs", 1986, "Crime"));
        storeManager.add(new Movie("Shawshank Redemption", "Tim Robbins", 1994, "Crime"));
        storeManager.add(new Movie("The Life of David Gale", "Kevin Spacey", 2003, "Crime"));
        storeManager.add(new Movie("IT", "Richard Thomas", 1990, "Horror"));
        storeManager.add(new Movie("Saw", "Cary Elwes", 2004, "Horror"));
        storeManager.add(new Movie("Friday the 13th", "Ari Lehman", 1980, "Horror"));
        storeManager.add(new Movie("Forrest Gump", "Tom Hanks", 1994, "Drama"));
        storeManager.add(new Movie("Sully", "Tom Hanks", 2016, "Drama"));
        storeManager.add(new Movie("The Color Purple", "Danny Glover", 1985, "Drama"));
        System.out.println("Welcome to the movie store!");


        do {
            String answer = "";
            boolean validAnswer = false;
            while (!validAnswer) {
                System.out.println("Are you a manager or a customer?");
                answer = s.nextLine().toLowerCase();
                if (answer.equals("manager")) {
                    System.out.println("Please enter the manager password:");
                    String password = s.nextLine();
                    if (password.equals(managerPassword)) {
                        validAnswer = true;
                        System.out.println("Welcome, manager. What would you like to do? Select using 1 or 2");
                        for (Movie movie : storeManager) {
                            System.out.println(movie);
                        }
                        System.out.println("1. Add a movie");
                        System.out.println("2. Remove a movie");
                        int choice = 0;
                        boolean validChoice = false;

                        while (!validChoice) {
                            if (s.hasNextInt()) {
                                choice = s.nextInt();
                                if (choice == 1 || choice == 2) {
                                    validChoice = true;
                                } else {
                                    System.out.println("Invalid input. Please select using 1 or 2.");
                                }
                            } else {
                                s.next();
                                System.out.println("Invalid input. Please select using 1 or 2.");
                            }
                        }
                        s.nextLine();

                        if (choice == 1) {
                            System.out.println("You chose add movies.");
                        } if (choice == 2) {
                            System.out.println("You chose remove movie.");
                        }
                        switch (choice) {
                            case 1:
                                System.out.println("How many movies would you like to add?");
                                int numMoviesToAdd = 0;
                                while (true) {
                                    if (s.hasNextInt()) {
                                        numMoviesToAdd = s.nextInt();
                                        if (numMoviesToAdd > 0) {
                                            break;
                                        } else {
                                            System.out.println("Invalid input. Please enter a positive integer:");
                                        }
                                    } else {
                                        System.out.println("Invalid input. Please enter a positive integer:");
                                        s.nextLine();
                                    }
                                }
                                s.nextLine();
                                for (int i = 0; i < numMoviesToAdd; i++) {
                                    System.out.println("Please enter the movie title:");
                                    String title = s.nextLine();
                                    System.out.println("Please enter the lead actor/actress:");
                                    String leadActor = s.nextLine();
                                    System.out.println("Please enter the release year:");
                                    int year = s.nextInt();
                                    s.nextLine();
                                    System.out.println("Please enter the genre:");
                                    String genre = s.nextLine();
                                    movieManager.addMovie(title, leadActor, year, genre);
                                }
                                break;
                            case 2:
                                System.out.println("How many movies would you like to remove?");
                                int numMoviesToRemove = 0;
                                while (true) {
                                    if (s.hasNextInt()) {
                                        numMoviesToRemove = s.nextInt();
                                        if (numMoviesToRemove > 0) {
                                            break;
                                        } else {
                                            System.out.println("Invalid input. Please enter a positive integer:");
                                        }
                                    } else {
                                        System.out.println("Invalid input. Please enter a positive integer:");
                                        s.nextLine();
                                    }
                                }
                                s.nextLine();
                                for (int i = 0; i < numMoviesToRemove; i++) {
                                    System.out.println("Please enter the movie title to remove:");
                                    String titleToRemove = s.nextLine();
                                    movieManager.removeMovie(titleToRemove);
                                }
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    else{
                        System.out.println("Invalid password. Please try again.");
                    }
                } else if (answer.equals("customer")) {
                    validAnswer = true;
                    System.out.println("Would you like to view all of our movies or look at one movie?");
                    String yN2 = s.nextLine();
                    while (!yN2.equalsIgnoreCase("all") && !yN2.equalsIgnoreCase("one")) {
                        System.out.println("Invalid input. Please enter 'all' or 'one': ");
                        yN2 = s.nextLine();
                    }
                    if(yN2.equalsIgnoreCase("one"))
                    {
                        System.out.println("What movie would you like to purchase?");
                        String movieSelection = s.nextLine();
                        boolean movieExists = false;
                        for (Movie movie : storeManager) {
                            if (movieSelection.equalsIgnoreCase(movie.getTitle())) {
                                movieExists = true;
                                break;
                            }
                        }

                        if (movieExists) {
                            System.out.println("Movie found!");

                        } else {
                            System.out.println("Sorry, that movie is not available in our store.");
                        }
                    }
                    else if(yN2.equalsIgnoreCase("all")){
                        for (Movie movie : storeManager) {
                            System.out.println(movie);
                        }
                        System.out.println("Hello customer! How would you like to sort your movies today? Select using a number.(1-4)");
                        System.out.println("1.Movie Title");
                        System.out.println("2.Lead actor/actress");
                        System.out.println("3.Genre");
                        System.out.println("4.Year");
                        int sort = 0;
                        while (sort < 1 || sort > 4) {
                            System.out.print("Enter your choice: ");
                            if (s.hasNextInt()) {
                                sort = s.nextInt();
                                if (sort < 1 || sort > 4) {
                                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                                }
                            } else {
                                s.next();
                                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                            }
                        }
                        s.nextLine();
                        switch (sort){
                            case 1:
                                Scanner s2 = new Scanner (System.in);
                                System.out.println("Would you like your movies ascending or descending by title?");
                                String titleS = s2.nextLine();
                                while (!titleS.equalsIgnoreCase("ascending") && !titleS.equalsIgnoreCase("descending")) {
                                    System.out.println("Invalid input. Please enter either 'ascending' or 'descending'.");
                                    titleS= s2.nextLine();
                                }
                                if(titleS.equalsIgnoreCase("ascending"))

                                {System.out.println("Movie titles ascending are:");

                                    Collections.sort(storeManager, new Comparator<Movie>() {
                                        public int compare(Movie m1, Movie m2) {
                                            return m1.getTitle().compareTo(m2.getTitle());
                                        }
                                    });
                                    for(Movie movie: storeManager) {
                                        System.out.println(movie);
                                    }

                                    System.out.println("What movie would you like to purchase?");
                                    String purchase = s.nextLine();
                                    System.out.println("You want to purchase " + purchase + " that will be $19.99 USD.");
                                    System.out.println("Thank you for your purchase");
                                }
                                else if(titleS.equalsIgnoreCase("descending"))
                                {System.out.println("Movie titles descending are:");
                                    Collections.sort(storeManager, new Comparator<Movie>() {
                                        public int compare(Movie m1, Movie m2) {
                                            return m2.getTitle().compareTo(m1.getTitle());
                                        }
                                    });
                                    for(Movie movie: storeManager) {
                                        System.out.println(movie);
                                    }
                                    System.out.println("What movie would you like to purchase?");
                                    String purchase = s.nextLine();
                                    System.out.println("You want to purchase " + purchase + " that will be $19.99 USD.");
                                    System.out.println("Thank you for your purchase");
                                }
                                break ;
                            case 2:
                                Scanner s3 = new Scanner (System.in);
                                System.out.println("Would you like to have lead actor/actress ascending or descending?");
                                String lActor= s3.nextLine();
                                while (!lActor.equalsIgnoreCase("ascending") && !lActor.equalsIgnoreCase("descending")) {
                                    System.out.println("Invalid input. Please enter either 'ascending' or 'descending'.");
                                    lActor= s3.nextLine();
                                }
                                if(lActor.equalsIgnoreCase("ascending"))

                                {System.out.println("Movie lead actor/actress ascending are:");

                                    Collections.sort(storeManager, new Comparator<Movie>() {
                                        public int compare(Movie m1, Movie m2) {
                                            return m1.getLeadActorActress().compareTo(m2.getLeadActorActress());
                                        }
                                    });
                                    for(Movie movie: storeManager) {
                                        System.out.println(movie);
                                    }

                                    System.out.println("What movie would you like to purchase?");
                                    String purchase = s3.nextLine();
                                    System.out.println("You want to purchase " + purchase + " that will be $19.99 USD.");
                                    System.out.println("Thank you for your purchase");
                                }
                                else if(lActor.equalsIgnoreCase("descending"))
                                {System.out.println("Movie lead actor.actress descending are:");
                                    Collections.sort(storeManager, new Comparator<Movie>() {
                                        public int compare(Movie m1, Movie m2) {
                                            return m2.getLeadActorActress().compareTo(m1.getLeadActorActress());
                                        }
                                    });
                                    for(Movie movie: storeManager) {
                                        System.out.println(movie);
                                    }
                                    System.out.println("What movie would you like to purchase?");
                                    String purchase = s.nextLine();
                                    System.out.println("You want to purchase " + purchase + " that will be $19.99 USD.");
                                    System.out.println("Thank you for your purchase");
                                }
                                break ;
                            case 3:
                                Scanner s4= new Scanner(System.in);
                                System.out.println("Would you like to have genre ascending or descending?");
                                String genre = s4.nextLine();
                                while (!genre.equalsIgnoreCase("ascending") && !genre.equalsIgnoreCase("descending")) {
                                    System.out.println("Invalid input. Please enter either 'ascending' or 'descending'.");
                                    genre= s4.nextLine();
                                }
                                if(genre.equalsIgnoreCase("ascending"))

                                {System.out.println("Movie genres ascending are:");

                                    Collections.sort(storeManager, new Comparator<Movie>() {
                                        public int compare(Movie m1, Movie m2) {
                                            return m1.getGenre().compareTo(m2.getGenre());
                                        }
                                    });
                                    for(Movie movie: storeManager) {
                                        System.out.println(movie);
                                    }
                                    System.out.println("What movie would you like to purchase?");
                                    String purchase = s4.nextLine();
                                    System.out.println("You want to purchase " + purchase + " that will be $19.99 USD.");
                                    System.out.println("Thank you for your purchase");
                                }
                                else if(genre.equalsIgnoreCase("descending"))
                                {System.out.println("Movie genres descending are:");
                                    Collections.sort(storeManager, new Comparator<Movie>() {
                                        public int compare(Movie m1, Movie m2) {
                                            return m2.getGenre().compareTo(m1.getGenre());
                                        }
                                    });
                                    for(Movie movie: storeManager) {
                                        System.out.println(movie);
                                    }
                                    System.out.println("What movie would you like to purchase?");
                                    String purchase = s4.nextLine();
                                    System.out.println("You want to purchase " + purchase + " that will be $19.99 USD.");
                                    System.out.println("Thank you for your purchase");
                                }
                                break ;
                            case 4:
                                Scanner s5 = new Scanner (System.in);
                                System.out.println("Would you like your movies ascending or descending?");
                                String year = s5.nextLine();
                                while (!year.equalsIgnoreCase("ascending") && !year.equalsIgnoreCase("descending")) {
                                    System.out.println("Invalid input. Please enter either 'ascending' or 'descending'.");
                                    year= s5.nextLine();
                                }
                                if(year.equalsIgnoreCase("ascending"))

                                {System.out.println("Movie years ascending are:");

                                    Collections.sort(storeManager, new Comparator<Movie>() {
                                        public int compare(Movie m1, Movie m2) {
                                            return m1.getYear()-(m2.getYear());
                                        }
                                    });
                                    for(Movie movie: storeManager) {
                                        System.out.println(movie);
                                    }

                                    System.out.println("What movie would you like to purchase?");
                                    String purchase = s5.nextLine();
                                    System.out.println("You want to purchase " + purchase + " that will be $19.99 USD.");
                                    System.out.println("Thank you for your purchase");
                                }
                                else if(year.equalsIgnoreCase("descending"))
                                {System.out.println("Movie years descending are:");
                                    Collections.sort(storeManager, new Comparator<Movie>() {
                                        public int compare(Movie m1, Movie m2) {
                                            return m2.getYear()-(m1.getYear());
                                        }
                                    });
                                    for(Movie movie: storeManager) {
                                        System.out.println(movie);
                                    }
                                    System.out.println("What movie would you like to purchase?");
                                    String purchase = s.nextLine();
                                    System.out.println("You want to purchase " + purchase + " that wil be $19.99 USD.");
                                    System.out.println("Thank you for your purchase");
                                }
                        }
                        break ;
                    }} else {
                    System.out.println("Invalid answer. Please enter 'manager' or 'customer'.");
                }
            }
            Scanner s6 = new Scanner (System.in);
            System.out.println("Would you like to continue?(Yes/No)");
            yN = s6.nextLine();
            while (!yN.equalsIgnoreCase("yes") && !yN.equalsIgnoreCase("no")) {
                System.out.println("Invalid input. Please enter either 'yes' or 'no'.");
                yN= s6.nextLine();
            }
        } while(yN.equalsIgnoreCase("yes"));

        if(yN.equalsIgnoreCase("no"))
        {
            System.exit(0);
        }
    }
}

