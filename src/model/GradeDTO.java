package model;

public class GradeDTO {
    private int id;
    private int writerId;
    private int movieNumber;
    private int movieAvgScore;
    private String movieReview;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public int getMovieNumber() {
        return movieNumber;
    }

    public void setMovieNumber(int movieNumber) {
        this.movieNumber = movieNumber;
    }

    public int getMovieAvgScore() {
        return movieAvgScore;
    }

    public void setMovieAvgScore(int movieAvgScore) {
        this.movieAvgScore = movieAvgScore;
    }

    public String getMovieReview() {
        return movieReview;
    }

    public void setMovieReview(String movieReview) {
        this.movieReview = movieReview;
    }

    public GradeDTO(GradeDTO origin) {
        this.id = origin.id;
        this.movieAvgScore = origin.movieAvgScore;
        this.movieNumber = origin.movieNumber;
        this.movieReview = origin.movieReview;
        this.writerId = origin.writerId;
    }

    public GradeDTO() {
    }

    public GradeDTO(int id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (o instanceof GradeDTO) {
            GradeDTO g = (GradeDTO) o;
            return id == g.id;
        }
        return false;
    }
}
