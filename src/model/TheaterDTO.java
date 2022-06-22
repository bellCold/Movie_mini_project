package model;

public class TheaterDTO {
    private int id;
    private String theaterName;
    private String theaterLocation;
    private String theaterNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterLocation() {
        return theaterLocation;
    }

    public void setTheaterLocation(String theaterLocation) {
        this.theaterLocation = theaterLocation;
    }

    public String getTheaterNumber() {
        return theaterNumber;
    }

    public void setTheaterNumber(String theaterNumber) {
        this.theaterNumber = theaterNumber;
    }

    public TheaterDTO(TheaterDTO origin) {
        this.id = origin.id;
        this.theaterName = origin.theaterName;
        this.theaterLocation = origin.theaterLocation;
        this.theaterNumber = origin.theaterNumber;
    }

    public TheaterDTO() {
    }

    public TheaterDTO(int id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (o instanceof TheaterDTO) {
            TheaterDTO t = (TheaterDTO) o;
            return id == t.id;
        }
        return false;
    }
}
