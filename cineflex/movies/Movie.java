package cineflex.movies;

public class Movie {
    private String name;
    private String[] schedules;
    private int rooms;
    private float price;
    private float coins;
    private float price_3D;
    public Seats[] seats;

    public Movie(String name, String[] schedules, int rooms, float price, float coins, int j) {
        
        this.seats = new Seats[3];
        for (int i = 0; i < 3; i++) {
            this.seats[i] = new Seats(new boolean[5][5]);
        }
        
        this.name = name;
        this.schedules = schedules;
        this.rooms = rooms;
        this.price = price;
        this.coins = coins;
        this.price_3D = 4.0f;
    
    }

    public float getCoins() {
        return coins;
    }

    public void setCoins(float coins) {
        this.coins = coins;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSchedules(int i) {
        return schedules[i];
    }

    public void setSchedules(String[] schedules) {
        this.schedules = schedules;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int room) {
        this.rooms = room;
    }

}
