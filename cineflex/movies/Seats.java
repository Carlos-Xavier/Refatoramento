package cineflex.movies;

public class Seats {
    private boolean seats[][];

    public Seats(boolean[][] seats) {
        this.seats = seats;
    }
    
    public boolean getSeats(int i, int j) {
        return seats[i][j];
    }

    public void setSeats(int i, int j, boolean seats) {
        this.seats[i][j] = seats;
    }
}
