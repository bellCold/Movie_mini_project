package model;

public class TimeDTO {
    private int id;
    private int movieNum;
    private int theaterNum;
    private String movieTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieNum() {
        return movieNum;
    }

    public void setMovieNum(int movieNum) {
        this.movieNum = movieNum;
    }

    public int getTheaterNum() {
        return theaterNum;
    }

    public void setTheaterNum(int theaterNum) {
        this.theaterNum = theaterNum;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public TimeDTO() {
    }

    public TimeDTO(TimeDTO origin) {
        this.id = origin.id;
        this.movieTime = origin.movieTime;
        this.theaterNum = origin.theaterNum;
        this.movieNum = origin.movieNum;
    }

    public TimeDTO(int id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (o instanceof TimeDTO) {
            TimeDTO t = (TimeDTO) o;
            return id == t.id;
        }
        return false;
    }
}
