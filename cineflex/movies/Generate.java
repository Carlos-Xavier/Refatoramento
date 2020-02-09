package cineflex.movies;

import cineflex.days.Money;
import cineflex.days.Coin;
import cineflex.days.Days;
import cineflex.manager.Messages;
import cineflex.food.Food;

public final class Generate {
    private static Movies[] movie;
    private static Food[] food;
    private static float money;
    private static float coin;

    public static float getPrice() {
        return Generate.money;
    }

    public static Movies[] generateMovie() {
        String[] names = {"Predador", "Coringa", "Vidro", "Hellboy", "Vingadores"};
        String[][] schedules = {{"8:15", "10:45", "14:15"},
                               {"9:15", "11:30", "22:30"},
                               {"10:40", "13:45", "16:30"},
                               {"13:20", "18:45", "21:00"},
                               {"19:15", "21:50", "17:15"}};
        int rooms[] = {1, 2, 3, 4, 5};
        
        Generate.movie = new Movies[5];
        
        int j = Days.random();
        System.out.print(Messages.day(Days.getDay(j)));
        
        Money money = new Money();
        Generate.money = money.getDayPrice(j);
        
        Coin coin = new Coin();
        Generate.coin = coin.getDayPrice(j);
        
        for (int i = 0; i < 5; i++) {
            Generate.movie[i] = new Movies(Generate.movie, names[i], schedules[i], rooms[i], Generate.money, Generate.coin, i);
        }
        return Generate.movie;
    }
    
    public static Food[] generateFood() {
        Generate.food = new Food[3];
        
        Generate.food[0] = new Food(6.99f, "Bebida");
        Generate.food[1] = new Food(8.50f, "Pipoca");
        Generate.food[2] = new Food(3.99f, "Doce");
        
        return Generate.food;
    }
}