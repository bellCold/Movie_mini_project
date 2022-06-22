package model;

public class GradeDTO {
    private int id;
    private String writerId;
    private int movieAvgScore;
    private String movieReview;
    private int expertScore;

    public int getExpertScore() {
        return expertScore;
    }

    public void setExpertScore(int expertScore) {
        this.expertScore = expertScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
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
