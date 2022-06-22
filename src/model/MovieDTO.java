package model;

public class MovieDTO {
    private int id;
    private String movieName;
    private String movieSummary;
    private int movieGrade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieSummary() {
        return movieSummary;
    }

    public void setMovieSummary(String movieSummary) {
        this.movieSummary = movieSummary;
    }

    public int getMovieGrade() {
        return movieGrade;
    }

    public void setMovieGrade(int movieGrade) {
        this.movieGrade = movieGrade;
    }

    public MovieDTO(MovieDTO origin) {
        this.id = origin.id;
        this.movieName = origin.movieName;
        this.movieSummary = origin.movieSummary;
        this.movieGrade = origin.movieGrade;
    }

    public MovieDTO() {
    }

    public MovieDTO(int id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (o instanceof MovieDTO) {
            MovieDTO m = (MovieDTO) o;
            return id == m.id;
        }
        return false;
    }
}
