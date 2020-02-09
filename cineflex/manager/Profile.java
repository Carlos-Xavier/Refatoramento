package cineflex.manager;

import cineflex.movies.Movies;
import cineflex.exceptions.Exceptions;
import java.util.Scanner;

public final class Profile extends Register {
    Scanner enter = new Scanner(System.in);
    private String gender, city;
    private int age;
    
    public Profile(Profile[] p) {
        super(p); 
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void manageProfile() {
        System.out.print(Messages.manage(this.getName(), this.getAge(), this.getGender(), 
                this.getCity(), this.getEmail(), this.getPassword(), this.getType()));
        
        int item = Exceptions.intNum();
        switch(item) {
            case 1: 
                this.setName(enter.nextLine());
                break;
            case 2:
                this.setAge(Exceptions.intNum());
                break;
            case 3:
                this.setGender(enter.nextLine());
                break;
            case 4:
                this.setCity(enter.nextLine());
                break;
            case 5:
                this.setPassword(enter.nextLine());
                break;
            default:
                System.out.println("Este campo não pode ser alterado!");
                break;
        }
    }
    
    public void manageMovies(Movies[] movies, Profile user) {
        for (int i = 0; i < 5; i++)
            movies[i].showMovies(i);
        
        System.out.println("Qual filme deseja assitir? ");
        int num = Exceptions.intNum();
        if (num > 0 && num < 6) {
            movies[num-1].buyTicket(num-1, user);
        } else {
            System.out.println("Opção inválida!");
        } 
    }
    
    public void purchasesHistoric(Profile user) {
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            if (this.getHistoric(i, 0) != null) {
                System.out.print(Messages.historic(i, user));
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Você não comprou nenhum ingresso!");
        }
    }
    
    public int getMovieIndex(Movies[] movie) {
        System.out.println("Digite o nome do filme que quer cancelar: ");
        String name = enter.nextLine();
        
        int id = -1;
        for (int i = 0; i < 5; i++) {
            if (movie[i].getName().equals(name)) {
                id = i;
            }
        }
        if (id == -1) {
            System.out.println("Você não comprou ingresso para esse filme!");
        }
        
        return id;
    }
    
    public int getRoomIndex(Movies[] movie, int id, int i) {
        for (int j = 0; j < 3; j++) {
            if (movie[id].getSchedules(j).equals(this.getHistoric(i, 1))) {
                return j;
            }
        }
        return 0;
    }
    
    public void setMoney(int i) {
        if (this.getHistoric(i, 2) != null) {
            float aux = Float.parseFloat(this.getHistoric(i, 2));
            this.getType().setMoney(this.getType().getMoney() + aux);
                            
        } else {
            float aux = Float.parseFloat(this.getHistoric(i, 3));
            this.getType().setCoins(this.getType().getCoins() + aux);
        }
    }
    
    public void setSeats(int i, int id, Movies[] movie) {
        int room = getRoomIndex(movie, id, i);
        System.out.println("sala: " + movie[id].getSchedules(room));
        
        int m = Integer.parseInt(this.getHistoric(i, 4));
        int n = Integer.parseInt(this.getHistoric(i, 5));
                        
        int idSeat = movie[id].seatIndex(movie[id].getSchedules(room), id);
        movie[id].seats[idSeat].setSeats(m, n, false);
    }
    
    public void cancelPurchase(Movies[] movie) {
        int id = getMovieIndex(movie);
        if (id != -1) {
            System.out.println("movie: " + id);
            for (int i = 0; i < 10; i++) {
                if (this.getHistoric(i, 0) != null) {
                    if (this.getHistoric(i, 0).equals(movie[id].getName())) {
                        
                        setMoney(i);
                        setSeats(i, id, movie);
                        
                        this.setHistoric(i, 0, null);
                        this.setHistoric(i, 1, null);
                        this.setHistoric(i, 2, null);
                        this.setHistoric(i, 3, null);
                                
                        this.getType().setCoins((this.getType().getCoins()) - 1);
                        break;
                    }
                }
            }
            System.out.println("Compra Cancelada!");
        }
    }
    
    public void panel(Movies[] movies, Profile user) {
        System.out.print(Messages.panel());
        
        int num = Exceptions.intNum();
        switch(num) {
            case 1: 
                manageProfile();
                break;
            case 2:
                manageMovies(movies, user);
                break;
            case 3:
                this.purchasesHistoric(user);
                break;
            case 4:
                cancelPurchase(movies);
                break;
            default:
                return;
        }
        panel(movies, user);
    }
    
}